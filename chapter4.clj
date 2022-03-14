(class "caterpillar")

(. "caterpillar" toUpperCase)
(.toUpperCase "caterpillar")


;; encapsulation ??

(.indexOf "caterpillar" "pillar")


(def this-object (new String "Hi"))
(String. "Hi")

(.toUpperCase this-object)

(ns caterpillar.network
  (:import (java.net InetAddress)))

(.getHostName (InetAddress/getByName "localhost"))

(java.net.InetAddress/getByName "localhost")


;; doto macro

(def sb (doto (StringBuffer. "Who")
          (.append "are ")
          (.append "you?")))

;; which expands into

(def sb
  (.append
   (.append
    (StringBuffer. "Who")
    "are")
   "you?"))

(.toString sb)

(import 'java.util.UUID)
(UUID/randomUUID)

;; polymorphism
(defmulti who-are-you class)

(defmethod who-are-you java.lang.String [input]
  (str "String - who are you? " input))

(defmethod who-are-you clojure.lang.Keyword [input]
  (str "Keyword - who are you? " input))

(defmethod who-are-you java.lang.Long [input]
  (str "Number - who are you? " input))

(who-are-you :alice)
(who-are-you "Alice")

(defmethod who-are-you :default [input]
  (str "I don't know - who are you?? " input))


(defprotocol BigMushroom
  (eat-mushroom [this]))


(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom [this]
    (str (.toUpperCase this) " mmmm tasty!"))

  clojure.lang.Keyword
  (eat-mushroom [this]
    (case this
      :grow "Eat the right side"
      :shrink "Eat the left side")))

;; new datatypes

(defrecord Mushroom [color height])
(def regular-mushroom (Mushroom. "white and blue polka dots" "2 inches"))

(class regular-mushroom)

;; dot-dash
(.-color regular-mushroom)

(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))

(defrecord WonderlandMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bites makes you grow bigger"))
  (bite-left-side [this]
    (str "The " color " bite makes you grow smaller")))

(deftype RegularMushroom []
  Edible
  (bite-right-side [this]
    (str "The bite tastes bad"))
  (bite-left-side [this]
    (str "The bite tastes bad too")))

(def alice-mushroom (RegularMushroom.))

(bite-right-side alice-mushroom)

(defn bite-right-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow bigger"
    "The bite tastes bad"))
