(ns clojure-xml-example.core
  (:require [clojure.data.xml :as xml])
  (:gen-class))

(def bookshelf
  (xml/element :books {}
               (xml/element :book {:author "Stuart Halloway"}
                            "Programming Clojure")
               (xml/element :book {:author "Christian Queinnec"}
                            "Lisp in Small Pieces")
               (xml/element :book {:author "Harold Abelson, Gerald Jay Sussman"}
                            "Structure and Interpretation of Computer Programs")))


(defn -main
  []
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println (xml/emit-str bookshelf)))
