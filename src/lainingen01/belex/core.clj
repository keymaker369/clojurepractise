(ns lainingen01.belex.core
  (:require [clojure.math.combinatorics :as comb])
  (:require [net.cgrand.enlive-html :as enlive-html])
  (:require [lainingen01.belex.parse :as pars]))

(def search-params 
  '("1" "2" "3" "4" "5" "6" "7" "8" "9" "a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "w" "z"))

(def search-links 
  (map #(str "http://www.example.rs/search_s/" %1) search-params))

(defn apply-iteratively 
  "Executes fn on every element in list starting from the begining. 
   Delay is optional"
  ([f list]
    (let [first (first list)]
      (if (empty? list)
        nil
        (do
          (f first)
          (recur f (rest list))))))
  ([f list delay]
    (let [first (first list)]
      (if (empty? list)
        nil
        (do
          (f first)
          (Thread/sleep delay)
          (recur f (rest list) delay))))))

;(#(pars/add-symbols "http://www.example.rs/search_s/2" [:div#content :table :tr :td :p :a]))

;(apply-iteratively 
;  #(pars/add-symbols %1 [:div#content :table :tr :td :p :a]) 
;  search-links 
;  10000)
