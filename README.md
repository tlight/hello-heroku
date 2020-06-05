# hello-heroku

A bare bones Clojure API server deployed to heroku as a jar.

# Requirements
```
$ brew install clojure
```

You will need to change the APP variable in the Makefile:
```
$ make init
$ make build
$ make deploy
```

Which is equivalent to the following:
```
$ heroku install java
$ heroku app:create hello-heroku

$ clj -A:uberjar

$ heroku deploy:jar target/uber.jar --app hello-heroku
```



