(ns suggest_list.converters)

(defn index-converter
  [data]
  (first data))

(defn index-user
  [data]
  (index-converter data))

(defn index-book
  [data]
  (index-converter data))

;; ratings
(defn book-rating
  [data]
  (let [[user-id book-id rating] data]
    {:user-id user-id :book-id book-id :rating rating}))
