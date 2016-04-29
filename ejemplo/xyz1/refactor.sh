#!/bin/bash
fart() {
    if [ "$1" != "$2" ]; then
        echo regex=$1
        echo value=$2
        echo files=$3
        echo ""
        sed -i "s|${1}|${2}|g" $3
    fi
}

fartjava() {
if [ -d "$1" ]; then
    pushd $1 > /dev/null
    pwd
    fart "${opc}ap1" "${npc}ap1" "*.java"
    fart "${OPC}AP1" "${NPC}AP1" "*.java"
    popd > /dev/null
fi
}

language=$(locale | grep LANG | cut -d= -f2 | cut -d_ -f1)
scriptname=$(basename "$BASH_SOURCE")
scriptpath=`cd "$(dirname "$BASH_SOURCE")"; pwd`
me=$scriptname
xs=$scriptpath/variables.sh
unset variables
[ -x "$xs" ] && source "$xs"
[ -z "$variables" ] && exit 100 # environment variables not set
xs=$scriptpath/variables-home.sh
[ -x "$xs" ] && source "$xs"
[ -x "$xs" ] || exit 100 # environment variables not set
xs=$scriptpath/check.sh
[ -x "$xs" ] && source "$xs" skip_info_messages
[ -z "$variables" ] && exit 100 # environment variables not set
echo $me refactoriza el proyecto plantilla
read -p "ejecutar $me? (s/n) [s] " -n 1; [ -n "$REPLY" ] && echo ""; [ -z "$REPLY" ] && REPLY="s"; REPLY=`echo $REPLY|tr '[:upper:]' '[:lower:]'`
[ "$REPLY" != "s" ] && exit 101 # cancelled by user
echo ""

if [ "$JBOSS_MAJOR_VERSION_NUMBER" = "7" ]; then
    jboss_project=jboss.project
else
    jboss_project=wildfly.project
fi
[ -d "$adalid_dir" ]      && cp -ru $project_source_dir/development/resources/projects/adalid.project       $adalid_dir/.project
[ -d "$GLASSFISH_HOME" ]  && cp -ru $project_source_dir/development/resources/projects/glassfish.project    $GLASSFISH_HOME/.project
[ -d "$JBOSS_HOME" ]      && cp -ru $project_source_dir/development/resources/projects/$jboss_project       $JBOSS_HOME/.project
[ -d "$third_party_dir" ] && cp -ru $project_source_dir/development/resources/projects/third-party.project  $third_party_dir/.project
echo ""

ows="/opt/workspace"
ogh="/opt/glassfish-4.0/glassfish"
if [ "$JBOSS_MAJOR_VERSION_NUMBER" = "7" ]; then
    ojh="/opt/jboss-as-7.1.1.Final"
elif [ "$JBOSS_MAJOR_VERSION_NUMBER" = "10" ]; then
    ojh="/opt/wildfly-10.0.0.Final"
else
    ojh="/opt/wildfly-9.0.0.Final"
fi
ooh="/opt/oraclexe/app/oracle/product/11.2.0/server"
oph="/opt/PostgreSQL/9.2"
opv="postgresql-9.2-1002.jdbc4"
opc="jee1"
OPC="JEE1"

nws="${workspace:-$(echo $ows)}"
ngh="${GLASSFISH_HOME:-$(echo $ogh)}"
njh="${JBOSS_HOME:-$(echo $ojh)}"
noh="${ORACLE_HOME:-$(echo $ooh)}"
nph="${POSTGRESQL_HOME:-$(echo $oph)}"
npv="${POSTGRESQL_DRIVER_VERSION:-$(echo $opv)}"
npc=`echo $project|tr '[:upper:]' '[:lower:]'`
NPC=`echo $project|tr '[:lower:]' '[:upper:]'`

if [ -d "$project_source_dir/development/resources/libraries/eclipse" ]; then
    pushd $project_source_dir/development/resources/libraries/eclipse > /dev/null
    pwd
    fart "$opv" "$npv" "*.userlibraries"
    popd > /dev/null
fi

if [ -d "$project_source_dir/development/resources/libraries/netbeans/linux" ]; then
    pushd $project_source_dir/development/resources/libraries/netbeans/linux > /dev/null
    pwd
    fart "$ows" "$nws" "*.xml"
    fart "$ogh" "$ngh" "*.xml"
    fart "$ojh" "$njh" "*.xml"
    fart "$ooh" "$noh" "*.xml"
    fart "$oph" "$nph" "*.xml"
    fart "$opv" "$npv" "*.xml"
    popd > /dev/null
fi

if [ -d "$project_source_dir/development/resources/scripts/linux" ]; then
    pushd $project_source_dir/development/resources/scripts/linux > /dev/null
    pwd
    fart "meta-$opc" "meta-$npc" "*.sh"
    popd > /dev/null
fi

if [ -d "$project_source_dir/development/resources/scripts/windows" ]; then
    pushd $project_source_dir/development/resources/scripts/windows > /dev/null
    pwd
    fart "meta-$opc" "meta-$npc" "*.bat"
    popd > /dev/null
fi

if [ -d "$project_source_dir/meta" ]; then
    pushd $project_source_dir/meta > /dev/null
    pwd
    fart "meta-$opc" "meta-$npc" ".project"
    popd > /dev/null
fi

if [ -d "$project_source_dir/meta/nbproject" ]; then
    pushd $project_source_dir/meta/nbproject > /dev/null
    pwd
    fart "meta-$opc" "meta-$npc" "project.*"
    popd > /dev/null
fi

fartjava "$project_source_dir/meta/src/meta/proyecto"
fartjava "$project_source_dir/meta/src/meta/proyecto/oracle"
fartjava "$project_source_dir/meta/src/meta/util"

unset fart fartjava
