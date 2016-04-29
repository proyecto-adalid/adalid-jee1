@echo off
cd /d "%~dp0"
call variables
call variables-home
echo.
call:check-directories
pause
cls
echo.
call:check-compile-libraries
pause
cls
echo.
call:check-runtime-libraries
pause
cls
echo.
call:check-ide-modules
echo.
call:check-dos-tools
pause
echo.
goto:eof

:check-directories
if defined ENGLISH_LANGUAGE (
    echo checking directories
) else (
    echo comprobando directorios
)
echo.
rem  check-dir %workspace%
call:check-dir %adalid_dir%
call:check-dir %third_party_dir%
call:check-glassfish-directories
call:check-jboss-directories
call:check-oracle-directories
call:check-postgresql-directories
goto:eof

:check-glassfish-directories
set ok=
if defined GLASSFISH_HOME (
    set ok=true
    call:check-dir %GLASSFISH_HOME%
) else (
    if defined ENGLISH_LANGUAGE (
        echo variable GLASSFISH_HOME not defined ^(not required if GlassFish is not used^)
    ) else (
        echo variable GLASSFISH_HOME no definida ^(no es necesaria si no se utiliza GlassFish^)
    )
    echo.
)
set GLASSFISH_HOME_OK=%ok%
goto:eof

:check-jboss-directories
set ok=
if defined JBOSS_HOME (
    set ok=true
    call:check-dir %JBOSS_HOME%
) else (
    if defined ENGLISH_LANGUAGE (
        echo variable JBOSS_HOME not defined ^(not required if neither JBoss AS nor WildFly are used^)
    ) else (
        echo variable JBOSS_HOME no definida ^(no es necesaria si no se utiliza JBoss AS ni WildFly^)
    )
    echo.
)
set JBOSS_HOME_OK=%ok%
goto:eof

:check-oracle-directories
set ok=
if defined ORACLE_HOME (
    set ok=true
    call:check-dir %ORACLE_HOME%
) else (
    if defined ENGLISH_LANGUAGE (
        echo variable ORACLE_HOME not defined ^(not required if Oracle is not used^)
    ) else (
        echo variable ORACLE_HOME no definida ^(no es necesaria si no se utiliza Oracle^)
    )
    echo.
)
set ORACLE_HOME_OK=%ok%
goto:eof

:check-postgresql-directories
set ok=
if defined POSTGRESQL_HOME (
    set ok=true
    call:check-dir %POSTGRESQL_HOME%
) else (
    if defined ENGLISH_LANGUAGE (
        echo variable POSTGRESQL_HOME not defined ^(not required if PostgreSQL is not used^)
    ) else (
        echo variable POSTGRESQL_HOME no definida ^(no es necesaria si no se utiliza PostgreSQL^)
    )
    echo.
)
set POSTGRESQL_HOME_OK=%ok%
goto:eof

:check-compile-libraries
if defined ENGLISH_LANGUAGE (
    echo checking compile libraries
) else (
    echo comprobando librerias de compilacion
)
echo.
call:check-adalid-compile-lib-1
call:check-adalid-compile-meta-lib-1
if defined GLASSFISH_HOME (
    call:check-glassfish-core-modules
    call:check-glassfish-eclipselink
)
if defined JBOSS_HOME (
    if /i "%JBOSS_MAJOR_VERSION_NUMBER%" == "7" (
        call:check-jboss-core-modules
        call:check-jboss-eclipselink
    ) else (
        if /i "%JBOSS_MAJOR_VERSION_NUMBER%" == "10" (
            call:check-wildfly-core-modules-10
            call:check-wildfly-eclipselink
        ) else (
            call:check-wildfly-core-modules
            call:check-wildfly-eclipselink
        )
    )
)
call:check-jsf12-support
call:check-woodstock-components
goto:eof

:check-adalid-compile-lib-1
call:echoCheckingCompileLibrary adalid-compile-lib-1
set ok=true
call:check-jar-file "%third_party_dir%\lib\commons-collections-3.2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-io-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-lang-2.6.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\log4j-1.2.16.jar"
call:check-jar-file "%third_party_dir%\lib\velocity-1.7.jar"
echo.
goto:eof

