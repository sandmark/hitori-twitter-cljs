(ns hitori-twitter.tweet-input
  (:require [reagent.core :as reagent]))

(defn tweet-input [{:keys [add-tweet]}]
  (let [!textarea (reagent/atom nil)]
    (letfn [(send-tweet [text]
              (add-tweet {:id           (.getTime (js/Date.))
                          :key          (.getTime (js/Date.))
                          :icon         "☠"
                          :display-name "ミスター死"
                          :account-name "mrdeath"
                          :content      text}))]
      (fn []
        [:div
         [:div
          [:textarea.tweet-textarea {:ref (fn [e] (reset! !textarea e))}]]
         [:div
          [:button.send-tweet {:on-click #(when-let [text (.-value @!textarea)]
                                            (when (not (empty? text))
                                              (send-tweet text)))}
           "Tweet"]]]))))
