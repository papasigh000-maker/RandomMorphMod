#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -e

DIRNAME=`cd "$(dirname "$0")" && pwd`
APP_HOME="$DIRNAME"

if [ -z "$JAVA_HOME" ]; then
    JAVA_HOME=$(java -XshowSettings:properties -version 2>&1 | grep 'java.home' | awk '{print $NF}' | xargs dirname | xargs dirname)
fi

if [ ! -x "$JAVA_HOME/bin/java" ]; then
    echo "Error: JAVA_HOME is not properly set or java is not available"
    exit 1
fi

exec "$JAVA_HOME/bin/java" -XX:+IgnoreUnrecognizedVMOptions -XX:+UseG1GC -XX:G1NewCollectionIntervalInMs=300 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:+ParallelRefProcEnabled -XX:+AlwaysPreTouch -XX:+UnlockDiagnosticVMOptions -XX:G1SummarizeRSetStatsPeriod=1 -Xms1024m -Xmx2g -Dfile.encoding=UTF-8 -Duser.country=US -Duser.language=en -cp "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
