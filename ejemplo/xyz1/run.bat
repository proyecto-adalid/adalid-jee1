@echo off
cd /d "%~dp0"
setlocal
call variables
set LOG_FILE="%~dpn0.log"
set LOG_FILE
if exist %LOG_FILE% (del %LOG_FILE%)
set USER_DIR=%project_source_dir%\meta
set USER_DIR 1>>%LOG_FILE%
set USER_DIR
if not exist "%USER_DIR%" echo. & pause & goto:eof
set JAR="%USER_DIR%\dist\meta.jar"
set JAR 1>>%LOG_FILE%
set JAR
if not exist %JAR% echo. & pause & goto:eof
set CLASSPATH=%JAR%
call:add-to-classpath "%adalid_dir%\lib\adalid-jee1.jar"
call:add-to-classpath "%adalid_dir%\lib\adalid-core.jar"
call:add-to-classpath "%adalid_dir%\lib\adalid-commons.jar"
call:add-to-classpath "%third_party_dir%\lib\commons-collections-3.2.1.jar"
call:add-to-classpath "%third_party_dir%\lib\commons-io-2.1.jar"
call:add-to-classpath "%third_party_dir%\lib\commons-lang-2.6.jar"
call:add-to-classpath "%third_party_dir%\lib\joda-time-1.6.2.jar"
call:add-to-classpath "%third_party_dir%\lib\log4j-1.2.16.jar"
call:add-to-classpath "%third_party_dir%\lib\velocity-1.7.jar"
set JAVA_HOME 1>>%LOG_FILE%
set JAVA_HOME
if not defined JAVA_HOME echo. & pause & goto:eof
if not exist "%JAVA_HOME%" echo. & pause & goto:eof
set JAVA_EXE="%JAVA_HOME%\bin\java.exe"
set JAVA_EXE 1>>%LOG_FILE%
set JAVA_EXE
if not exist %JAVA_EXE% echo. & pause & goto:eof
set MAIN_CLASS=
type "%USER_DIR%\nbproject\project.properties">tokens
if exist tokens (
    for /f "tokens=1,2* delims==" %%x in (tokens) do if "%%x" == "main.class" set MAIN_CLASS=%%y
    del tokens
)
set MAIN_CLASS 1>>%LOG_FILE%
set MAIN_CLASS
if not defined MAIN_CLASS (echo. & pause & goto:eof)
set JAVA_OPTIONS=
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dfile.encoding=UTF8
set JAVA_OPTIONS=%JAVA_OPTIONS% -classpath %CLASSPATH%
set JAVA_OPTIONS=%JAVA_OPTIONS% %MAIN_CLASS%
echo.
cd /d "%USER_DIR%"
rem pause
rem echo.
echo %JAVA_EXE% %JAVA_OPTIONS%
echo %JAVA_EXE% %JAVA_OPTIONS% 1>>%LOG_FILE%
call %JAVA_EXE% %JAVA_OPTIONS% 1>>%LOG_FILE% 2>&1
echo.
set siono=N
set /p siono="abrir %LOG_FILE% (S/N) ? [%siono%] "
if /i "%siono%" == "S" (
    start /d %SystemRoot% notepad %LOG_FILE%
    echo.
    pause
)
echo.
goto:eof

:add-to-classpath
set foo="%~1"
echo JAR=%foo% 1>>%LOG_FILE%
echo JAR=%foo%
if not exist %foo% echo. & pause & exit
set CLASSPATH=%CLASSPATH%;%foo%
goto:eof
