(ns lainingen01.clojureinaction.langhelpergui
  (:use seesaw.core)
  (:use seesaw.border))

(defn select-random
    "Returns a random item from a list of items."
    [options]
    (nth options (rand-int (count options))))

(defn pick-random-amount 
  "Picks some amount of elements from list"
  ([lista amount] 
    (pick-random-amount lista amount (list)))
  ([lista amount rezultat ]
	  (let [picked-elements rezultat
	        odabran (select-random lista)]
	    (if (= amount (.size picked-elements))
	    picked-elements
	    (recur
       (remove #{odabran} lista)
       amount
	     (conj picked-elements odabran))))))

(def f (frame :title "Language helpersss"  :size [400 :by 400] 
              :content (canvas :id :canvas :background "#BBBBBB")))
(defn display [content]
  (config! f :content content)
  content)

(def word (text :multi-line? false :font "MONOSPACED-PLAIN-14" :text "guessing text"))
(def result (text :multi-line? true :font "MONOSPACED-PLAIN-14" :text "result"))
(def b1 (button :text "Click Me1"))
(def b2 (button :text "Click Me2"))
(def b3 (button :text "Click Me3"))
(def b4 (button :text "Click Me4"))
(def b5 (button :text "Click Me5"))
                             
(display (border-panel
           :north word
           :center (vertical-panel :items (list b1 b2 b3 b4 b5))
           :south result
           :vgap 5 :hgap 5 :border 5))

(-> f pack! show!)
(def src {:1 1111 :22 2222 :3 3333 :4 4444 :5 5555 :6 6666})
(def not-used (ref {:1 1111 :22 2222 :3 3333 :4 4444 :5 5555 :6 6666}))
(def used (ref {}))

(listen b1 :action (fn [e] (println (.getText (.getSource e)))))
(listen b2 :action (fn [e] (println (.getText (.getSource e)))))
(listen b3 :action (fn [e] (println (.getText (.getSource e)))))
(listen b4 :action (fn [e] (println (.getText (.getSource e)))))
(listen b5 :action (fn [e] (println (.getText (.getSource e)))))


	      
  
  
(pick-random-amount (keys src) 3)
(remove #{:1} (keys src))
(defn ddd [a & more] (println))

(ddd 3 4)

(listen b1 :action (fn [e] (config! b1 :text "ddd")))

;(listen b1 :mouse-entered #(config! % :foreground :black)
;          :mouse-exited  #(config! % :foreground :black))

;(*1)

(def my-ref (ref 5))

(dosync (ref-set my-ref 6))

@mymap

(config! b2 :text "ddd")
(config! word :text "ddd")

(doc text)

;(def mapa {:11 22 :333 444})

;(get mapa :11) 