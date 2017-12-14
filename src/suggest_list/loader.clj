(ns suggest_list.loader)

(defn dummy-converter [x] x)

(defn read-csv
  [file-path separator converter]
  (with-open [r (clojure.java.io/reader file-path)]
    (doall
     (reduce (fn [row-map data]
               (assoc row-map (first data) (converter (rest data))))
             {}
             (map-indexed
              (fn [inx x] (cons inx (clojure.string/split x, separator)))
              (line-seq r))))))
  
