#!/usr/bin/env sh

TEST_JSON=$1

echo $TEST_JSON

aws lambda invoke \
--invocation-type RequestResponse \
--function-name lambda-selenium-demo \
--region us-east-2 \
--payload ${TEST_JSON} \
outputfile.txt