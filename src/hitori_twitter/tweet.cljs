(ns hitori-twitter.tweet
  (:require [reagent.core :as reagent]))

(defn tweet [{:keys [content icon display-name account-name]}]
  (let [state (reagent/atom {:liked false})]
    (letfn [(toggle-like []
              (swap! state update :liked not))]
      (fn []
        [:div.tweet
         [:div.icon-container icon]
         [:div.body-container
          [:div.status-display
           [:span.display-name display-name]
           [:span.account-name "@" account-name]]
          [:div.content content]
          [:div.status-action
           [:span {:on-click toggle-like}
            (if (:liked @state) "❤️" "♡")]]]]))))
