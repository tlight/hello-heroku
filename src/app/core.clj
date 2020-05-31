(ns app.core
  (:require [app.server :as server]
            ))

(defn -main [& args]
  (let [port    (Integer/valueOf (or (System/getenv "PORT") "3000"))]
    (server/start port))
  (shutdown-agents))

