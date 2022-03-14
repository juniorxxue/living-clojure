(first [1 2 4])

(class true)

(true? true)

(true? nil)
(false? nil)

(not nil)

(= :drinkme :drinkme)
(= 1 1)

(not= :drinkme :4)

;; In Clojure, there are the collection and sequence abstractions.
;; the collections are simply a collection of elements, like vectors, lists, and maps. 

(class [1 2 3])
(class 1)

(seq [])
(seq [1 2 3])

(first [])

(every? odd? [1 2 4])
(every? odd? [1 3 5])

(defn drinkable? [x]
  (= x :drinkme))

(every? #(= % :drinkme) [:drinkme :drinkme])

(some #(> % 3) [1 2 3 4 5])

(if true "it is true" "it is false")

(if-let [need-to-grow-small (> 5 1)]
  "drink bottle"
  "dont drink bottle")

(defn drink [need-to-grow-small]
  (when need-to-grow-small "drink bottle"))

(drink true)

(let [bottle "drinkme"]
  (cond
    (= bottle "poison") "done touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"))

;; case is only intended for =
;; no match would raise a exception
(let [x 1]
  (case x
    1 "yeah"
    2 "no"))

;; destructuring

(let [[color size] ["blue" "small"]]
  (str "The " color " door is " size))

(let [{flower1 :flower1 flower2 :flower2}
      {:folower1 "red" :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))


(let [{:keys [flower1 flower2]}
      {:flower1 "red" :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))

;; destructuring also works on parameter
(defn flower-colors [{:keys [flower1 flower2]}]
  (str "The flowers are " flower1 " and " flower2))

(flower-colors {:flower1 "red" :flower2 "blue"})
