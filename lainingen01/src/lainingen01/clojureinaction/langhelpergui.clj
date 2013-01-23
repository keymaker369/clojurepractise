(ns lainingen01.clojureinaction.langhelpergui
  (:use seesaw.core)
  (:use seesaw.border))

(def f (frame :title "Language helpersss"  :size [400 :by 400] 
              :content (canvas :id :canvas :background "#BBBBBB")))

(-> f pack! show!)

(defn display [content]
  (config! f :content content)
  content)

(def word (text :multi-line? false :font "MONOSPACED-PLAIN-14" :text "guessing text"))

(def result (text :multi-line? true :font "MONOSPACED-PLAIN-14" :text "result"))

(def b1 (button :text "Click Me"))
(def b2 (button :text "Click Me"))
(def b3 (button :text "Click Me"))
(def b4 (button :text "Click Me"))
(def b5 (button :text "Click Me"))

(def split (left-right-split (scrollable lb) (scrollable area) :divider-location 1/3))
                             
(display (border-panel
           :north word
           :center (vertical-panel :items (list b1 b2 b3 b4 b5))
           :south result
           :vgap 5 :hgap 5 :border 5))

(listen b2 :action (fn [e] (config! b1 :text "ddd33")))

(listen b1 :mouse-entered #(config! % :foreground :black)
          :mouse-exited  #(config! % :foreground :black))

;(*1)

(config! b2 :text "ddd")
(config! word :text "ddd")

(doc text)

(def mapa {:11 22 :333 444})

(get mapa :11) 