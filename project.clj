(defproject finitize "0.0.1-SNAPSHOT"
  :description "Limit and realize possibly infinite seqs"
  :url "https://github.com/borkdude/finitize"
  :scm {:name "git"
        :url "https://github.com/borkdude/finitize"}
  :license {:name "Eclipse Public License 1.0"
            :url "http://opensource.org/licenses/eclipse-1.0.php"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass
                                    :sign-releases false}]])
