(ns spa.handler.home-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [spa.handler.home :as home]))

(deftest smoke-test
  (testing "home page exists"
    (let [handler  (ig/init-key :spa.handler/home {})
          response (handler (mock/request :get "/"))]
      (is (= 200 (:status response)) "response ok"))))
