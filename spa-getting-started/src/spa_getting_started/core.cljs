(ns spa-getting-started.core
    (:require [jayq.core :as jq]))

(enable-console-print!)

(def config-map
  {:extended-height 434
   :extended-title "Click to retract"
   :retracted-height 16
   :retracted-title "Click to extend"
   :template-html "<div class=\"spa-slider\"></div>"})

(defonce $chat-slider (atom nil))

(defn toggle-slider []
  (let [slider-height (jq/height @$chat-slider)]
    (condp = slider-height
      (:retracted-height config-map)
      (do (-> @$chat-slider
              (jq/anim {:height (:extended-height config-map)})
              (jq/attr "title" (:extended-title config-map)))
          true)

      (:extended-height config-map)
      (do (-> @$chat-slider
              (jq/anim {:height (:retracted-height config-map)})
              (jq/attr "title" (:retracted-title config-map)))
          true)

      false)))

(defn on-click-slider [event]
  (toggle-slider)
  false)

(defn init-module [$container]
  (jq/html $container (:template-html config-map))
  (reset! $chat-slider (jq/$ :.spa-slider))
  (-> @$chat-slider
      (jq/attr "title" (:retracted-title config-map))
      (.click on-click-slider))
  true)

(.ready (jq/$ js/document) (init-module (jq/$ :#spa)))
