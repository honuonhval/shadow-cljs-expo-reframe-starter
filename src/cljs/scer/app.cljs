(ns scer.app
  (:require [shadow.expo :as expo]
            ["react-native" :as rn]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [scer.events]
            [scer.subs]))

;; from @thheller reagent-expo
;; must use defonce and must refresh full app so metro can fill these in
;; at live-reload time 'require' does not exist and will cause errors
;; must use path relative to :output-dir
(defonce shadowcljs-img (js/require "../assets/shadow-cljs.png"))

(def styles
  ^js
  (-> {:container {:flex            1
                   :backgroundColor "#fff"
                   :alignItems      "center"
                   :justifyContent  "center"}
       :title {:fontWeight "bold"
               :fontSize   24
               :color      "blue"}}
          (clj->js)
          (rn/StyleSheet.create)))

(defn root
  []
  [:> rn/View {:style (.-container styles)}
   [:> rn/Image {:source shadowcljs-img :style {:width 200
                                                :height 200}}]
   [:> rn/Text "Hello from Clojurescript + Shadow-cljs"]])

(defn start
  {:dev/after-load true}
  []
  (expo/render-root (r/as-element [root])))

(defn init
  []
  (rf/dispatch [:initialize-db])
  (start))
