#!/usr/bin/env sh

aws lambda update-function-code \
--region us-east-2 \
--function-name lamda-selenium-java-latest \
--s3-bucket varunas-lamda-selenium-java \
--s3-key lamda-selenium-java-1.0-SNAPSHOT-all.jar \


