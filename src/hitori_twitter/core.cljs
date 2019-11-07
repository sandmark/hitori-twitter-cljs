(ns ^:figwheel-hooks hitori-twitter.core
  (:require [goog.dom :as gdom]
            [reagent.core :as reagent]
            [hitori-twitter.timeline :as timeline]
            [hitori-twitter.tweet-input :as input]))

(defn get-app-element []
  (gdom/getElement "app"))

(defn app []
  (let [tweets (reagent/atom [{:id           0
                               :icon         "🌽"
                               :display-name "もろこし太郎"
                               :account-name "morokoshi"
                               :content      "今日も1日もろこしがうまい"}
                              {:id           1
                               :icon         "🦐"
                               :display-name "エビデンス"
                               :account-name "evidence"
                               :content      "かにみそたべたい"}])]
    (letfn [(add-tweet [tweet]
              (swap! tweets #(concat [tweet] %)))]
      (fn []
        [:div
         [input/tweet-input {:add-tweet add-tweet}]
         [timeline/timeline {:tweets @tweets}]]))))

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
