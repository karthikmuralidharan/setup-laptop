#!/usr/bin/env bb

(def home (System/getenv "HOME"))

(def emacs-configuration {
                          :url "git@github.com:hlissner/doom-emacs.git"
                          :dirname ".emacsd"
                          :path home})

(def emacs-personal-configuration {
                                   :url "git@github.com:karthikmuralidharan/doom-emacs-private.git"
                                   :dirname ".doom.d"
                                   :path home})

(def emacs {
            :url "git@github.com:karthikmuralidharan/doom-emacs-private.git"
            :dirname ".doom.d"
            :path (str home "/Desktop")})

(defn git-clone [{:keys [url path dirname]}]
  (let [abs-path (str home "/" dirname)
        dir-not-exist? (not (.isDirectory (io/file abs-path)))]
    (when dir-not-exist?
      (println "cloning " url)
      (shell/sh "git clone" url abs-path))))

(git-clone emacs)

(defn setup-emacs []
  (doseq [repo-config [emacs-configuration emacs-personal-configuration]]
    (git-clone repo-config)))

      
;; (setup-emacs)

