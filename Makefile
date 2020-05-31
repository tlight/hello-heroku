PORT=3000
APP=hello-heroku

run::
	PORT=$(PORT) clj -m app.core

build::
	clj -A:uberjar

init::
	heroku plugins:install java
	heroku create $(APP) --no-remote

deploy::
	heroku deploy:jar target/uber.jar --app $(APP)

runjar::
	PORT=$(PORT) java -cp target/uber.jar clojure.main -m app.core

logs::
	heroku logs --tail --app $(APP)

repl::
	heroku ps:exec --app $(APP) "nc localhost 5555"

jconsole::
	heroku java:jconsole --app $(APP)

jmap::
	heroku java:jmap --app $(APP)

jstack::
	heroku java:jstack --app $(APP)

visualvm::
	heroku java:visualvm --app $(APP)

