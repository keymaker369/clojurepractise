(ns lainingen01.belex.parse
  (:require [net.cgrand.enlive-html :as html])
  (:require [clojure.string :as str]))

(def symbols (ref (list)))

(defn fetch-page [url]
  (html/html-resource (java.net.URL. url)))

(defn parse-test []
  (let [url "http://example.com"
        url-data (fetch-page url)
        selector [:div :p]]
    (first (html/select url-data selector))))

(defn parse-file [file-path selector]
  (let [url-data (html/html-resource 
                   (java.io.StringReader. (slurp file-path)))]
    (first (html/select url-data selector))))

(defn search-page-number-of-results [path selector]
  (read-string 
    (second 
     (str/split
       (last
         (:content 
           (parse-file path selector)))
         #" "))))

;(search-page-number-of-results 
;  "/home/user/Documents/belex/a.html"  
;  [:div#content :div])

(defn get-symbols 
  [url selector]
  (map first 
       (map :content (let [url-data (fetch-page url)]
                       (html/select url-data selector)))))

(defn add-symbols 
  [path selector]
  (println path selector)
  (dosync
    (ref-set
      symbols (concat @symbols (get-symbols path selector)))))

(count @symbols)

(count 
  (apply sorted-set @symbols))

(spit 
  "/home/user/Documents/belex/symbols.txt"
  (str/join "," (apply sorted-set @symbols)))

