(ns lainingen01.core1)




(defn uradi-dec [input1, brojRedova]	
	(loop [x brojRedova]
	     (if (neg? x)
	     x
	     (do 
	       (println (.concat input1 (.toString x)))
	       (recur (dec x))))))

(defn uradi-inc [text, broj-redova, start-from, append, formater, parameters]	
  (let [buffer (new StringBuffer)]
	  (loop [x start-from]
	    (if (= x broj-redova)
	      (do 
         ;(println ;spit (str "d:/posao-sheme/" text "s.csv") 
          ;     (.toString buffer) 
           ;    );:append append)
         x)
       (do 
         (.append buffer  
                  (formater x text parameters))
         (recur (inc x)))))))

(defn venue-formater [x text parameters]
  (str x "," x "," text x "," text x "," 0 "," 0 "," 0 "," "2012-04-20 14:57:22" "," "2012-04-20 14:57:22" "," "2012-04-20 14:57:22\n"))

(defn event-formater [x text parameters]
  (let [venue-id (first parameters)]
    (str x "," venue-id x "," text x "," text x ",0,0,1," venue-id ", 2012-10-18 12:37:00, 2012-10-18 14:37:00, 0, 0, 1, 0, 1, 1, 1, 1,2012-04-20 14:57:22,2012-04-20 14:57:22,2012-04-20 14:57:22\n")))


(uradi-inc "venue" 201 3 false venue-formater nil)


;(loop [x 1 id-brojac 1]
;  (if (= x 3)
;    nil
;      (recur (inc x) (inc (uradi-inc "event" 51 id-brojac true event-formater (list x))))))

(loop [x 1 id-brojac 1]
  (if (= x 5)
    (println x id-brojac)
    (do
      (println x id-brojac)
      (recur (inc x) (petlja id-brojac)))))

(defn petlja [x]
  (let [max (+ x 3)]
  (loop [x 1]
    (if (= x max)
      x
      (recur (inc x))))))

(petlja 6)


(uradi-inc "event" 51 1 false event-formater '(1))

(spit "blubber.txt" "11111test\n" :append true)
(slurp "blubber.txt")
(println (slurp "blubber.txt"))


(print-all-things '(test-string test-string2))
(count '(test-string test-string2))

(defn print-all-things [a-list-of-things]
  (let [total (count a-list-of-things)]
     (println "Total things: " total)
     (dorun (map println a-list-of-things))))


(def test-string (new String "test stringnn"))
(def test-string2 (.concat test-string " 2"))


(println test-string)
(println test-string2)
(println (.length test-string))


(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))




