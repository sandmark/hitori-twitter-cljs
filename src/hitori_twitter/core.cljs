(ns ^:figwheel-hooks hitori-twitter.core
  (:require [goog.dom :as gdom]
            [hitori-twitter.tweet :as t]
            [reagent.core :as reagent :refer [atom]]))

(defn get-app-element []
  (gdom/getElement "app"))

(defn app []
  [:div
   [t/tweet {:content "Hello"}]
   [t/tweet {:content "React!"}]])

(defn mount [el]
  (reagent/render-component [app] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
