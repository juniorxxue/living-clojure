;; laziness
(take 5 (range))

(class (range 5))

(repeat 3 "rabbit")

(rand-int 10)

(repeatedly 5 #(rand-int 10))

(repeatedly 4 #(print "hello"))

#(str "Alice is " %)

(def adjs ["normal"
           "too small"
           "too big"
           "is swiming"])

(defn countdown [n]
  (if (= n 0)
    n
    (countdown (- n 1))))

(countdown 2)

(defn countdown [n]
  (if (= n 0)
    n
    (recur (- n 1))))

(#(str %) :mouse)

(def animals [:mouse :duck :dodo :lory :eaglet])

(map #(str %) animals)

(take 3 (map #(str %) (range)))

(println "Look at the mouse!")

(def animals
  ["mouse" "duck" "dodo" "lory" "eaglet"])

(def colors
  ["brown" "black"])

(reduce + [1 2 3 4 5])

(reduce (fn [r x] (+ r (* x x))) [1 2 3])

(for [animal [:mouse :duck :lory]]
  (str (name animal)))


(vec '(1 2 3))

(into [] '(1 2 3))

(sorted-map :b 2 :a 1 :z 3)

(into (sorted-map) {:b 2 :c 3 :a 1})

(into {} [[:a 1] [:b 2] [:c 3]])

(partition 3 [1 2 3 4 5 6 7 8 9])


;; state and concurrency

(def who-atom (atom :caterpillar))

who-atom

@who-atom

(reset! who-atom :chrysalis)

@who-atom

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(swap! who-atom change)

@who-atom

(def counter (atom 0))

@counter

(dotimes [_ 5] (swap! counter inc))

@counter

(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))

@counter

(def counter (atom 0))

(defn inc-print [val]
  (println val)
  (inc val))

(swap! counter inc-print)

(def counter (atom 0))

(let [n 2]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))

@counter

(def alice-height (ref 3))

(def right-hand-bites (ref 10))

@alice-height
@right-hand-bites

(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))

(dosync (eat-from-right-hand))

@alice-height
@right-hand-bites


(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (alter right-hand-bites dec)
            (alter alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

@alice-height
@right-hand-bites

#(+ % 1)
#(+ %1 %2)

(def x (ref 1))
(def y (ref 1))

(defn new-values []
  (dosync
   (alter x inc)
   (ref-set y (+ 2 @x))))

(let [n 2]
  (future (dotimes [_ n] (new-values)))
  (future (dotimes [_ n] (new-values))))

;; more understanding on atom, ref and agent


