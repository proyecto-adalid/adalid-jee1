@echo off
cd /d "%~dp0"
call:eraseFiles log4j.appender.rolling.log.*
call:eraseFiles *.log

if "%1" == "" (pause) else (echo.)
goto:eof

:eraseFiles
    set target=%1
    set siono=N
    set /a archivos=0
    echo buscando archivos %target% en %CD% ...
    for /R %CD% %%f in (%target%) do (
        rem echo %%f
        set siono=S
        set /a archivos+=1
    )
    if %archivos% EQU 0 (
        echo no hay archivos %target% en %CD%
    ) else (
        echo hay %archivos% archivos %target% en %CD%
        call:runEraseFiles
    )
    echo.
    goto:eof

:runEraseFiles
    echo.
    set /p siono="ELIMINAR LOS ARCHIVOS %target%? (S/N) [%siono%] "
    echo.
    if /i "%siono%" == "S" for /R %CD% %%f in (%target%) do (
        echo del %%f
        del %%f
    )
    goto:eof

:eraseFolders
    set target="%~f1"
    if exist %target% (
        call:askEraseFolders
    ) else (
        echo %target% no existe
    )
    echo.
    goto:eof

:askEraseFolders
    set siono=N
    for /D %%d in (%target%\*.*) do (
        echo %%d
        set siono=S
    )
    if /i "%siono%" == "S" (
        call:runEraseFolders
    ) else (
        echo %target% no tiene directorios
    )
    goto:eof

:runEraseFolders
    echo.
    set siono=N
    set /p siono="ELIMINAR LOS DIRECTORIOS DE %target%? (S/N) [%siono%] "
    echo.
    if /i "%siono%" == "S" for /D %%d in (%target%\*.*) do (
        echo rmdir "%%d"
        rmdir "%%d" /s /q
    )
    if /i "%siono%" == "S" (
        dir %target% /a:d /b
    )
    goto:eof
