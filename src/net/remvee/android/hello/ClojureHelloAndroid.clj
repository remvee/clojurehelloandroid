(ns net.remvee.android.hello.ClojureHelloAndroid
  (:gen-class
   :extends android.app.Activity
   :exposes-methods {onCreate superOnCreate}))

(defn -onCreate [this #^android.os.Bundle bundle]
  (.superOnCreate this bundle)
  (.setContentView this net.remvee.android.hello.R$layout/main)
  (let [tv (new android.widget.TextView this)]
    (.setText tv (str "Hello Android from Clojure " (clojure-version) "!"))
    (.setContentView this tv)))