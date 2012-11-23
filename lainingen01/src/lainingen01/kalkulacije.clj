(ns lainingen01.kalkulacije)

(defn kamata-na-kamatu [ulog godisnja-kamata broj-godina]
  (if (= broj-godina 0)
    ulog
    (kamata-na-kamatu (izracunaj-sumu-sa-kamatom ulog godisnja-kamata) 
                      godisnja-kamata 
                      (- broj-godina 1))))

(defn izracunaj-kamatu [ulog godisnja-kamata]
  (* (/ ulog 100) godisnja-kamata))

(defn izracunaj-sumu-sa-kamatom [ulog godisnja-kamata]
  (+ (izracunaj-kamatu ulog godisnja-kamata) ulog))

(izracunaj-kamatu 1000 5)
(izracunaj-sumu-sa-kamatom 1000 5)

(kamata-na-kamatu 60000.0 5 14)

razlomak