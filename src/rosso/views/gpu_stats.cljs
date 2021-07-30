(ns rosso.views.gpu-stats
  (:require [clojure.string :as string]))

(defn view
  "Display link to the template project and share features.
  Returns hiccup :box vector."
  [_]
  [:box#gpu-stats
   {:top 0
    :right 0
    :width "70%"
    :height "50%"
    :style {:border {:fg :blue}}
    :border {:type :line}
    :label " GPU Monitoring "}
   [:box#content
    {:top 1
     :left 1
     :right 1
     :bottom 1}
    [:box {:top 1
           :align :center
           :style {:fg :red}
           :content "https://github.com/eccentric-j/cljs-tui-template"}]
    [:text {:top 5
            :align :center
            :content  (string/join "\n  - "
                            ["Features:\n"
                             "Use ClojureScript and functional programming\n    to deliver rich CLIs quickly"
                             "Manage your state and side-effects with re-frame"
                             "Compose simple view functions into a rich UI\n    with Reagent React views"
                             "Use web technologies you are already familiar with"
                             "Faster start up time with node"
                             "Supports shadow, figwheel-main, or lein-figwheel"])}]]])