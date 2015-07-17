@echo off
@echo %~dpn0
@echo.
cd /d "%~dp0"
setlocal
call variables
if not defined robocopy-log set robocopy-log="%~dpn0.robocopy.log"
if exist %robocopy-log% if %robocopy-log% == "%~dpn0.robocopy.log" del %robocopy-log%
echo %~f0>>%robocopy-log%
set root=%workspace%\%project%
set home=%project_source_dir%\management
call:make-subdirs
echo.
pause
echo.
goto:eof

:make-subdirs
call:make-subdir "%home%"
pushd "%home%"
call:make-postgresql-subdirs
call:make-jasper-subdirs
popd
echo.
goto:eof

:make-postgresql-subdirs
call:make-subdir resources\database\postgresql\custom-made
call:make-subdir resources\database\postgresql\data\custom-made
call:make-subdir resources\database\postgresql\data-generation\custom-made
call:make-subdir resources\database\postgresql\data-migration\custom-made
call:make-subdir resources\database\postgresql\functions\custom-made
call:make-subdir resources\database\postgresql\sequences\custom-made
call:make-subdir resources\database\postgresql\tables\custom-made
call:make-subdir resources\database\postgresql\triggers\custom-made
call:make-subdir resources\database\postgresql\util\custom-made
call:make-subdir resources\database\postgresql\views\custom-made
call:make-subdir resources\database\postgresql\views\zymurgy\custom-made
call:make-subdir resources\database\postgresql\wrap-up\custom-made
goto:eof

:make-jasper-subdirs
call:make-subdir resources\reporting\jasper\reports\custom-made
goto:eof

:make-subdir
set subdir="%~f1"
if exist %subdir% (echo OK "%~f1")
if not exist %subdir% (echo md %subdir% & md %subdir%)
goto:eof
