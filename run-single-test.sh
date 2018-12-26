#!/usr/bin/env sh

TEST_JSON=$1

TMP_FILE=$(mktemp -t "lambda")

aws lambda invoke \
--invocation-type RequestResponse \
--function-name lambda-selenium-demo \
--region us-east-2 \
--payload "$TEST_JSON" \
"$TMP_FILE" > /dev/null

RESPONSE=$(cat "$TMP_FILE")
rm "$TMP_FILE"
echo "$RESPONSE"