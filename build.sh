#!/usr/bin/env bash

time (
    if ! ./gradlew clean build; then
        exit
    fi

    if ! ./gradlew clean build -DE2E; then
        exit
    fi
)