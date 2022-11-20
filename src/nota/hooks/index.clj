(ns nota.hooks.index
  (:require [clojure.edn :as edn]
            [clojure.string :as string]
            [hiccup.core :refer [html]]))

(defn read-edn! [path]
  (edn/read-string (slurp path)))

(defn output-dir [build-state]
  (get-in build-state [:shadow.build/config :output-dir]))

(defn asset-path [build-state]
  (get-in build-state [:shadow.build/config :asset-path]))

(defn get-manifest-path [build-state]
  (str (output-dir build-state) "/manifest.edn"))

(defn get-manifest! [build-state]
  (-> build-state
      get-manifest-path
      read-edn!))

(defn template [main-src {:keys [title links scripts lang app-mount]}]
  (html
   [:html {:lang lang}
    [:head
     [:script "(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':\nnew Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],\nj=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=\n'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);\n})(window,document,'script','dataLayer','GTM-NKVPQMM');"]
     [:title title]
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "x-ua-compatible" :content "ie=edge"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
     (for [{:keys [id href rel htype same-site]} links]
       [:link {:id id
               :rel rel
               :type htype
               :href href
               :SameSite same-site}])]
    [:body
     [:noscript
      [:iframe
       {:style "display:none;visibility:hidden",
        :width "0",
        :height "0",
        :src
        "https://www.googletagmanager.com/ns.html?id=GTM-NKVPQMM"}]]
     [app-mount "Loading..."]
     (for [src scripts]
       [:script {:src src}])
     [:script {:src main-src}]]]))

(defn conform-options [build-state options]
  (merge {:path      (string/replace (output-dir build-state)
                                     (re-pattern (asset-path build-state))
                                     "")
          :title     "rafael delboni"
          :links     [{:href "./img/favicon.png"
                       :rel "icon"}
                      {:href "https://fonts.googleapis.com"
                       :rel "preconnect"}
                      {:href "https://fonts.gstatic.com"
                       :rel "preconnect"}
                      {:href "https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@100;400;500&family=Poppins:wght@500;600&display=swap"
                       :rel "stylesheet"}
                      {:href "https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css"
                       :rel "stylesheet"
                       :same-site "Strict"}
                      {:id "prism-theme"
                       :href "https://cdnjs.cloudflare.com/ajax/libs/prism/1.25.0/themes/prism-okaidia.min.css"
                       :rel "stylesheet"}
                      {:href "./css/nota.min.css"
                       :rel "stylesheet"
                       :htype "text/css"}
                      {:href "https://clj.social/@delboni"
                       :rel "me"}
                      {:href "https://gitHub.com/rafaeldelboni"
                       :rel "me"}
                      {:href "https://twitter.com/rafaeldelboni"
                       :rel "me"}]
          :scripts   ["https://cdnjs.cloudflare.com/ajax/libs/prism/1.25.0/components/prism-core.min.js"
                      "https://cdnjs.cloudflare.com/ajax/libs/prism/1.25.0/plugins/autoloader/prism-autoloader.min.js"]
          :lang      "en"
          :app-mount :div#app}
         options))

(defn write-html! [path index-html]
  (spit (str path "/" "index.html")
        index-html))

(defn hook* [build-state options {:keys [get-manifest
                                         write-html]}]
  (let [{:keys [path] :as options} (conform-options build-state options)
        main-src (format ".%s/%s"
                         (asset-path build-state)
                         (-> (get-manifest build-state)
                             first
                             :output-name))
        index-html (template main-src options)]
    (write-html path index-html)
    build-state))

(defn hook
  {:shadow.build/stage :flush}
  ([build-state]
   (hook build-state {}))
  ([build-state options]
   (hook* build-state options
          {:write-html   write-html!
           :get-manifest get-manifest!})))
