(ns lainingen01.belex.core
  (:require [clojure.math.combinatorics :as comb])
  (:require [overtone.at-at :as at]))

(def search-params 
  '("0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "w" "z"))

(def search-links 
  (map #(str "http://www.somewebsite.rs/search_s/" %1) search-params))

(defn visit-links [search-links]
  (map #(println "visiting link " %1) search-links))

(visit-links search-links)


