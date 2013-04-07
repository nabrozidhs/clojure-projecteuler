(ns projecteuler.core
  (:use projecteuler.util)
  (:gen-class))

(defn problem1
  "Find the sum of all the multiples of 3 or 5 below x."
  [x]
  (reduce + 
    (filter #(or (zero? (rem % 3))
                 (zero? (rem % 5))) (range x))))

(defn problem2
  "Find the sum of the even-valued fibonacci terms below x"
  [x]
  (reduce +
    (filter even?
      (loop [a 1
             b 2
             res [a b]]
        (let [next (+ a b)]
          (if (>= next x)
            res
            (recur b next (conj res next))))))))

(defn problem3
  "Find the largest prime factor on x."
  [x]
  (loop [value x
         factor 2]
    (if (>= factor value)
      factor
      (if (zero? (rem value factor))
        (recur (/ value factor) factor)
        (recur value (inc factor))))))

(defn problem4
  "Largest palindrome from the product of x digits numbers."
  [digits]
  (let [numbers (range (- (int (Math/pow 10 digits)) 1)
                       (- (int (Math/pow 10 (- digits 1))) 1) -1)]
    (let [palindromes (filter #(is-palindrome? %) (range (* (first numbers) (first numbers))
                                                         (* (last numbers) (last numbers)) -1))]
      (loop [p palindromes]
        (if (some true? (map #(and (zero? (rem (first p) %))
                                   (>= (first numbers) (/ (first p) %))) numbers))
          (first p)
          (recur (rest p)))))))

(defn problem5
  "Smallest number that can be divided by range(n, 1, -1)."
  [n]
  (reduce lcm (range 2 (inc n))))

(defn problem6
  "Sum square difference of the first range(1, x+1) numbers."
  [x]
  (- (int (Math/pow (reduce + (range 1 (+ x 1))) 2))
    (sum-of-squares x)))

(defn problem7
  "Calculate the nth prime number."
  [n]
  (primes n))

(defn problem8
  "Calculate greatest product of 5 consecutive digits in a big digit number (string input)"
  [s]
  (apply max (map #(apply * %) (partition 5 1 (map #(Integer/parseInt (str %)) (seq s))))))

(defn problem9
  "Find the product abc of the Pythagorean triplet for which a + b + c = n."
  [n]
  (loop [a 1
         b 2]
    (let [c (Math/sqrt (+ (* a a) (* b b)))]
      (cond
        (== n (+ a b c)) (int (* a b c))
        (> n (+ a b c)) (recur a (inc b))
        :else (recur (inc a) (+ a 2))))))

(defn problem10
  "Find the sum of all the primes below n."
  [n]
  (reduce + (primes-below n)))

(defn problem11
  "Find the greatest product in four adjacent number in a square grid."
  [grid]
  (let [size (int (Math/sqrt (count grid)))]
    (apply max
      (map #(* (get grid (first %)) (get grid (second %)) (get grid (nth % 2)) (get grid (last %)))
      (concat
        ; Horizontal rows
        (apply concat
          (for [y (range 0 (count grid) size)]
            (partition 4 1 (range y (+ y size)))))
        ; Vertical rows
        (apply concat
          (for [x (range 0 size)]
            (partition 4 1 (range x (count grid) size))))
        ; Diagonal bottom left -> top right
        (apply concat
          (for [y (range 0 (- (count grid) (* 3 size)) size)]
            (for [x (range 3 size)]
              (take 4 (iterate (partial + (dec size)) (+ y x))))))
        ; Diagonal top left -> bottom right
        (apply concat
          (for [y (range 0 (- (count grid) (* 3 size)) size)]
            (for [x (range 0 (- size 3))]
              (take 4 (iterate (partial + (inc size)) (+ y x)))))))))))

(defn problem12
  "Return the triangle number that has less than n divisors."
  [n]
  (first (filter #(<= n (divisors %)) triangular-numbers)))

(defn problem13
  "Return the first 10 digits of the sum of a list of integers."
  [l]
  (apply str (take 10 (str (reduce + (map #(bigint %) l))))))

(defn problem14
  "Which starting number below n produces the longest chain."
  [n]
  (second (reduce #(if (> (first %1) (first %2)) %1 %2) (map
    (fn [x]
      (loop [i 1
             n x]
        (if (= 1 n)
          [i x]
          (if (even? n)
            (recur (inc i) (quot n 2))
            (recur (inc i) (inc (* 3 n)))))))
    (range 1 n 2)))))

(defn problem48
  "Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + n^n."
  [n]
  (apply str (seq (take-last 10 (str (reduce + (map #(.pow (biginteger %) %) (range 1 (inc n)))))))))
