(ns nota.ui.markdown
  (:require ["react-markdown" :default ReactMarkdown]
            ["remark-gfm" :default remarkGfm]
            [com.fulcrologic.fulcro.algorithms.react-interop :as interop]
            [com.fulcrologic.fulcro.components :as comp :refer [defsc]]))

(def ui-markdown (interop/react-factory ReactMarkdown))

(defsc Render [_this {:keys [body]}]
  {}
  (when body
    (ui-markdown {:children body
                  :remarkPlugins [remarkGfm]})))

(def render (comp/factory Render))
