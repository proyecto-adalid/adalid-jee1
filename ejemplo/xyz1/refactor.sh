#!/bin/bash
scriptname=$(basename "$BASH_SOURCE")
scriptpath=`cd $(dirname "$BASH_SOURCE"); pwd`
me=$scriptname
xs=$scriptpath/variables.sh
unset variables
[ -x "$xs" ] && source "$xs"
[ -z "$variables" ] && exit 100 # environment variables not set
echo $me refactoriza el proyecto de plantilla
read -p "ejecutar $me? (s/n): " -n 1; echo ""; REPLY=`echo $REPLY|tr '[:upper:]' '[:lower:]'`
[ "$REPLY" != "s" ] && exit 101 # cancelled by user

cp -ru $project_source_dir/development/resources/projects/adalid.project      $adalid_dir/.project
cp -ru $project_source_dir/development/resources/projects/third-party.project $third_party_dir/.project

cd $project_source_dir/development/resources/libraries/netbeans/linux
regex=/home/workspace
value=$workspace
if [ "$regex" != "$value" ]; then
    echo regex=$regex
    echo value=$value
    sed -i "s|${regex}|${value}|g" *.xml
fi

cd $project_source_dir/meta/src/meta/proyecto
regex=jee1
value=$project
if [ "$regex" != "$value" ]; then
    echo regex=$regex
    echo value=$value
    sed -i "s|${regex}|${value}|g" *.java
fi
