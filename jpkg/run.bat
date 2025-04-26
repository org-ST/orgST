@echo off
set JAVA_OPTS=--module-path lib\win --add-modules javafx.controls,javafx.fxml
java %JAVA_OPTS% -jar app-all.jar