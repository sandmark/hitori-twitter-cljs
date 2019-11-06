(ns hitori-twitter.timeline
  (:require [hitori-twitter.tweet :as tw]))

(defn timeline [{:keys [tweets]}]
  (letfn [(tweet-with-key [index tweet]
            [tw/tweet (assoc tweet :key index)])]
    [:div.timeline
     (map-indexed tweet-with-key tweets)]))
