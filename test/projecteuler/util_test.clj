(ns projecteuler.util-test
  (:use clojure.test
        projecteuler.util))

(deftest a-test
  (testing "Prime"
    (is (= [1 2 3] (primes 3)))
    (is (= [1 2 3 5 7] (primes 10)))))
