(ns hitori-twitter.styles
  (:require [garden.def :as gd]
            [garden.selectors :as s]))

(gd/defcssfn rgb)

(s/defclass tweet)

(gd/defstyles style
  [:* {:margin     0
       :padding    0
       :box-sizing "border-box"}]
  [:body {:background-color (rgb 240 240 255)}]
  [tweet {:display          "flex"
          :background-color "white"}]
  [(tweet (s/not (s/last-child))) {:border-bottom [["1px" "solid" (rgb 200 200 200)]]}]
  [:.icon-container {:width     "1.5em"
                     :font-size "3em"
                     :padding   "0.2em"}]
  [:.body-container {:flex    1
                     :padding "0.5em"}]
  [:.account-name {:color "gray"}]
  [:.tweet-textarea {:font-size "1em"
                     :width     "100%"
                     :height    "5em"
                     :padding   "0.8em"
                     :resize    "vertical"}]
  [:.send-tweet {:font-size "1em"
                 :padding   [["0.5em" "1em"]]}])
