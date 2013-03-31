(ns projecteuler.core
  (:gen-class))

(defn problem1
  "Find the sum of all the multiples of 3 or 5 below x."
  [x]
  (reduce + 
  	(filter #(or (zero? (rem % 3))
  		         (zero? (rem % 5))) (range x))))
