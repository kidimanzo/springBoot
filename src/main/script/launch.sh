#! /bin/bash

JAVA_ENTRYPOINT=/siegfried/@project.name@-@project.version@.jar
/usr/bin/env java -jar $JAVA_OPTS $JAVA_ENTRYPOINT
