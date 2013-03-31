(ns projecteuler.util
  (:gen-class))

(defn primes
  "Calculate primes less than x."
  [x]
  (loop [n 3
         res [1 2]]
    (if (< x n)
      res
      (if (some zero? (map #(rem n %) (rest res)))
        (recur (+ n 2) res)
        (recur (+ n 2) (conj res n))))))