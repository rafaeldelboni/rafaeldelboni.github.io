(ns nota.hooks.build
  (:require [aero.core :as aero]
            [clojure.java.io :as io]
            [nota.application.env :as env]))

(defn read-env [release-flag]
  (-> (io/resource "config.edn")
      (aero/read-config {:profile release-flag})
      (assoc :release-flag release-flag)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn hook
  {:shadow.build/stages #{:compile-prepare}}
  [{:shadow.build/keys [mode] :as build-state}]
  (let [app-env (read-env mode)]
    (alter-var-root #'env/config (constantly app-env))
    (-> build-state
        (assoc-in [:compiler-options :external-config ::env] app-env))))
