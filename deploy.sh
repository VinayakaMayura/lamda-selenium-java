#!/usr/bin/env sh

aws lambda update-function-code \
--function-name lambda-selenium-java \
--zip-file fileb://build/libs/lamda-selenium-java-1.0-SNAPSHOT-all.jar \
--publish
