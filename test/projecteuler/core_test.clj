(ns projecteuler.core-test
  (:use clojure.test
        projecteuler.core))

(deftest a-test
  (testing "Problem 1."
    (is (= 23 (problem1 10)))
    (is (= 233168 (problem1 1000)))))
