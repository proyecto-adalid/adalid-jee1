#!/bin/bash
fspp() {
    numargs=$#
    dollar1=$1
    shift
    for ((i=1 ; i < numargs ; i++))
    do
        [ "$dollar1" == "$1" ] && return 1
        shift
    done
}

xinfo() {
    if [ -n "$1" ]; then
        if [ -n "$line_break" ]; then
            echo ""
            line_break=""
        fi
        echo "$1"
    fi
}

xwarn() {
    xinfo "ADVERTENCIA: $1"
}

xerror() {
    xinfo "ERROR: $1"
    unset variables
}

scriptpath=`cd "$(dirname "$BASH_SOURCE")"; pwd`
xs=$scriptpath/variables.sh
unset variables
[ -x "$xs" ] && source "$xs"
[ -z "$variables" ] && exit 100 # environment variables not set
xs=$scriptpath/variables-home.sh
[ -x "$xs" ] && source "$xs"
[ -x "$xs" ] || exit 100 # environment variables not set

npc=`echo $project|tr '[:upper:]' '[:lower:]'`
dir=$project_dir

fspp skip_info_messages $*; [ $? = 1 ] && skip_info_messages=yes
fspp skip_warning_messages $*; [ $? = 1 ] && skip_warning_messages=yes
fspp skip_error_messages $*; [ $? = 1 ] && skip_error_messages=yes

line_break=true
if [ -z "$skip_info_messages" ]; then
    [ -n "$project"            ] && xinfo "project=$project"
    [ -n "$project_dir"        ] && xinfo "project_dir=$project_dir"
    [ -n "$project_source_dir" ] && xinfo "project_source_dir=$project_source_dir"
    [ -n "$workspace"          ] && xinfo "workspace=$workspace"
    [ -n "$adalid_dir"         ] && xinfo "adalid_dir=$adalid_dir"
    [ -n "$third_party_dir"    ] && xinfo "third_party_dir=$third_party_dir"
fi

line_break=true
if [ -z "$skip_info_messages" ]; then
    [ -n "$GLASSFISH_HOME"             ] && xinfo "GLASSFISH_HOME=$GLASSFISH_HOME"
    [ -n "$JBOSS_HOME"                 ] && xinfo "JBOSS_HOME=$JBOSS_HOME"
    [ -n "$JBOSS_MAJOR_VERSION_NUMBER" ] && xinfo "JBOSS_MAJOR_VERSION_NUMBER=$JBOSS_MAJOR_VERSION_NUMBER"
    [ -n "$ORACLE_HOME"                ] && xinfo "ORACLE_HOME=$ORACLE_HOME"
    [ -n "$POSTGRESQL_HOME"            ] && xinfo "POSTGRESQL_HOME=$POSTGRESQL_HOME"
    [ -n "$POSTGRESQL_DRIVER_VERSION"  ] && xinfo "POSTGRESQL_DRIVER_VERSION=$POSTGRESQL_DRIVER_VERSION"
fi

line_break=true
if [ -z "$skip_warning_messages" ]; then
    [ -z "$GLASSFISH_HOME"  -o -d "$GLASSFISH_HOME"             ] || xwarn "GLASSFISH_HOME $GLASSFISH_HOME no existe o no es un directorio"
    [ -z "$JBOSS_HOME"      -o -d "$JBOSS_HOME"                 ] || xwarn "JBOSS_HOME $JBOSS_HOME no existe o no es un directorio"
    [ -z "$JBOSS_HOME"      -o -n "$JBOSS_MAJOR_VERSION_NUMBER" ] || xwarn "variable JBOSS_MAJOR_VERSION_NUMBER no definida"
    [ -z "$ORACLE_HOME"     -o -d "$ORACLE_HOME"                ] || xwarn "ORACLE_HOME $ORACLE_HOME no existe o no es un directorio"
    [ -z "$POSTGRESQL_HOME" -o -d "$POSTGRESQL_HOME"            ] || xwarn "POSTGRESQL_HOME $POSTGRESQL_HOME no existe o no es un directorio"
    [ -z "$POSTGRESQL_HOME" -o -n "$POSTGRESQL_DRIVER_VERSION"  ] || xwarn "variable POSTGRESQL_DRIVER_VERSION no definida"
fi

line_break=true
if [ -z "$skip_error_messages" ]; then
    [  "$npc" == "jee1"       ] && xerror "el nuevo codigo de proyecto no puede ser $project"
    [  "$npc" == "workspace"  ] && xerror "el nuevo codigo de proyecto no puede ser $project"
    [[ "$npc" =~ ^[a-z].*$   ]] || xerror "el nuevo codigo de proyecto ($project) no comienza por una letra"
    [[ "$npc" =~ ^[a-z0-9]*$ ]] || xerror "el nuevo codigo de proyecto ($project) contiene caracteres invalidos"
    [[ "$dir" =~ ( |\')      ]] && xerror "la ruta del directorio $dir contiene espacios en blanco y, por lo tanto, es invalida"
fi
echo ""
