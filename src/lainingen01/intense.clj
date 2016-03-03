(ns lainingen01.intense
  (:require [clojure.string :as str]))

(def numbers '(0 1 2 3 4 5 6 7 8 9))
(def low-letters '("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"))

(defn capital-letters []
  (map str/capitalize low-letters))

(defn all-characters []
  (concat numbers low-letters (capital-letters)))

(count (all-characters))

(loop [x 0]
  (if (= x (count (all-characters)))
    (str "Kraj " (java.lang.Thread/currentThread))
    (do
      (println 
        (nth (all-characters) x))
      (recur (inc x)))))


(def foo (atom {:blah "this"}))
@foo
(swap! foo (fn [old] 
             (println old)
             (inc old)))
(swap! foo inc)

(pmap
  (fn [_] (swap! foo inc))
  (range 10000))

(def bar (atom 0))
(def call-counter (atom 0))

(defn slow-inc-with-call-count [x]
  (swap! call-counter inc)
  (java.lang.Thread/sleep 100)
  (println x)
  (inc x))

(pmap
  (fn [_] 
    (swap! bar slow-inc-with-call-count))
  (range 100))

@call-counter


9