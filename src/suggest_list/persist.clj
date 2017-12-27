(ns suggest_list.persist
  (:use suggest_list.loader)
  (:use suggest_list.converters))

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

(defn write-index-object
  [csv-file-path object-file-path converter]
  (let [data (read-csv csv-file-path #";" converter)]
    (write-object data object-file-path)))

(defn write-index-user
  [csv-file-path object-file-path]
  (write-index-object csv-file-path object-file-path index-user))

(defn write-index-book
  [csv-file-path object-file-path]
  (write-index-object csv-file-path object-file-path index-user))
