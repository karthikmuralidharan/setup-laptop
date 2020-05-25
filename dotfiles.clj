#!/usr/bin/env bb

(def rc-dirs [
               (str (System/getenv "HOME") "/" ".dotfiles")
               (str (System/getenv "HOME") "/" ".dotfiles-private")])

(doseq [dir rc-dirs]
  (println "Symlinking dotfiles at" dir)
  (shell/sh "rcup" "-d" dir))
