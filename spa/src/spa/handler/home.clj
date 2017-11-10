(ns spa.handler.home
  (:require [clojure.java.io :as io]
            [compojure.core :refer :all]
            [integrant.core :as ig]))

(defmethod ig/init-key :spa.handler/home [_ options]
  (GET "/" [] (io/resource "spa/handler/home/index.html")))
