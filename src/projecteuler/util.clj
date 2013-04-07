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
  "Least common multiple."
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

(defn primes-below
  "Calculate the primes below n."
  [n]
  (loop [current 3
         primes [2]]
    (if (> current n)
      primes
      (if (is-prime? current)
        (recur (+ current 2) (conj primes current))
        (recur (+ current 2) primes)))))

(defn sum-of-squares
  "Calculate the sum of range(1, x+1) squares."
  [x]
  (reduce +
    (map #(int (Math/pow % 2)) (range 1 (+ x 1)))))

(defn divisors
  "Return the counter of divisors for number."
  [number]
  (* 2 (count (filter #(zero? (rem number %)) (range 1 (inc (int (Math/sqrt number))))))))

(def triangular-numbers
  "Return a lazy sequence of triangular numbers."
  (map first (iterate (fn [[a b]] [(+ a b) (inc b)]) [1 2])))
