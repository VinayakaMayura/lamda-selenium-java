#!/usr/bin/env sh


EVENTS=$(jq -c '.[]' src/test/resources/fixtures/events-sequential.json)

while read -r EVENT; do
       echo "invoking lambda with event " + "$EVENT"
       RESPONSE=$(source run-single-test.sh "$EVENT")
       echo "Response for $EVENT IS $RESPONSE"
done <<< "$EVENTS"
