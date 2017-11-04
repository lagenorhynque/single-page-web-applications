(ns spa.handler.example
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :spa.handler/example [_ options]
  (GET "/" [] (io/resource "spa/handler/example/example.html")))
