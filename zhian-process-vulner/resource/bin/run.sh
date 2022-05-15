#!/usr/bin/sh
#示例：该项目的启动脚本
echo "Starting ... "

module_name=$1

BIN_HOME=$(cd "$(dirname "$0")"&& pwd)
CONF_HOME=$(cd "$BIN_HOME/../conf"&& pwd)
LIB_HOME=$(cd "$BIN_HOME/../lib"&& pwd)

java -cp "$CONF_HOME:$LIB_HOME/*" com.lxt.lab.FuckZhiAn "$module_name"