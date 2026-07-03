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
DIRNAME_REL=`cd "$(dirname "$0")" && pwd`
DIRNAME_REL_ABS="$(cd "$DIRNAME_REL" 2>/dev/null && pwd -P)"
DIRNAME_REL="${DIRNAME_REL_ABS##*/}"

if [ ! -d "$APP_HOME/gradle/wrapper" ]; then
    mkdir -p "$APP_HOME/gradle/wrapper"
fi

exec java -XX:+IgnoreUnrecognizedVMOptions -XX:+UseG1GC -XX:G1NewCollectionIntervalInMs=300 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:+ParallelRefProcEnabled -XX:+AlwaysPreTouch -XX:+UnlockDiagnosticVMOptions -XX:G1SummarizeRSetStatsPeriod=1 -Xms1024m -Xmx2g -Dfile.encoding=UTF-8 -Duser.country=US -Duser.language=en -Dorg.gradle.appname="$APP_BASE_NAME" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
