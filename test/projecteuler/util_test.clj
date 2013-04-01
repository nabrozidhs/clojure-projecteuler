(ns projecteuler.util-test
  (:use clojure.test
        projecteuler.util))

(deftest a-test
  (testing "Prime"
    (is (= [1 2 3] (primes 3)))
    (is (= [1 2 3 5 7] (primes 10))))

  (testing "Is palindrome"
    (is (= true (is-palindrome? 11)))
    (is (= true (is-palindrome? 11211)))
    (is (= false (is-palindrome? 11221))))

  (testing "Greatest common divisor"
    (is (= 1 (gcd 5 4)))
    (is (= 5 (gcd 10 5))))

  (testing "Least common multiple"
    (is (= 4 (lcm 2 4)))
    (is (= 12 (lcm 6 4))))

  (testing "Sum of squares"
    (is (= 5 (sum-of-squares 2)))
    (is (= 385 (sum-of-squares 10)))))
