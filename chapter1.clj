\j

true
false

nil

(+ 1 1)


(first '(rabbit pocket-watch hello))

(cons 5 '())

;; vector

[:jar 1 2 3 :jar2]

(nth [:jar 1 2 3 :jar2] 2)

(conj [:toast :butter] :jam)

(conj [:toast :butter] :jam :honey)


(conj '(:toast :butter) :jam)

(conj '(:toast :butter) :jam :honey)

;; map

{:jam1 "strawberry" :jam2 "blackberry"}

(get {:jam1 "strawberry" :jam2 "blackberry"} :jam2)

(get {:jam1 "strawberry" :jam2 "blackberry"} :jam3 "not found")

(:jam2 {:jam1 "strawberry" :jam2 "blackberry"})

(keys {:jam1 "strawberry" :jam2 "blackberry"})
(vals {:jam1 "strawberry" :jam2 "blackberry"})

(assoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1 "orange")
(dissoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1)

;; set
#{:red :blue :white}

(clojure.set/union #{:r :b :w} #{:w :p :y})
(set [:rabbit :rabbit :watch :door])

(get #{:rabbit :door :watch} :rabbit)
(:rabbit #{:rabbit :door})

(contains? #{:rabbit :door} :rabbit)

(def developer "Alice")
user/developer

;; namespace/

(let [developer "Alice in Wonderland"
      rabbit "White Rabiit"]
  [developer rabbit])

;; function

(defn follow-the-rabbit [] "Off we go!")
(follow-the-rabbit)

(defn shop-for-jams [jam1 jam2]
  {:name "jam-basket"
   :jam1 jam1
   :jam2 jam2})

(shop-for-jams "strawberry" "marmalade")

;; lambda

((fn [] (str "Off we go" "!")))

(def follow-again (fn [] (str "Off we go" "!")))
(follow-again)

(#(str "Off we go" "!"))

(#(str "Off we go" "!" " - " %) "again")
(#(str "Off we go" "!" " - " %1 %2) "again" "?")

;; namespace

(ns alice.favfoods)
*ns*

(def fav-food "strawberry jam")

(ns rabbit.favfoods)

(def fav-food "lettuce soup")

fav-food

alice.favfoods/fav-food

(ns wonderland)


(require '[alice.favfoods :as af])
af/fav-food
