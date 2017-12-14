(ns suggest_list.persist)

(defn read-object
  [file-path]
  (with-open [r (java.io.PushbackReader. (clojure.java.io/reader file-path))]
    (binding [*read-eval* false]
      (read r))))

(defn write-object
  [obj file-path]
  (with-open [w (clojure.java.io/writer file-path)]
    (binding [*out* w]
      (pr obj))))
