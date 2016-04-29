#!/bin/bash
variables=yes
variables_scriptname=$(basename "$BASH_SOURCE")
variables_scriptpath=`cd "$(dirname "$BASH_SOURCE")"; pwd`
pushd $variables_scriptpath/../../../../.. > /dev/null
export project_dir=$(pwd)
export project_source_dir=$project_dir/source
export project=$(basename "$project_dir")
export workspace=`cd "$(dirname "$project_dir")"; pwd`
export adalid_dir=$workspace/adalid
export third_party_dir=$workspace/third-party
popd > /dev/null
unset meta_project
unset meta_project_dir
unset meta_project_source_dir
for archivo in $(find $workspace -maxdepth 2 -type f -name "META"); do
    export meta_project_dir=`cd "$(dirname "$archivo")"; pwd`
    export meta_project_source_dir=$meta_project_dir/source
    export meta_project=$(basename "$meta_project_dir")
    break
done

echo project=$project
echo project_dir=$project_dir
echo project_source_dir=$project_source_dir
echo ""
echo workspace=$workspace
echo adalid_dir=$adalid_dir
echo third_party_dir=$third_party_dir
echo ""
echo meta_project=$meta_project
echo meta_project_dir=$meta_project_dir
echo meta_project_source_dir=$meta_project_source_dir
echo ""

[ -z "$project" ]                   && unset variables
[ ! -d "$project_dir" ]             && unset variables
[ ! -d "$project_source_dir" ]      && unset variables
[ ! -d "$workspace" ]               && unset variables
[ ! -d "$adalid_dir" ]              && unset variables
[ ! -d "$third_party_dir" ]         && unset variables
[ -z "$meta_project" ]              && unset variables
[ ! -d "$meta_project_dir" ]        && unset variables
[ ! -d "$meta_project_source_dir" ] && unset variables

[ -z "$project" ]                   && echo project $project no es un nombre valido de proyecto
[ ! -d "$project_dir" ]             && echo project_dir $project_dir no existe o no es un directorio
[ ! -d "$project_source_dir" ]      && echo project_source_dir $project_source_dir no existe o no es un directorio
[ ! -d "$workspace" ]               && echo workspace $workspace no existe o no es un directorio
[ ! -d "$adalid_dir" ]              && echo adalid_dir $adalid_dir no existe o no es un directorio
[ ! -d "$third_party_dir" ]         && echo third_party_dir $third_party_dir no existe o no es un directorio
[ -z "$meta_project" ]              && echo meta_project $meta_project no es un nombre valido de proyecto
[ ! -d "$meta_project_dir" ]        && echo meta_project_dir $meta_project_dir no existe o no es un directorio
[ ! -d "$meta_project_source_dir" ] && echo meta_project_source_dir $meta_project_source_dir no existe o no es un directorio
