(def srcdir (first *command-line-args*))
(def bindir (second *command-line-args*))

(defn class-name [fname]
  "Strip srcdir and suffix, and replace file separators by dots."
  (.. (if (. fname startsWith srcdir) (. fname substring (. srcdir length)) fname)
      (replaceAll "\\.clj$" "")
      (replace java.io.File/separatorChar \.)
      (replaceAll "^\\." "")))

(loop [args (drop 2 *command-line-args*)]
  (when (first args)
    (let [cn (class-name (first args))]
      (println (str "Compiling " cn ".."))
      (binding [*compile-path* bindir] (compile (symbol cn)))
      (recur (rest args)))))
