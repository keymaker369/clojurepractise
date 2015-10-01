(ns lainingen01.belex.parse
  (:require [net.cgrand.enlive-html :as html])
  (:require [clojure.string :as str]))

(defn fetch-page [url]
  (html/html-resource (java.net.URL. url)))

(defn parse-test []
  (let [url "http://example.com"
        url-data (fetch-page url)
        selector [:div :p]]
    (first (html/select url-data selector))))

(:content (parse-test))

(defn parse-file []
  (let [file-path "d:/bb1.htm"
        url-data (html/html-resource (java.io.StringReader. (slurp file-path)))
        selector [:div#content :div]]
    (first (html/select url-data selector))))

(defn results []
  (read-string 
    (second 
     (str/split
       (last
         (:content 
           (parse-file)))
         #" "))))


(/ (results) 2)


(println (apply str 
  (html/emit* [(parse-test)])))

(def page (fetch-page "http://example.com"))

(nth page 0)
(nth (:content (nth page 1)) 0)