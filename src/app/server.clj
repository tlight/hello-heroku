(ns app.server
  (:require
   [org.httpkit.server :as http-server]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [clojure.data.json :as json]
   [ring.middleware.defaults :refer :all]
   [ring.middleware.cors :refer [wrap-cors]]
   [ring.middleware.params :only [wrap-params]]
   [ring.logger :as logger]
   ))

(defonce ^:private server (atom nil))

(defn respond [status body]
  {:status status
   :headers {"Content-type" "text/json"}
   :body (json/write-str body)})

(defroutes app-routes
  (GET "/" []
    (respond 200 {:message "hello"}))
  (route/not-found "unknown!"))

(def handler
  (-> app-routes
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))
      (wrap-cors :access-control-allow-origin [#"http://localhost:8080"]
                 :access-control-allow-methods [:get :put :post :delete])
      (logger/wrap-with-logger)
      ))

(defn create [port]
  (http-server/run-server handler {:port port}))

(defn start [port]
  (reset! server (create port)))

(defn stop []
  (@server :timeout 5))
