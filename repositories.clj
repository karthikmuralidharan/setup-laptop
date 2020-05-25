#!/usr/bin/env bb

(defn git-clone [{:keys [url path dirname]}]
  (let [abs-path (str path "/" dirname)
        dir-not-exist? (not (.isDirectory (io/file abs-path)))]

    (if dir-not-exist?
      (do (println "cloning " url)
          (shell/sh "git" "clone" url abs-path))
      (println "skipping git clone: directory" abs-path "already exists"))))


;; Configurations
(def home (System/getenv "HOME"))

(def emacs-configuration {:url "git@github.com:hlissner/doom-emacs.git"
                          :dirname ".emacsd"
                          :path home})

(def emacs-personal-configuration {:url "git@github.com:karthikmuralidharan/doom-emacs-private.git"
                                   :dirname ".doom.d"
                                   :path home})

(def dotfiles {:url "git@github.com:karthikmuralidharan/dotfiles.git"
               :dirname ".dotfiles"
               :path home})

(def dotfiles-private {:url "git@github.com:karthikmuralidharan/dotfiles-private.git"}
               :dirname ".dotfiles-private"
               :path home)

(doseq [repo-config [emacs-configuration
                     emacs-personal-configuration
                     dotfiles
                     dotfiles-private]]
    (git-clone repo-config))
