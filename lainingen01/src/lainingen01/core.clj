(ns lainingen01.core)


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
