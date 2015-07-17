@echo off
cd /d "%~dp0"
setlocal
call variables
set meta_dir=%project_source_dir%\meta
set meta_dir
cd /d "%meta_dir%"
set CLASSPATH=%meta_dir%\dist\meta.jar
set CLASSPATH=%CLASSPATH%;%adalid_dir%\lib\adalid-jee1.jar
set CLASSPATH=%CLASSPATH%;%adalid_dir%\lib\adalid-core.jar
set CLASSPATH=%CLASSPATH%;%adalid_dir%\lib\adalid-commons.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\commons-collections-3.2.1.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\commons-io-2.1.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\commons-lang-2.6.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\joda-time-1.6.2.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\log4j-1.2.16.jar
set CLASSPATH=%CLASSPATH%;%third_party_dir%\lib\velocity-1.7.jar
set CLASS=meta.proyecto.Maestro
set CLASS
set JAVA_PARAMETER_LIST=
echo.
java -cp %CLASSPATH% %CLASS% %JAVA_PARAMETER_LIST%
echo.
pause
goto:eof
