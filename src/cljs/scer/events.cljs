(ns scer.events
  (:require [re-frame.core :refer [reg-event-db]]
            [scer.db :refer [default-db]]))

(reg-event-db
 :initialize-db
 (fn [_ _]
   default-db))

