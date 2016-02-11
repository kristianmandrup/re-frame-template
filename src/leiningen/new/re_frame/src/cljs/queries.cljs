(ns {{ns-name}}.queries
  (:require [posh.core :as p]
            [{{ns-name}}.db :as db :refer [conn]]))

(defn find-edited [conn id attr]
  (p/q conn '[:find ?edit .
              :in $ ?id ?attr
              :where
              [?edit :edit/id ?id]
              [?edit :edit/attr ?attr]]
       id attr))