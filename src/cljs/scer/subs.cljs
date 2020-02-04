(ns scer.subs
  (:require [re-frame.core :as rf :refer [reg-sub]]))

(reg-sub
 :initialized?
 (fn [db _]
   (not (empty? db))))




