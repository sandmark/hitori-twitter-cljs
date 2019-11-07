(ns hitori-twitter.timeline
  (:require [hitori-twitter.tweet :as tw]))

(defn timeline [{:keys [tweets]}]
  [:div.timeline
   (->> tweets
        (map (fn [{:keys [id] :as tweet}]
               [tw/tweet (assoc tweet :key id)])))])
