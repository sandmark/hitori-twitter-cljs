(ns hitori-twitter.tweet)

(defn tweet [{:keys [content icon display-name account-name]}]
  [:div.tweet
   [:div.icon-container icon]
   [:div.body-container
    [:div.status-display
     [:span.display-name display-name]
     [:span.account-name "@" account-name]]
    [:div.content content]]])
