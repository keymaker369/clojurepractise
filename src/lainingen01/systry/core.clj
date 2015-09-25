(ns lainingen01.systry.core
  (require [clj-systemtray.core :as systray]))

(defn fcn [] 
  (println "funkcija"))

(defn another-fn [] 
  (println "funkcija"))

(defn exit-fn [event try-icon] 
  (println event)
  (println "Kraj programa!")
  (systray/remove-tray-icon! try-icon))

(def systray-menu(systray/popup-menu
                    (systray/menu-item :title fcn)
 								    (systray/menu-item "another title" another-fn)
								    (systray/separator)
								    (systray/menu "more options"
								      (systray/menu-item "deep item 1" fcn)
								      (systray/menu-item "deep item 2" fcn)
								      (systray/separator)
								      (systray/menu-item :deep-item-3 fcn))
								    (systray/menu-item :exit-title #(exit-fn %1 try-icon))))

(def try-icon
  (systray/make-tray-icon! "c:\\Users\\nenad/workspace\\clojurepractise\\bulp.gif" systray-menu))

(systray/remove-tray-icon! try-icon)

(#(println %1 systray-menu) "ddd")

