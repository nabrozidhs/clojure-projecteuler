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
