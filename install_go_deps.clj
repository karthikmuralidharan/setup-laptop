#!/usr/bin/env bb

(def go-global-tools ["github.com/mdempsky/gocode"
                      "github.com/uudashr/gopkgs/v2/cmd/gopkgs"
                      "github.com/ramya-rao-a/go-outline"
                      "github.com/acroca/go-symbols"
                      "golang.org/x/tools/cmd/guru"
                      "golang.org/x/tools/cmd/gorename"
                      "github.com/cweill/gotests/..."
                      "github.com/fatih/gomodifytags"
                      "github.com/josharian/impl"
                      "github.com/davidrjenni/reftools/cmd/fillstruct"
                      "github.com/haya14busa/goplay/cmd/goplay"
                      "github.com/godoctor/godoctor"
                      "github.com/go-delve/delve/cmd/dlv"
                      "github.com/stamblerre/gocode"
                      "github.com/rogpeppe/godef"
                      "golang.org/x/tools/cmd/goimports"
                      "golang.org/x/lint/golint"
                      "golang.org/x/tools/gopls"])


(defn install-go-tools []
  (println "")
  (doseq [tool go-global-tools]

    (println "Installing" tool)
    (shell/sh "go" "get" tool))

  (println "Go tools installed successfully!!"))

(install-go-tools)
