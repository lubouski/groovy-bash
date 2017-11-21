#!/bin/bash
export foo=$Parameters
export bar=$BUILD_NUMBER
/opt/groovy/bin/groovy /opt/gradle/script-upload.groovy

