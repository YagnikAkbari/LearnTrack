#!/bin/bash

rm -rf out
mkdir out

javac -d out $(find src -name "*.java")

java -cp out com.airtribe.learntrack.Main