:check-adalid-compile-meta-lib-1
call:echoCheckingCompileLibrary adalid-compile-meta-lib-1
set ok=true
call:check-jar-file "%adalid_dir%\lib\adalid-jaas.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-jee1.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-core.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-commons.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-util.jar"
echo.
goto:eof

:check-glassfish-core-modules
call:echoCheckingCompileLibrary glassfish-core-modules
set ok=true
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.el.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.faces.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.jms-api.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.servlet-api.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.servlet.jsp.jar"
echo.
goto:eof

:check-glassfish-eclipselink
call:echoCheckingCompileLibrary glassfish-eclipselink
set ok=true
call:check-jar-file "%GLASSFISH_HOME%\modules\org.eclipse.persistence.core.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\org.eclipse.persistence.jpa.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\org.eclipse.persistence.jpa.jpql.jar"
call:check-jar-file "%GLASSFISH_HOME%\modules\javax.persistence.jar"
echo.
goto:eof

:check-jboss-core-modules
call:echoCheckingCompileLibrary jboss-core-modules
set ok=true
call:check-jar-file "%JBOSS_HOME%\modules\javax\el\api\main\jboss-el-api_2.2_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\javax\faces\api\main\jboss-jsf-api_2.1_spec-2.0.1.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\javax\jms\api\main\jboss-jms-api_1.1_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\javax\servlet\api\main\jboss-servlet-api_3.0_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\javax\servlet\jsp\api\main\jboss-jsp-api_2.2_spec-1.0.0.Final.jar"
echo.
goto:eof

:check-jboss-eclipselink
call:echoCheckingCompileLibrary jboss-eclipselink
set ok=true
call:check-jar-file "%third_party_dir%\lib\eclipselink-2.4.0.jar"
echo.
goto:eof

:check-wildfly-core-modules
call:echoCheckingCompileLibrary wildfly-core-modules
set ok=true
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\el\api\main\jboss-el-api_3.0_spec-1.0.4.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\faces\api\main\jboss-jsf-api_2.2_spec-2.2.11.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\jms\api\main\jboss-jms-api_2.0_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\servlet\api\main\jboss-servlet-api_3.1_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\servlet\jsp\api\main\jboss-jsp-api_2.3_spec-1.0.1.Final.jar"
echo.
goto:eof

:check-wildfly-core-modules-10
call:echoCheckingCompileLibrary wildfly-core-modules
set ok=true
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\el\api\main\jboss-el-api_3.0_spec-1.0.5.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\faces\api\main\jboss-jsf-api_2.2_spec-2.2.12.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\jms\api\main\jboss-jms-api_2.0_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\servlet\api\main\jboss-servlet-api_3.1_spec-1.0.0.Final.jar"
call:check-jar-file "%JBOSS_HOME%\modules\system\layers\base\javax\servlet\jsp\api\main\jboss-jsp-api_2.3_spec-1.0.1.Final.jar"
echo.
goto:eof

:check-wildfly-eclipselink
call:echoCheckingCompileLibrary wildfly-eclipselink
set ok=true
call:check-jar-file "%third_party_dir%\lib\eclipselink-2.4.0.jar"
echo.
goto:eof

:check-jsf12-support
call:echoCheckingCompileLibrary jsf12-support
set ok=true
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsfcl.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\appbase.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\dataprovider.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\sqlx.jar"
echo.
goto:eof

:check-woodstock-components
call:echoCheckingCompileLibrary woodstock-components
set ok=true
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\webui-jsf.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\json-2.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-common-0.1.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-dynamic-faces-0.1.jar"
echo.
goto:eof

