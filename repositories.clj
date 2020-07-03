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

(def repositories {:emacs-configuration {:url "git@github.com:hlissner/doom-emacs.git"
                                         :dirname ".emacs.d"
                                         :path home}

                   :dotfiles {:url "git@github.com:karthikmuralidharan/dotfiles.git"
                              :dirname ".dotfiles"
                              :path home}

                   :notes {:url "git@github.com:karthikmuralidharan/notes.git"
                           :dirname "notes"
                           :path home}

                   :dotfiles-private {:url "git@github.com:karthikmuralidharan/dotfiles-private.git"
                                      :dirname ".dotfiles-private"
                                      :path home}

                   :emacs-personal-configuration {:url "git@github.com:karthikmuralidharan/doom-emacs-private.git"
                                                  :dirname ".doom.d"
                                                  :path home}})

(let [repo-items (vals repositories)]
  (doseq [item repo-items]
    (git-clone item)))
