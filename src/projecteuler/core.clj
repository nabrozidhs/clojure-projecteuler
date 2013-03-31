(ns projecteuler.core
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