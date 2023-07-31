(ns my-element
  (:require [squint.core :refer [defclass js-template]]
            ["lit" :as lit]))

(defclass MyElement
  (extends lit/LitElement)
  (field name "World")
  (field count 0)

  (constructor [_]
               (super))

  Object
  (render [this]
          (js-template lit/html
                       "<h1>" (.-name this)  "</h1>"
                       "<button @click=" (.-_onClick this) " part=\"button\">"
                       "Click Count: " count
                       "</button>"))

  (_onClick [this]
            (set! count (inc count))
            (.dispatchEvent this (new js/CustomEvent "count-changed"))))

(set! (.-properties MyElement) #js {"count" #js {}})

(js/window.customElements.define "my-element" MyElement)
