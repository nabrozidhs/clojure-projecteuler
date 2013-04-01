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

(defn primes
  "Calculate primes less than x."
  [x]
  (loop [n 3
         res [1 2]]
    (let [m (int (Math/sqrt n))]
      (if (< x n)
        res
        (let [possible-divisors (filter #(<= % m) (rest res))]
          (if (some zero? (map #(rem n %) possible-divisors))
            (recur (+ n 2) res)
            (recur (+ n 2) (conj res n))))))))

(defn sum-of-squares
  "Calculate the sum of range(1, x+1) squares."
  [x]
  (reduce +
    (map #(int (Math/pow % 2)) (range 1 (+ x 1)))))
