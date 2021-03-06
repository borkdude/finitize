(ns finitize.core-test
  (:require
   [clojure.test :as t :refer [deftest is are testing]]
   [finitize.core :as f :refer [finitize]]))

(deftest finitize-test
  (testing "nil"
    (is (nil? (finitize nil)))
    (is (nil? (finitize nil 100))))

  (testing "default"
    (is (= 1 (finitize 1)))
    (is (= 1 (finitize 1 100))))

  (testing "infinite seqs"
    (are [x] (and (= 100 (count (finitize x)))
                  (= 33 (count (finitize x 33))))
      (lazy-seq (repeat 1))
      (range)
      (iterate inc 1)
      (repeat 1))))

;;;; Scratch

(comment
  (t/run-tests)
  )
