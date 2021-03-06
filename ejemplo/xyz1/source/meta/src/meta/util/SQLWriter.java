/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.util;

import adalid.commons.enums.LoggingLevel;
import adalid.util.Utility;
import adalid.util.sql.SqlWriter;
import meta.entidad.comun.control.acceso.Usuario;
import meta.proyecto.comun.EntidadesComunes;
import org.apache.log4j.Logger;

/**
 * @author Jorge Campins
 */
public class SQLWriter extends Utility {

    private static final Logger logger = Logger.getLogger(SqlWriter.class);

    // <editor-fold defaultstate="collapsed" desc="listas de tablas">
    private static final String[] TABLAS_EXCLUIDAS = new String[]{
        "aplicacion",
        "clase_recurso",
        "clase_recurso_par",
        "clase_recurso_parametro",
        "clase_recurso_sec",
        "clase_recurso_seccion",
        "condicion_eje_fun",
        "condicion_ejecucion_funcion",
        "conjunto_segmento",
        "dominio",
        "dominio_paquete",
        "dominio_parametro",
        "dual",
        "elemento_segmento",
        "filtro_cla_rec_fun",
        "filtro_cla_rec_par",
        "filtro_cla_rec_sec",
        "filtro_cla_rec_vin",
        "filtro_clase_recurso_funcion",
        "filtro_clase_recurso_parametro",
        "filtro_clase_recurso_seccion",
        "filtro_clase_recurso_vinculo",
        "filtro_funcion",
        "filtro_funcion_par",
        "filtro_funcion_parametro",
        "funcion",
        "funcion_parametro",
        "grupo_aplicacion",
        "grupo_proceso",
        "mensaje",
        "nivel_opcion_menu",
        "opcion_binaria",
        "opcion_menu",
        "opcion_menu_plus",
        "opcion_sistema",
        "operador_com",
        "operador_comparacion",
        "pagina",
        "pagina_funcion",
        "pagina_usuario",
        "paquete",
        "parametro",
        "rastro_funcion",
        "rastro_funcion_par",
        "rastro_funcion_parametro",
        "rastro_informe",
        "rastro_proceso",
        "recurso",
        "rol",
        "rol_aplicacion",
        "rol_filtro_funcion",
        "rol_funcion",
        "rol_pagina",
        "rol_usuario",
        "tipo_clase_recurso",
        "tipo_comparacion",
        "tipo_dato_par",
        "tipo_dato_parametro",
        "tipo_dominio",
        "tipo_funcion",
        "tipo_nodo",
        "tipo_pagina",
        "tipo_parametro",
        "tipo_parametro_dom",
        "tipo_parametro_dominio",
        "tipo_rastro_fun",
        "tipo_rastro_funcion",
        "tipo_recurso",
        "tipo_rol",
        "tipo_valor"
    };
    // </editor-fold>

    public static void main(String[] args) {
        /*
         * Use method setBootstrappingFileName to specify the name of the bootstrapping properties file.
         * By default or by specifying a null value, the name will be bootstrapping.properties.
         */
        // setBootstrappingFileName("bootstrapping.properties");
        /*
         * SqlWriter constructor requires the following arguments: dbms, host, port, user, password, database and schema.
         * Use the IDE to specify program arguments or add a property to the bootstrapping properties file. In the later case,
         * the property name must be meta.util.SQLWriter.args and its value must be the arguments, as a comma-separated list.
         * For example:
         * meta.util.SQLWriter.args=postgresql, localhost, 5432, postgres, postgres, xyz1ap101, public
         * meta.util.SQLWriter.args=oracle, localhost, 1521, XYZ1AP111, oracle, XE, xyz1ap111
         */
        if (args.length == 0) {
            /*
             * method getArguments looks for property meta.util.SQLMerger.args in the bootstrapping properties file.
             */
            args = getArguments(SQLWriter.class);
        }
        SqlWriter writer = new SqlWriter(args);
        if (writer.isInitialised()) {
            /*
             * Use method setProjectAlias to specify the project alias used to define the target meta-java package.
             * By default or by specifying a null value, the alias will be either the Oracle schema or the PostgreSQL database name.
             */
            // writer.setProjectAlias("xyz1ap101");
            logger.info("projectAlias=" + writer.getProjectAlias());
            EntidadesComunes.setAlertLoggingLevel(LoggingLevel.OFF);
            EntidadesComunes entidadesComunes = new EntidadesComunes();
            entidadesComunes.setUserEntityClass(Usuario.class);
            if (entidadesComunes.build()) {
                writer.setTablesExcludeSet(TABLAS_EXCLUIDAS);
                writer.setTablesInheritMap(entidadesComunes.getTablesMap());
                writer.setLoadConfigurationTables(false);
                writer.write();
            }
        }
    }

}
