(ns lainingen01.guess-my-number-game
  (:require [clojure.math.numeric-tower :as math]))

;"Clojure implementation of CLISP ash"
(defn ash
  [number shift]
  (if (< shift 0)
    (bit-shift-right number (math/abs shift))
    (bit-shift-left number shift)))

(def small 1)
(def big 100)

(defn guess-my-number []
  (ash (+ small big) -1))

(defn smaller []
  (def big (1- (guess-my-number)))
  (guess-my-number))

(defun bigger []
  (def small (1+ (guess-my-number)))
  (guess-my-number))


(guess-my-number)
(ash 11 1)
(ash 11 -1)