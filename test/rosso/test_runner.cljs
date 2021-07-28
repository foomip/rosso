(ns rosso.test-runner
  (:require
   ;; Require all your test files you wish to run
   [rosso.core-test]
   [cljs.test :refer [run-tests]]))

;; Define a reporter. On failure exit with code 1 for better CI support.
(defmethod cljs.test/report [:cljs.test/default :end-run-tests] [m]
  (if (cljs.test/successful? m)
    (.exit js/process 0)
    (.exit js/process 1)))

;; Add the tests you wish to run here
(defn main!
  "Main test entrypoint. Runs the required test namespaces."
  []
  (cljs.test/run-tests 'rosso.core-test))

(set! *main-cli-fn* main!)
