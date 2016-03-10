(ns lainingen01.intense
  (:require [clojure.string :as str])
  (:use mikera.image.colours)
  (:use mikera.image.core)
  (:use mikera.image.filters)
  (:use mikera.image.spectrum)
  (:require [clojure.java.io :refer [resource]]))

(def numbers '(0 1 2 3 4 5 6 7 8 9))
(def low-letters '("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"))

(defn capital-letters []
  (map str/capitalize low-letters))

(defn all-characters []
  (concat numbers low-letters (capital-letters)))

(count (all-characters))

(defn do-something-intense []
  (println 
    (str (java.lang.Thread/currentThread) (new java.util.Date)))
	(loop [x 0]
	  (if (= x 100)
	    (str "Kraj " (java.lang.Thread/currentThread) (new java.util.Date))
	    (do
	      (->
	       (load-image "c:/Users/user/Downloads/wallpapers/infinite-crisis-15456.jpg")
				  (flip :vertical)
				  ((invert))
				  ((brightness 2.0))
				  ((contrast 0.5)))
	      (recur (inc x))))))


