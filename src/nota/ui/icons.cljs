(ns nota.ui.icons
  (:require [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
            [com.fulcrologic.fulcro.dom :as dom]))

(defsc SunIcon [_ {:keys [width height]}]
  {}
  (dom/svg {:version             "1.1"
            :xmlns               "http://www.w3.org/2000/svg"
            :aria-hidden         "true"
            :role                "img"
            :width               (or width 10)
            :height              (or height 10)
            :style               {:verticalAlign "-0.125em"}
            :preserveAspectRatio "xMidYMid meet"
            :viewBox             "0 0 512 512"}
           (dom/title "sum")
           (dom/path {:d "M256 160c-52.9 0-96 43.1-96 96s43.1 96 96 96s96-43.1 96-96s-43.1-96-96-96zm246.4 80.5l-94.7-47.3l33.5-100.4c4.5-13.6-8.4-26.5-21.9-21.9l-100.4 33.5l-47.4-94.8c-6.4-12.8-24.6-12.8-31 0l-47.3 94.7L92.7 70.8c-13.6-4.5-26.5 8.4-21.9 21.9l33.5 100.4l-94.7 47.4c-12.8 6.4-12.8 24.6 0 31l94.7 47.3l-33.5 100.5c-4.5 13.6 8.4 26.5 21.9 21.9l100.4-33.5l47.3 94.7c6.4 12.8 24.6 12.8 31 0l47.3-94.7l100.4 33.5c13.6 4.5 26.5-8.4 21.9-21.9l-33.5-100.4l94.7-47.3c13-6.5 13-24.7.2-31.1zm-155.9 106c-49.9 49.9-131.1 49.9-181 0c-49.9-49.9-49.9-131.1 0-181c49.9-49.9 131.1-49.9 181 0c49.9 49.9 49.9 131.1 0 181z"
                      :fill "white"})))

(def sun-icon (comp/factory SunIcon))

(defsc MoonIcon [_ {:keys [width height]}]
  {}
  (dom/svg {:version             "1.1"
            :xmlns               "http://www.w3.org/2000/svg"
            :aria-hidden         "true"
            :role                "img"
            :width               (or width 10)
            :height              (or height 10)
            :preserveAspectRatio "xMidYMid meet"
            :viewBox             "0 0 512 512"}
           (dom/title "moon")
           (dom/path {:d "M283.211 512c78.962 0 151.079-35.925 198.857-94.792c7.068-8.708-.639-21.43-11.562-19.35c-124.203 23.654-238.262-71.576-238.262-196.954c0-72.222 38.662-138.635 101.498-174.394c9.686-5.512 7.25-20.197-3.756-22.23A258.156 258.156 0 0 0 283.211 0c-141.309 0-256 114.511-256 256c0 141.309 114.511 256 256 256z"
                      :fill "#575757"})))

(def moon-icon (comp/factory MoonIcon))

(defsc Logo [_ {:keys [width height theme]}]
  {}
  (let [color (if (= theme "dark") "#ffffff" "#575757")]
    (dom/svg {:version     "1.1"
              :xmlns       "http://www.w3.org/2000/svg"
              :aria-hidden "true"
              :role        "img"
              :width       (or width 65)
              :height      (or height 45)
              :viewBox     "-1.521 -3.558 300 210"
              :overflow    "visible"}
             (dom/title "logo")
             (dom/path {:d "M27.111 11.606v120.942h32.71c70.994 0 69.547-66.755 69.547-66.755 0-68.068-69.109-66.475-69.109-66.475H14.857v191.306h101.899L1.732 75.899v127.64h165.922V-.685h26.238s101.559 2.049 101.559 102.417c0 99.119-102.969 101.833-102.969 101.833h-12.055v-12.941h12.055s90.057-4.835 90.057-88.686c0-85.74-90.16-90.008-90.16-90.008h-37.398v178.694h-12.696V-.685H154.9"
                        :fillOpacity "0"
                        :fill color
                        :stroke color
                        :strokeWidth "5.5"
                        :stroke-line-cap "round"
                        :stroke-line-join "round"
                        :stroke-miter-limit "10"}))))

(def logo (comp/factory Logo))
