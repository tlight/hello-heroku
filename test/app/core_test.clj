(ns app.core-test
  (:require [clojure.test :refer :all]))

(deftest fail
  (testing "this test will fail"
    (is (= 0 1))))

(deftest success
  (testing "this test will succeed"
    (is (= 0 0))))
