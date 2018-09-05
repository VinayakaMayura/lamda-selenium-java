#!/usr/bin/env sh


EVENTS=$(jq -c '.[]' src/test/resources/fixtures/events.json)

while read -r EVENT; do
       source run-single-test.sh "$EVENT"
done <<< "$EVENTS"

