(ns nc.oracle.spec
  (:require [clojure.spec.alpha :as s])
  (:import (org.apache.commons.validator.routines UrlValidator)))

(defonce ^:private validator
         (UrlValidator.))

(defn valid-url? [^String url]
  (.isValid validator url))

(s/def ::url
  (s/and
    string?
    valid-url?))

(s/def ::author
  string?)

(s/def ::title
    string?)

(s/def ::description
  string?)

(s/def ::url-to-image
  (s/and
    string?
    valid-url?))

(s/def ::published-at
  string?)

(s/def ::article
  (s/keys :req [::url ::title ::url-to-image]
          :opt [::published-at ::author ::description]))
