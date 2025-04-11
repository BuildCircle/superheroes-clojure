(ns superheroes.core-test
  (:require [clojure.test :refer :all]
            [superheroes.core :as sut]))

(deftest battle-test
  (testing "Batman v Gamora, batman wins"
    (let [batman-char (sut/char-by-name "Batman")
          gamora-char (sut/char-by-name "Gamora")
          batman-v-gamora (sut/battle batman-char gamora-char)]
    (is (= gamora-char batman-v-gamora))))

  (testing "Batman v Joker, Joker wins"
    (let [batman-char (sut/char-by-name "Batman")
          joker-char (sut/char-by-name "Joker")
          batman-v-joker (sut/battle batman-char joker-char)]
      (is (= joker-char batman-v-joker)))))

