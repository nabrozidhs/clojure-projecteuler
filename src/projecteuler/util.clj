(ns projecteuler.util
  (:gen-class))

(defn is-palindrome?
  "Check if number is palindrome."
  [n]
  (let [s (seq (str n))]
    (= s (reverse s))))

(defn gcd
  "Greater common divider."
  [a b]
  (cond
    (= a b) a
    (> a b) (recur (- a b) b)
    :else   (recur a (- b a))))

(defn lcm
  "Least common multiple"
  [a b]
  (/ (* a b) (gcd a b)))

(defn is-prime?
  "Check if n number is prime."
  [n]
  (cond
    (= 1 n) true
    (= 2 n) true
    (zero? (rem n 2)) false
    :else
      (not-any? zero? (map #(rem n %) (range 3 (inc (int (Math/sqrt n))) 2)))))

(defn primes
  "Calculate the nth prime number."
  [n]
  (cond
    (= 1 n) 2
    :else
      (nth (filter #(is-prime? %) (iterate (partial + 2) 3)) (- n 2))))

(defn sum-of-squares
  "Calculate the sum of range(1, x+1) squares."
  [x]
  (reduce +
    (map #(int (Math/pow % 2)) (range 1 (+ x 1)))))
