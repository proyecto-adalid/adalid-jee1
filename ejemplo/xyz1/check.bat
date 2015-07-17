@echo off
cd /d "%~dp0"
call variables
call:check-directories
pause
echo.
call:check-compile-libraries
pause
echo.
call:check-runtime-libraries
pause
echo.
call:check-ide-modules
pause
echo.
call:check-dos-tools
pause
echo.
goto:eof

:check-directories
echo checking directories
echo.
rem  check-dir %workspace%
call:check-dir %adalid_dir%
call:check-dir %third_party_dir%
goto:eof

:check-compile-libraries
echo checking compile libraries
echo.
call:check-adalid-compile-lib-1
call:check-adalid-compile-meta-lib-1
call:check-glassfish-core-modules
call:check-glassfish-eclipselink
call:check-jboss-core-modules
call:check-jboss-eclipselink
call:check-jsf12-support
call:check-woodstock-components
goto:eof

:check-adalid-compile-lib-1
echo checking compile library "adalid-compile-lib-1"
set ok=true
call:check-jar-file "%third_party_dir%\lib\commons-collections-3.2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-fileupload-1.2.2.jar"
call:check-jar-file "%third_party_dir%\lib\commons-io-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-lang-2.6.jar"
call:check-jar-file "%third_party_dir%\lib\jasperreports-5.5.1.jar"
call:check-jar-file "%third_party_dir%\lib\joda-time-1.6.2.jar"
call:check-jar-file "%third_party_dir%\lib\log4j-1.2.16.jar"
call:check-jar-file "%third_party_dir%\lib\velocity-1.7.jar"
if defined ok echo library "adalid-compile-lib-1" checks OK
echo.
goto:eof

:check-adalid-compile-meta-lib-1
echo checking compile library "adalid-compile-meta-lib-1"
set ok=true
call:check-jar-file "%adalid_dir%\lib\adalid-jee1.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-core.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-commons.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-util.jar"
call:check-jar-file "%adalid_dir%\lib\adalid-xmi.jar"
if defined ok echo library "adalid-compile-meta-lib-1" checks OK
echo.
goto:eof

:check-glassfish-core-modules
echo checking compile library "glassfish-core-modules"
set ok=true
call:check-jar-file "%third_party_dir%\lib\glassfish\core\modules\javax.el-api.jar"
call:check-jar-file "%third_party_dir%\lib\glassfish\core\modules\javax.faces.jar"
call:check-jar-file "%third_party_dir%\lib\glassfish\core\modules\javax.jms.jar"
call:check-jar-file "%third_party_dir%\lib\glassfish\core\modules\javax.servlet-api.jar"
call:check-jar-file "%third_party_dir%\lib\glassfish\core\modules\javax.servlet.jsp.jar"
if defined ok echo library "glassfish-core-modules" checks OK
echo.
goto:eof

:check-glassfish-eclipselink
echo checking compile library "glassfish-eclipselink"
set ok=true
call:check-jar-file "%third_party_dir%\lib\netbeans\java\modules\ext\eclipselink\2.3.2\eclipselink-2.3.2.jar"
call:check-jar-file "%third_party_dir%\lib\netbeans\java\modules\ext\eclipselink\2.3.2\javax.persistence-2.0.3.jar"
call:check-jar-file "%third_party_dir%\lib\netbeans\java\modules\ext\eclipselink\2.3.2\org.eclipse.persistence.jpa.jpql_1.0.1.jar"
if defined ok echo library "glassfish-eclipselink" checks OK
echo.
goto:eof

:check-jboss-core-modules
echo checking compile library "jboss-core-modules"
set ok=true
call:check-jar-file "%third_party_dir%\jboss\modules\javax\el\api\main\jboss-el-api_2.2_spec-1.0.0.Final.jar"
call:check-jar-file "%third_party_dir%\jboss\modules\javax\faces\api\main\jboss-jsf-api_2.1_spec-2.0.1.Final.jar"
call:check-jar-file "%third_party_dir%\jboss\modules\javax\jms\api\main\jboss-jms-api_1.1_spec-1.0.0.Final.jar"
call:check-jar-file "%third_party_dir%\jboss\modules\javax\servlet\api\main\jboss-servlet-api_3.0_spec-1.0.0.Final.jar"
call:check-jar-file "%third_party_dir%\jboss\modules\javax\servlet\jsp\api\main\jboss-jsp-api_2.2_spec-1.0.0.Final.jar"
if defined ok echo library "jboss-core-modules" checks OK
echo.
goto:eof

:check-jboss-eclipselink
echo checking compile library "jboss-eclipselink"
set ok=true
call:check-jar-file "%third_party_dir%\jboss\modules\org\eclipse\persistence\main\eclipselink-2.4.0.jar"
if defined ok echo library "jboss-eclipselink" checks OK
echo.
goto:eof

:check-jsf12-support
echo checking compile library "jsf12-support"
set ok=true
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsfcl.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\appbase.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\dataprovider.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\sqlx.jar"
if defined ok echo library "jsf12-support" checks OK
echo.
goto:eof

