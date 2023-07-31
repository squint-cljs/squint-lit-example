(ns my-element
  (:require #_[squint.core :refer [defclass js-template]]
            ["lit" :as lit]))

(defclass MyElement
  (extends lit/LitElement)
  (field name "World")
  (field count 0)

  (constructor [_]
               (super))

  Object
  (render [this]
          (prn :render!!!!)
          (js-template lit/html
                       "<h1>" (.-name this)  "</h1>"
                       "<button @click=" (.-_onClick this) " part=\"button\">"
                       "Click Count: " (.-count this)
                       "</button>"))

  (_onClick [this]
            (set! count (inc count))
            (prn count) ;; this works
            (.dispatchEvent this (new js/CustomEvent "count-changed")))

  )

(js/window.customElements.define "my-element" MyElement)
