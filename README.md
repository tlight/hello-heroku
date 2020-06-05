# hello-heroku

A bare bones Clojure API server deployed to heroku as a jar.

## Requirements
```
$ brew install clojure
```

## Quick Start

```
$ git clone git@github.com:tlight/hello-heroku.git
$ cd hello-heroku
$ sed -i '' 's/hello-heroku/my-app-name/' Makefile
$ make init
$ make build
$ make deploy
```

The make commands are equivalent to the following:
```
$ heroku install java
$ heroku app:create hello-heroku

$ clj -A:uberjar

$ heroku deploy:jar target/uber.jar --app hello-heroku
```



