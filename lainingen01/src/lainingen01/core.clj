(ns lainingen01.core)




(defn uradi-dec [input1, brojRedova]	
	(loop [x brojRedova]
	     (if (neg? x)
	     x
	     (do 
	       (println (.concat input1 (.toString x)))
	       (recur (dec x))))))

(defn uradi-inc [input1, brojRedova]	
  (loop [x 2]
    (if (= x brojRedova)
      nil
	    (do 
       (spit "C:\\Users\\nikola\\workspace\\filmania\\src\\ets\\dataset.csv" 
             (str input1 x "\n") 
             :append true)
	     (recur (inc x))))))


(uradi-inc "" 1100)


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
