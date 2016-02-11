(ns leiningen.new.options.posh
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "posh")

(defn files [data]
  [["src/clj/{{sanitized}}/conn.clj" (helpers/render "src/cljs/conn.cljs" data)]
   ["src/clj/{{sanitized}}/queries.clj" (helpers/render "src/cljs/queries.cljs" data)]])
