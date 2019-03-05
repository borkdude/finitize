# finitize

Limit and realize possibly infinite seqs

## Rationale

Sometimes I want to force evaluation of some data but not wait forever.

This library is used in [re-find](https://re-find.it) to not crash the browser
when a user types something like `(map inc (range))`. It's also used when
running examples from [ClojureDocs](https://clojuredocs.org) to verify
[speculative](https://github.com/borkdude/speculative) specs.

## Usage

``` clojure
$ clj
Clojure 1.10.0
user=> (require '[finitize.core :refer [finitize]])
nil

;; by default 100 elements are realized and taken
user=> (finitize (map inc (range)))
(1 2 3 4 5 6 7 8 9 10 11 ...)

;; this is customizable by providing an additional argument:
user=> (finitize (map inc (range)) 10)
(1 2 3 4 5 6 7 8 9 10)

;; calling `finitize` on something which is not a seq-like data structure will just return the thing:
user=> (finitize 1)
1
;; so it's safe to call it on anything
```

## Extend

Currently unsupported types can implement the `Finitize` protocol:

``` clojure
user=> (require '[finitize.core :refer [finitize Finitize]])
nil
user=> (extend-type String Finitize (finitize ([this] (finitize this 100)) ([this n] (subs this 0 n))))
nil
user=> (finitize "hello" 2)
"he"
```

## Tests

``` clojure
$ clj -A:test:clj-test-runner

Running tests in #{"test"}

Testing finitize.core-test

Ran 1 tests containing 6 assertions.
0 failures, 0 errors.

$ clj -A:test:cljs-test-runner

Testing finitize.core-test

Ran 1 tests containing 6 assertions.
0 failures, 0 errors.

```

## License

Copyright © 2019 Michiel Borkent

Distributed under the EPL License, same as Clojure. See LICENSE.
