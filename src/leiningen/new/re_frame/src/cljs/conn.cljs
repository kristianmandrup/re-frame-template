(ns {{ns-name}}.conn
  (:require [datascript.core :as d]))

;; db schema

(def schema {
  ;; ...
})

;; create connection

(def conn (d/create-conn schema))

;; utils

(defn new-entity! [conn varmap]
  ((:tempids (d/transact! conn [(merge varmap {:db/id -1})])) -1))

;;; setup

(def tempid (let [n (atom 0)] (fn [] (swap! n dec))))

(defn populate! [conn]
  (let [todo-id (new-entity! conn {:todo/name "Matt's List"})
  (d/transact!
   conn
   [{:db/id (tempid)
     :task/name "Clean Dishes"
     :task/done true}
    {:db/id (tempid)
     :task/name "Mop Floors"
     :task/done false}