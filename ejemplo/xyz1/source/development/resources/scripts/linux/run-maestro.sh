#!/bin/bash
clear
scriptname=$(basename "$BASH_SOURCE")
scriptpath=`cd "$(dirname "$BASH_SOURCE")"; pwd`
me=$scriptname
xs=$scriptpath/variables.sh
unset variables
[ -x "$xs" ] && source "$xs"
[ -z "$variables" ] && exit 100 # environment variables not set
echo $me ejecuta el proyecto maestro
read -p "ejecutar $me? (s/n) [s] " -n 1; [ -n "$REPLY" ] && echo ""; [ -z "$REPLY" ] && REPLY="s"; REPLY=`echo $REPLY|tr '[:upper:]' '[:lower:]'`
[ "$REPLY" != "s" ] && exit 101 # cancelled by user
echo ""
meta_dir=$project_source_dir/meta
echo meta_dir=$meta_dir
cd "$meta_dir"
CLASSPATH=$meta_dir/dist/meta-xyz1.jar
CLASSPATH=$CLASSPATH:$adalid_dir/lib/adalid-jee1.jar
CLASSPATH=$CLASSPATH:$adalid_dir/lib/adalid-core.jar
CLASSPATH=$CLASSPATH:$adalid_dir/lib/adalid-commons.jar
CLASSPATH=$CLASSPATH:$third_party_dir/lib/commons-collections-3.2.1.jar
CLASSPATH=$CLASSPATH:$third_party_dir/lib/commons-io-2.1.jar
CLASSPATH=$CLASSPATH:$third_party_dir/lib/commons-lang-2.6.jar
CLASSPATH=$CLASSPATH:$third_party_dir/lib/log4j-1.2.16.jar
CLASSPATH=$CLASSPATH:$third_party_dir/lib/velocity-1.7.jar
case "`uname`" in
    CYGWIN*) CLASSPATH=`cygpath --windows --path $CLASSPATH`
esac
CLASS=meta.proyecto.Maestro
JAVA_PARAMETER_LIST=
echo ""
echo CLASSPATH=$CLASSPATH
echo CLASS=$CLASS
echo JAVA_PARAMETER_LIST=$JAVA_PARAMETER_LIST
java -cp $CLASSPATH $CLASS $JAVA_PARAMETER_LIST
echo ""
