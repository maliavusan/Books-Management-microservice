@echo off
set JAR_NAME=Books-Management-0.0.1-SNAPSHOT.jar
set JAR_PATH=.\target\%JAR_NAME%

echo Cleaning and installing Maven dependencies...
call mvn clean install

if %errorlevel% neq 0 (
    echo Maven build failed. Exiting.
    exit /b %errorlevel%
)

echo Starting Spring Boot microservice...

java -jar %JAR_PATH%

echo Microservice started.
