#!/usr/bin/env sh

#aws lambda update-function-code \
#--region us-east-2 \
#--function-name lamda-selenium-java-latest \
#--s3-bucket varunas-lamda-selenium-java \
#--s3-key lamda-selenium-java-1.0-SNAPSHOT-all.jar \


aws lambda create-function \
--region us-east-2 \
--function-name aws-lambda-java-vodQA \
--code S3Bucket=varuna-lambda-vodqa,S3Key=lamda-selenium-java-1.0-SNAPSHOT-all.jar \
--role arn:aws:iam::************:role/lambda_basic_execution \
--handler lamda.MyFirstLambdaFunction \
--runtime java8 \
--timeout 30 \
--memory-size 512 \
