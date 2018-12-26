#!/usr/bin/env sh

# Get Chromedriver
curl -SL https://chromedriver.storage.googleapis.com/2.35/chromedriver_linux64.zip> chromedriver.zip
unzip chromedriver.zip -d ../lib/
rm chromedriver.zip