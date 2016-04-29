#!/bin/bash
variables=yes
variables_scriptname=$(basename "$BASH_SOURCE")
variables_scriptpath=`cd "$(dirname "$BASH_SOURCE")"; pwd`
export project=$(basename "$variables_scriptpath")
export project_dir=$variables_scriptpath
export project_source_dir=$project_dir/source
export workspace=`cd "$(dirname "$variables_scriptpath")"; pwd`
export adalid_dir=$workspace/adalid
export third_party_dir=$workspace/third-party
unset meta_project
unset meta_project_dir
unset meta_project_source_dir

[ -n "$project"            ] || unset variables
[ -d "$project_dir"        ] || unset variables
[ -d "$project_source_dir" ] || unset variables
[ -d "$workspace"          ] || unset variables
[ -d "$adalid_dir"         ] || unset variables
[ -d "$third_party_dir"    ] || unset variables

[ -n "$project"            ] || echo "ERROR: variable project no definida"
[ -d "$project_dir"        ] || echo "ERROR: project_dir $project_dir no existe o no es un directorio"
[ -d "$project_source_dir" ] || echo "ERROR: project_source_dir $project_source_dir no existe o no es un directorio"
[ -d "$workspace"          ] || echo "ERROR: workspace $workspace no existe o no es un directorio"
[ -d "$adalid_dir"         ] || echo "ERROR: adalid_dir $adalid_dir no existe o no es un directorio"
[ -d "$third_party_dir"    ] || echo "ERROR: third_party_dir $third_party_dir no existe o no es un directorio"