:check-woodstock-components
echo checking compile library "woodstock-components"
set ok=true
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\webui-jsf.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\json-2.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-common-0.1.jar"
call:check-jar-file "%third_party_dir%\lib\visualweb2\modules\ext\jsf-extensions-dynamic-faces-0.1.jar"
if defined ok echo library "woodstock-components" checks OK
echo.
goto:eof

:check-runtime-libraries
echo checking runtime libraries
echo.
set ok=true
echo checking commons, jasperreports, joda-time, log4j, velocity ^& xstream jar files
call:check-jar-file "%third_party_dir%\lib\commons-beanutils-1.8.2.jar"
call:check-jar-file "%third_party_dir%\lib\commons-collections-3.2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-digester-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-fileupload-1.2.2.jar"
call:check-jar-file "%third_party_dir%\lib\commons-io-2.1.jar"
call:check-jar-file "%third_party_dir%\lib\commons-javaflow-20060411.jar"
call:check-jar-file "%third_party_dir%\lib\commons-lang-2.6.jar"
call:check-jar-file "%third_party_dir%\lib\commons-logging-1.1.2.jar"
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
if defined ok echo commons, jasperreports, joda-time, log4j, velocity ^& xstream jar files check OK
echo.
set ok=true
echo checking jdbc drivers jar files
call:check-jar-file "%third_party_dir%\lib\jdbc\oracle\ojdbc6.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\postgresql\postgresql-9.2-1002.jdbc4.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\sqlserver\sqljdbc4.jar"
if defined ok echo jdbc drivers jar files check OK
echo.
set ok=true
echo checking visualweb2 jar files
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
if defined ok echo visualweb2 jar files check OK
echo.
set ok=true
echo checking fonts ^& drivers jar files
call:check-jar-file "%third_party_dir%\lib\fonts\microsoft\microsoft-core-fonts-for-the-web.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\oracle\ojdbc6.jar"
call:check-jar-file "%third_party_dir%\lib\jdbc\postgresql\postgresql-9.2-1002.jdbc4.jar"
if defined ok echo fonts ^& drivers jar files check OK
echo.
goto:eof

:check-ide-modules
echo checking IDE modules
echo.
call:check-file "%adalid_dir%\lib\adalid-code-templates.nbm"
goto:eof

:check-dos-tools
echo checking DOS tools
echo.
call:check-Replacer-tool
call:check-XXMkLink-tool
call:check-Junction-tool
goto:eof

:check-FileDate-tool
echo checking ABF FileDate tool executable file
set exe="%third_party_dir%\tools\abfTools\FileDate\FileDate.exe"
if exist %exe% (
    echo file %exe% checks OK
) else (
    echo.
    echo ERROR: file %exe% NOT FOUND!
    echo Download this ABF freeware tool from http://www.abf-dev.com/free-tools.shtml
    echo Then copy the "FileDate" directory to "%third_party_dir%\tools\abfTools"
)
echo.
goto:eof

:check-Replacer-tool
echo checking SourceForge FART tool executable file
set exe="%third_party_dir%\tools\fart\fart.exe"
if exist %exe% (
    echo file %exe% checks OK
) else (
    echo.
    echo ERROR: file %exe% NOT FOUND!
    echo Download this SourceForge freeware tool from http://sourceforge.net/projects/fart-it
    echo Then copy the "fart.exe" file to "%third_party_dir%\tools\fart"
)
echo.
goto:eof

:check-XXMkLink-tool
echo checking Pixelab XXMkLink tool executable file
set exe="%third_party_dir%\tools\xxmklink\xxmklink.exe"
if exist %exe% (
    echo file %exe% checks OK
) else (
    echo.
    echo ERROR: file %exe% NOT FOUND!
    echo Download this Pixelab freeware tool from http://www.xxcopy.com/download/xxmklink.zip
    echo Then copy the "XXMKLINK.EXE" file to "%third_party_dir%\tools\xxmklink"
)
echo.
goto:eof

:check-Junction-tool
echo checking Sysinternals Junction tool executable file
set exe="%third_party_dir%\tools\junction\junction.exe"
if exist %exe% (
    echo file %exe% checks OK
) else (
    echo.
    echo ERROR: file %exe% NOT FOUND!
    echo Download this Sysinternals freeware tool from http://technet.microsoft.com/en-us/sysinternals/bb896768.aspx
    echo Then copy the "junction.exe" file to "%third_party_dir%\tools\junction"
)
echo.
goto:eof

:check-jar-file
set f1="%~f1"
if not exist %f1% (
    set ok=
    echo.
    echo ERROR: file %f1% NOT FOUND!
)
goto:eof

:check-file
set f1="%~f1"
echo checking file %f1%
if exist %f1% (
    echo file %f1% checks OK
) else (
    set ok=
    echo.
    echo ERROR: file %f1% NOT FOUND!
)
echo.
goto:eof

:check-dir
call:check-directory "%*\"
goto:eof

:check-directory
set f1="%~f1"
echo checking directory %f1%
if exist %f1% (
    echo directory %f1% checks OK
) else (
    set ok=
    echo.
    echo ERROR: directory %f1% NOT FOUND!
)
echo.
goto:eof
