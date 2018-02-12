(defproject spa "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :jvm-opts ["--add-modules" "java.xml.bind"]
  :dependencies [[duct/core "0.6.2"]
                 [duct/module.cljs "0.3.2"]
                 [duct/module.logging "0.3.1"]
                 [duct/module.sql "0.4.2"]
                 [duct/module.web "0.6.4"]
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [org.postgresql/postgresql "42.2.1"]]
  :plugins [[duct/lein-duct "0.10.6"]]
  :main ^:skip-aot spa.main
  :resource-paths ["resources" "target/resources"]
  :prep-tasks     ["javac" "compile" ["run" ":duct/compiler"]]
  :profiles
  {:dev  [:project/dev :profiles/dev]
   :repl {:prep-tasks   ^:replace ["javac" "compile"]
          :repl-options {:init-ns user
                         :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
   :uberjar {:aot :all}
   :profiles/dev {}
   :project/dev  {:source-paths   ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies   [[eftest "0.4.3"]
                                   [integrant/repl "0.3.0"]
                                   [kerodon "0.9.0"]]}})
