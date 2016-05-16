## build ##
mvn package
#or
mvn -o package
#or
mvn clean dependency:copy-dependencies package

## run ##
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