:check-runtime-libraries
if defined ENGLISH_LANGUAGE (
    echo checking runtime libraries
) else (
    echo comprobando librerias de ejecucion
)
echo.
set ok=true
call:echoCheckingJarFiles commons, jasperreports, joda-time, log4j, velocity, ...
call:check-jar-file "%third_party_dir%\lib\commons-beanutils-1.8.2.jar"
call:check-jar-file "%third_party_dir%\lib\commons-collections-3.2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-digester-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-fileupload-1.2.2.jar"
call:check-jar-file "%third_party_dir%\lib\commons-io-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-javaflow-20060411.jar"
call:check-jar-file "%third_party_dir%\lib\commons-lang-2.6.jar"
call:check-jar-file "%third_party_dir%\lib\commons-logging-1.1.3.jar"
call:check-jar-file "%third_party_dir%\lib\iText-2.1.7.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-fonts-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-functions-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-javaflow-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\jcommon-1.0.15.jar"
call:check-jar-file "%third_party_dir%\lib\jdt-compiler-3.1.1.jar"
call:check-jar-file "%third_party_dir%\lib\jfreechart-1.0.12.jar"
call:check-jar-file "%third_party_dir%\lib\joda-time-1.6.2.jar"
call:check-jar-file "%third_party_dir%\lib\jxl-2.6.10.jar"
call:check-jar-file "%third_party_dir%\lib\log4j-1.2.16.jar"
call:check-jar-file "%third_party_dir%\lib\spring.jar"
call:check-jar-file "%third_party_dir%\lib\velocity-1.7.jar"
echo.
set ok=true
call:echoCheckingJarFiles jdbc
call:check-jar-file "%third_party_dir%\lib\jdbc\oracle\ojdbc6.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\postgresql\postgresql-9.2-1002.jdbc4.jar"
goto:check-sqlserver-driver
call:check-jar-file "%third_party_dir%\lib\jdbc\postgresql\postgresql-9.3-1102.jdbc4.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\postgresql\postgresql-9.4.1208.jar"
:check-sqlserver-driver
call:check-jar-file "%third_party_dir%\lib\jdbc\sqlserver\sqljdbc4.jar"
echo.
set ok=true
call:echoCheckingJarFiles visualweb2
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\appbase.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\dataprovider.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\errorhandler.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-common-0.1.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-dynamic-faces-0.1.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsfcl.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\json-2.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\shale-remoting-1.0.4.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\sqlx.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\webui-jsf.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\webui-jsf-suntheme.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\locale\webui-jsf_es.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\locale\webui-jsf-suntheme_es.jar"
echo.
set ok=true
call:echoCheckingJarFiles fonts
call:check-jar-file "%third_party_dir%\lib\fonts\microsoft\microsoft-core-fonts-for-the-web.jar"
echo.
goto:eof

:check-ide-modules
if defined ENGLISH_LANGUAGE (
    echo checking NetBeans modules
) else (
    echo comprobando modulos NetBeans
)
echo.
call:check-file "%adalid_dir%\lib\adalid-code-templates.nbm"
goto:eof

:check-dos-tools
if defined ENGLISH_LANGUAGE (
    echo checking DOS tools
) else (
    echo comprobando utilitarios DOS
)
echo.
call:check-Replacer-tool
call:check-XXMkLink-tool
call:check-Junction-tool
goto:eof

:check-Replacer-tool
if defined ENGLISH_LANGUAGE (
    echo checking SourceForge FART tool executable file
) else (
    echo comprobando archivo ejecutable del utilitario FART de SourceForge
)
set exe="%third_party_dir%\tools\fart\fart.exe"
if exist %exe% (
    call:echoFilePresent %exe%
) else (
    echo.
    call:echoFileMissing %exe%
    echo.
    if defined ENGLISH_LANGUAGE (
        echo Download this SourceForge freeware tool from http://sourceforge.net/projects/fart-it
        echo Then copy the "fart.exe" file to "%third_party_dir%\tools\fart"
    ) else (
        echo Descargue este freeware de SourceForge desde http://sourceforge.net/projects/fart-it
        echo Luego copie el archivo "fart.exe" a "%third_party_dir%\tools\fart"
    )
    echo.
)
echo.
goto:eof

