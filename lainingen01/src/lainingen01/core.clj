(ns lainingen01.core
  (:gen-class :main true)
  (:use seesaw.core)
  (:use seesaw.border)
  (:use seesaw.chooser))

(require 'clojure.java.io)
(defn load-props
  [file-name]
  (with-open [^java.io.Reader reader (clojure.java.io/reader file-name)] 
    (let [props (java.util.Properties.)]
      (.load props reader)
      (into {} (for [[k v] props] [(keyword k) (read-string v)])))))

;refovi
(def recnik {});(load-props "//c://recnik.properties"))
(def r-not-used (ref recnik))
(def r-odabran (ref {}))
(def r-used (ref {}))

;gui
(def f (frame :title "Language helpersss"  :size [400 :by 400] 
              :content (canvas :id :canvas :background "#BBBBBB")))
(def open-menu-item (menu-item :text "Open"))
(def file-menu (menu :text "File" :items (list open-menu-item)))
(def menu-bar (menubar :items (list file-menu)))
(def word (text :multi-line? false :font "MONOSPACED-PLAIN-14" :text "guessing text"))
(def result (text :multi-line? true :font "MONOSPACED-PLAIN-14" :text "result"))
(def b1 (button :text "Click Me1"))
(def b2 (button :text "Click Me2"))
(def b3 (button :text "Click Me3"))
(def b4 (button :text "Click Me4"))
(def b5 (button :text "Click Me5"))

(defn display [content]
  (content)
  content)
	                             
(config! f :menubar menu-bar 
           :content (border-panel
           :north word
           :center (vertical-panel :items (list b1 b2 b3 b4 b5))
           :south result
           :vgap 5 :hgap 5 :border 5))

;funkcije
(defn select-random
    "Returns a random item from a list of items."
    [options]
    (if (> (count options) 0)
    (nth options (rand-int (count options)))
    nil))

(defn pick-random-amount 
  "Picks some amount of elements from list"
  ([lista amount] 
    (pick-random-amount lista amount (list)))
  ([lista amount rezultat ]
	  (let [picked-elements rezultat
	        odabran (select-random lista)]
	    (if (= amount (count picked-elements))
	    picked-elements
     (do
	    (recur
       (remove #{odabran} lista)
       amount
	     (conj picked-elements odabran)))))))

(defn add-to-map-ref [map-ref key val]
  (dosync (ref-set map-ref (assoc @map-ref key val))))

(defn remove-from-map-ref [map-ref key]
  (dosync (ref-set map-ref (dissoc @map-ref key))))

(defn show []
  (let [five-keys (pick-random-amount (keys @r-not-used) 
                                      (if (> (.size @r-not-used) 5) 5 (.size @r-not-used)))
        random-key (select-random five-keys)]
    (config! word :text (name random-key))
    (add-to-map-ref r-odabran random-key (recnik random-key))
    (remove-from-map-ref r-not-used random-key)
    (loop [keys five-keys buttons (list b1 b2 b3 b4 b5)]
      (if (= 0 (.size keys))
      nil
      (do
        (config! (first buttons) :text (name (recnik (first keys))))
        (recur (remove #{(first keys)} keys) (remove #{(first buttons)} buttons))
        )))
    ))

(defn update-form [loaded-props] 
  (do
    (println loaded-props)
    (def recnik loaded-props))
    (dosync (ref-set r-not-used recnik))
    (dosync (ref-set r-odabran {}))
    (dosync (ref-set r-used {}))
    (show))

(defn uradi [answer]
  (println (.toString answer))
  (let [result-key (first (keys @r-odabran))]
    (println (.toString (recnik result-key)))
    (if (.equals (.toString answer) (.toString (recnik result-key)))
      (do
        (println "tacno")
        (config! result :text "tacno")
        (show))
      (do
        (println "netacno")
        (config! result :text "netacno")
        (remove-from-map-ref r-odabran result-key)
        (add-to-map-ref r-used result-key (recnik result-key))
        (show))))) 

(listen b1 :action (fn [e] (uradi (.getText (.getSource e)))))
(listen b2 :action (fn [e] (uradi (.getText (.getSource e)))))
(listen b3 :action (fn [e] (uradi (.getText (.getSource e)))))
(listen b4 :action (fn [e] (uradi (.getText (.getSource e)))))
(listen b5 :action (fn [e] (uradi (.getText (.getSource e)))))
(listen open-menu-item :action (fn [e] (update-form (load-props (choose-file :success-fn (fn [fc file] (.getAbsolutePath file)))))))





(defn -main
  "I don't do a whole lot."
  [& args]
  (do
    (native!)
    (-> f pack! show!);))
    (show)))


;(-main)
;(listen b1 :mouse-entered #(config! % :foreground :black)
;          :mouse-exited  #(config! % :foreground :black))
;(*1)

