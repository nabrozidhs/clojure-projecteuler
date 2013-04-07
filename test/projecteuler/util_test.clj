(ns projecteuler.util-test
  (:use clojure.test
        projecteuler.util))

(deftest a-test
  (testing "Prime"
    (is (= 2 (primes 1)))
    (is (= 3 (primes 2)))
    (is (= 5 (primes 3)))
    (is (= 11 (primes 5))))

  (testing "Primes below"
    (is (= [2 3 5 7] (primes-below 10)))
    (is (= [2 3 5 7 11] (primes-below 12))))
  
  (testing "Is prime?"
    (is (= true (is-prime? 1)))
    (is (= true (is-prime? 2)))
    (is (= true (is-prime? 3)))
    (is (= false (is-prime? 4))))

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
    (is (= 385 (sum-of-squares 10))))

  (testing "Divisors"
    (is (= 4 (divisors 10)))
    (is (= 6 (divisors 28)))))
