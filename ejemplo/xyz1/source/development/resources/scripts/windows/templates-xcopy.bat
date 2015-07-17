@echo off
@echo %~dpn0
@echo.
cd /d "%~dp0"
setlocal
call variables
set folder1=%adalid_dir%\source\development\resources\velocity\templates
set folder1
set folder2=%project_source_dir%\meta\resources\velocity\templates
set folder2
call:make-subdir "%folder2%"
echo.
set archivo=
set /p archivo="nombre de la plantilla que desea copiar (con o sin comodines): "
if /i "%archivo%" == "" goto:eof
robocopy %folder1% %folder2% %archivo% /ndl /nfl /s
echo.
pause
echo.
goto:eof

:make-subdir
echo.
set subdir="%~f1"
if exist %subdir% (echo OK "%~f1")
if not exist %subdir% (echo md %subdir% & md %subdir%)
goto:eof
