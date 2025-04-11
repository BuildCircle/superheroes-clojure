(ns superheroes.core
  (:require [cheshire.core :as json])
  (:gen-class))

(def api-url " https://s3.eu-west-2.amazonaws.com/build-circle/characters.json")

(def api-data (:items (json/parse-string (slurp api-url) (fn [k] (keyword k)))))

(defn char-by-name [charname]
  (first (filter #(= (:name %) charname) api-data)))


(defn battle [char1 char2]
  (let [char1-score (:score char1)
        char2-score (:score char2)]
    (if (> char1-score char2-score)
      char1
      char2)))

(defn -main
  [& args]
  (if (= 2 (count args))
    (println (battle (char-by-name (first args)) (char-by-name (second args))))
    (println "Please pass 2 character names")))