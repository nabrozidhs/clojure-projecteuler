(ns projecteuler.core-test
  (:use clojure.test
        projecteuler.core))

(deftest a-test
  (testing "Problem 1."
    (is (= 23 (problem1 10)))
    (is (= 233168 (problem1 1000))))

  (testing "Problem 2."
    (is (= 10 (problem2 10)))
    (is (= 4613732 (problem2 4E6))))

  (testing "Problem 3."
    (is (= 29 (problem3 13195)))
    (is (= 6857 (problem3 600851475143))))

  (testing "Problem 4."
    (is (= 9009 (problem4 2)))
    (is (= 906609 (problem4 3))))

  (testing "Problem 5"
    (is (= 2520 (problem5 10)))
    (is (= 232792560 (problem5 20))))

  (testing "Problem 6"
    (is (= 2640 (problem6 10)))
    (is (= 25164150 (problem6 100))))

  (testing "Problem 7"
    (is (= 13 (problem7 6)))
    (is (= 104743 (problem7 10001))))

  (testing "Problem 8"
    (is (= 1 (problem8 "000990111110")))
    (is (= 81 (problem8 "000991111110"))))

  (testing "Problem 9"
    (is (= 60 (problem9 12)))
    (is (= 31875000 (problem9 1000))))

  (testing "Problem 10"
    (is (= 17 (problem10 10)))))
