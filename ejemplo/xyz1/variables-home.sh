#!/bin/bash
# --------------------------------------------------------------------------------
# la ultima instruccion "set" de cada variable determina su valor
# elimine las lineas que no correspondan a su ambiente de trabajo
# --------------------------------------------------------------------------------
GLASSFISH_HOME=/opt/glassfish-4.0/glassfish
GLASSFISH_HOME=/opt/glassfish-4.1/glassfish
GLASSFISH_HOME=/opt/glassfish-4.1.1/glassfish
JBOSS_HOME=/opt/jboss-as-7.1.1.Final
JBOSS_HOME=/opt/wildfly-9.0.0.Final
JBOSS_HOME=/opt/wildfly-10.0.0.Final
JBOSS_MAJOR_VERSION_NUMBER=7
JBOSS_MAJOR_VERSION_NUMBER=9
JBOSS_MAJOR_VERSION_NUMBER=10
ORACLE_HOME=/opt/oraclexe/app/oracle/product/11.2.0/server
POSTGRESQL_HOME=/opt/PostgreSQL/9.2
POSTGRESQL_HOME=/opt/PostgreSQL/9.3
POSTGRESQL_HOME=/opt/PostgreSQL/9.5
# --------------------------------------------------------------------------------
POSTGRESQL_DRIVER_VERSION=postgresql-9.2-1002.jdbc4
# se debe utilizar el driver 9.2-1002 con PostgreSQL 9.2 en adelante
# ya que en algunos casos los demas drivers producen un java.sql.SQLException
# --------------------------------------------------------------------------------
