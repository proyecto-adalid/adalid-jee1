rem variables HOME
rem --------------------------------------------------------------------------------
rem la ultima instruccion "set" de cada variable determina su valor
rem elimine las lineas que no correspondan a su ambiente de trabajo
rem --------------------------------------------------------------------------------
set GLASSFISH_HOME=%ProgramFiles%\glassfish-4.0\glassfish
set GLASSFISH_HOME=%ProgramFiles%\glassfish-4.1\glassfish
set GLASSFISH_HOME=%ProgramFiles%\glassfish-4.1.1\glassfish
set JBOSS_HOME=%SystemDrive%\jboss-as-7.1.1.Final
set JBOSS_HOME=%SystemDrive%\wildfly-9.0.0.Final
set JBOSS_HOME=%SystemDrive%\wildfly-10.0.0.Final
set JBOSS_MAJOR_VERSION_NUMBER=7
set JBOSS_MAJOR_VERSION_NUMBER=9
set JBOSS_MAJOR_VERSION_NUMBER=10
set ORACLE_HOME=%SystemDrive%\oraclexe\app\oracle\product\11.2.0\server
set POSTGRESQL_HOME=%ProgramFiles%\PostgreSQL\9.2
set POSTGRESQL_HOME=%ProgramFiles%\PostgreSQL\9.3
set POSTGRESQL_HOME=%ProgramFiles%\PostgreSQL\9.5
rem --------------------------------------------------------------------------------
set POSTGRESQL_DRIVER_VERSION=postgresql-9.2-1002.jdbc4
rem se debe utilizar el driver 9.2-1002 con PostgreSQL 9.2 en adelante
rem ya que en algunos casos los demas drivers producen un java.sql.SQLException
rem --------------------------------------------------------------------------------
