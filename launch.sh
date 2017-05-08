#!/bin/bash
nohup sf -serve 0.0.0.0:5138&
JAVA_ENTRYPOINT=siegfired-0.1.0.jar
/usr/bin/java -jar $JAVA_ENTRYPOINT

