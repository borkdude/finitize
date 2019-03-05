(ns finitize.core)

(defprotocol Finitize
  "Limits and realizes the possibly infinite data structure `this`
  Default implementations realize and take n (defaults to 100)
  elements."
  (finitize [this] [this n]))

(defn realizing-take [n xs]
  (doall (take n xs)))

(extend-protocol Finitize

  #?(:clj Object :cljs default)
  (finitize
    ([this] this)
    ([this n] this))

  #?(:clj clojure.lang.LazySeq :cljs LazySeq)
  (finitize
    ([this]
     (finitize this 100))
    ([this n]
     (realizing-take n this)))
  #?(:clj clojure.lang.Cons :cljs Cons)
  (finitize
    ([this]
     (finitize this 100))
    ([this n]
     (realizing-take n this)))

  #?(:clj clojure.lang.Range :cljs Range)
  (finitize
    ([this]
     (finitize this 100))
    ([this n]
     (realizing-take n this)))

  #?(:clj clojure.lang.Iterate :cljs Iterate)
  (finitize
    ([this]
     (finitize this 100))
    ([this n]
     (realizing-take n this)))

  #?(:clj clojure.lang.Repeat :cljs Repeat)
  (finitize
    ([this]
     (finitize this 100))
    ([this n]
     (realizing-take n this))))
