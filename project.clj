(defproject rosso "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "https://github.com/FIXME/rosso"
  :min-lein-version "2.7.1"
  :license {:name         "The Apache License, Version 2.0"
            :url          "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.516"]
                 [org.clojure/tools.cli "0.4.1"]
                 [mount "0.1.15"]
                 [reagent "1.1.0" :exclusions [[cljsjs/react]
                                               [cljsjs/react-dom]
                                               [cljsjs/create-react-class]]]
                 [re-frame "1.2.0"]]

  :plugins [[lein-cljsbuild "1.1.8" :exclusions [[org.clojure/clojure]]]
            [lein-figwheel "0.5.20"]]

  :source-paths ["src"]

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src" "env/dev"]
                        :figwheel     {:on-jsload rosso.app/reload!}
                        :compiler     {:main                 rosso.app
                                       :asset-path           "target/js/compiled/dev"
                                       :output-to            "target/js/compiled/rosso.js"
                                       :output-dir           "target/js/compiled/dev"
                                       :target               :nodejs
                                       :optimizations        :none
                                       :source-map-timestamp true}}
                       {:id           "test"
                        :source-paths ["src" "test"]
                        :figwheel     {:on-jsload rosso.test-runner/main!}
                        :compiler     {:main          rosso.test-runner
                                       :asset-path    "target/js/compiled/test"
                                       :output-to     "target/test.js"
                                       :output-dir    "target/js/compiled/test"
                                       :target        :nodejs
                                       :optimizations :none}}
                       {:id           "prod"
                        :source-paths ["src"]
                        :compiler     {:main          rosso.main
                                       :output-to     "target/main.js"
                                       :output-dir    "target/js/compiled/prod"
                                       :target        :nodejs
                                       :optimizations :simple}}]}
  :profiles {:dev {:dependencies  [[figwheel-sidecar "0.5.18"]
                                   [cider/piggieback "0.3.10"]
                                   [org.clojure/tools.namespace "0.2.11"]]
                   :repl-options  {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :clean-targets ["target" "node_modules"]
                   :source-paths  ["src" "env/dev"]}})
