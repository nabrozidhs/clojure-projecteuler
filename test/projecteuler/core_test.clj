(ns projecteuler.core-test
  (:use clojure.test
        projecteuler.core))

(deftest a-test
  (testing "Problem 1."
    (is (= 23 (problem1 10)))
    (is (= 233168 (problem1 1000))))

  (testing "Problem 2."
    (is (= 10 (problem2 10)))
    (is (= 4613732 (problem2 4000000))))

  (testing "Problem 3."
    (is (= 29 (problem3 13195)))
    (is (= 6857 (problem3 600851475143))))

  (testing "Problem 4."
    (is (= 9009 (problem4 2)))
    (is (= 906609 (problem4 3))))

  (testing "Problem 5"
    (is (= 2520 (problem5 10))))

  (testing "Problem 6"
    (is (= 2640 (problem6 10)))
    (is (= 25164150 (problem6 100)))))