:check-XXMkLink-tool
if defined ENGLISH_LANGUAGE (
    echo checking Pixelab XXMkLink tool executable file
) else (
    echo comprobando archivo ejecutable del utilitario XXMkLink de Pixelab
)
set exe="%third_party_dir%\tools\xxmklink\xxmklink.exe"
if exist %exe% (
    call:echoFilePresent %exe%
) else (
    echo.
    call:echoFileMissing %exe%
    echo.
    if defined ENGLISH_LANGUAGE (
        echo Download this Pixelab freeware tool from http://www.xxcopy.com/download/xxmklink.zip
        echo Then copy the "XXMKLINK.EXE" file to "%third_party_dir%\tools\xxmklink"
    ) else (
        echo Descargue este freeware de Pixelab desde http://www.xxcopy.com/download/xxmklink.zip
        echo Luego copie el archivo "XXMKLINK.EXE" a "%third_party_dir%\tools\xxmklink"
    )
    echo.
)
echo.
goto:eof

:check-Junction-tool
if defined ENGLISH_LANGUAGE (
    echo checking Sysinternals Junction tool executable file
) else (
    echo comprobando archivo ejecutable del utilitario Junction de Sysinternals
)
set exe="%third_party_dir%\tools\junction\junction.exe"
if exist %exe% (
    call:echoFilePresent %exe%
) else (
    echo.
    call:echoFileMissing %exe%
    echo.
    if defined ENGLISH_LANGUAGE (
        echo Download this Sysinternals freeware tool from http://technet.microsoft.com/en-us/sysinternals/bb896768.aspx
        echo Then copy the "junction.exe" file to "%third_party_dir%\tools\junction"
    ) else (
        echo Descargue este freeware de Sysinternals desde http://technet.microsoft.com/en-us/sysinternals/bb896768.aspx
        echo Luego copie el archivo "junction.exe" a "%third_party_dir%\tools\junction"
    )
    echo.
)
echo.
goto:eof

:check-jar-file
set f1="%~f1"
if exist %f1% (
    call:echoFilePresent %f1%
) else (
    set ok=
    call:echoFileMissing %f1%
)
goto:eof

:check-module-jar-file
set f1="%~f1"
if exist %f1% (
    call:echoFilePresent %f1%
) else (
    set ok=
    call:echoModuleJarFileMissing %f1%
)
goto:eof

:check-file
set f1="%~f1"
if defined ENGLISH_LANGUAGE (
    echo checking file %f1%
) else (
    echo comprobando archivo %f1%
)
if exist %f1% (
    call:echoFilePresent %f1%
) else (
    set ok=
    call:echoFileMissing %f1%
)
echo.
goto:eof

:check-dir
call:check-directory "%*\"
goto:eof

:check-directory
set f1="%~f1"
if defined ENGLISH_LANGUAGE (
    echo checking directory %f1%
) else (
    echo comprobando directorio %f1%
)
if exist %f1% (
    if defined ENGLISH_LANGUAGE (
        echo directory %f1% is OK
    ) else (
        echo directorio %f1% comprobado
    )
) else (
    set ok=
    echo.
    if defined ENGLISH_LANGUAGE (
        echo ERROR: directory %f1% NOT FOUND!
    ) else (
        echo ERROR: directorio %f1% NO EXISTE!
    )
)
echo.
goto:eof

:echoCheckingCompileLibrary
if defined ENGLISH_LANGUAGE (
    echo checking compile library "%1"
) else (
    echo comprobando libreria de compilacion "%1"
)
goto:eof

:echoCheckingJarFiles
if defined ENGLISH_LANGUAGE (
    echo checking %* jar files
) else (
    echo comprobando archivos jar de %*
)
goto:eof

:echoFilePresent
if defined ENGLISH_LANGUAGE (
    echo file "%~f1" is OK
) else (
    echo archivo "%~f1" comprobado
)
goto:eof

:echoFileMissing
if defined ENGLISH_LANGUAGE (
    echo ERROR: file "%~f1" NOT FOUND!
) else (
    echo ERROR: archivo "%~f1" NO EXISTE!
)
goto:eof

:echoModuleJarFileMissing
if defined ENGLISH_LANGUAGE (
    echo WARNING: file "%~f1" NOT FOUND! It will be copied when add-modules is executed.
) else (
    echo ADVERTENCIA: archivo "%~f1" NO EXISTE! Sera copiado al ejecutar add-modules.
)
goto:eof
