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
    (is (= 17 (problem10 10))))

  (testing "Problem 11"
    (is (= 81 (problem11 [9 9 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 81 (problem11 [1 1 1 9 1 1 1 9 1 1 1 1 1 1 1 1])))
    (is (= 81 (problem11 [9 1 1 1 1 9 1 1 1 1 1 1 1 1 1 1])))
    (is (= 81 (problem11 [1 1 1 9 1 1 9 1 1 1 1 1 1 1 1 1]))))
  
  (testing "Problem 12"
    (is (= 6 (problem12 4)))
    (is (= 28 (problem12 5))))

  (testing "Problem 13"
    (is (= "8348422521" (problem13 ["37107287533902102798797998220837590246510135740250"
                                    "46376937677490009712648124896970078050417018260538"]))))

  (testing "Problem 48"
    (is (= "0405071317" (problem48 10)))
    (is (= "9110846700" (problem48 1000)))))
