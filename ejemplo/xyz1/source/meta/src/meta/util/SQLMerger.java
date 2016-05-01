/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.util;

import adalid.commons.enums.LoggingLevel;
import adalid.util.Utility;
import adalid.util.sql.SqlMerger;
import meta.proyecto.comun.ConfiguracionBasica;
import org.apache.log4j.Logger;

/**
 * @author Jorge Campins
 */
public class SQLMerger extends Utility {

    private static final Logger logger = Logger.getLogger(SqlMerger.class);

    public static void main(String[] args) {
        /*
         * Use method setBootstrappingFileName to specify the name of the bootstrapping properties file.
         * By default or by specifying a null value, the name will be bootstrapping.properties.
         */
        // setBootstrappingFileName("bootstrapping.properties");
        /*
         * SqlMerger constructor requires the following arguments: dbms, host, port, user, password, database, schema and oldSchema.
         * Use the IDE to specify program arguments or add a property to the bootstrapping properties file. In the later case,
         * the property name must be meta.util.SQLMerger.args and its value must be the arguments, as a comma-separated list.
         * For example:
         * meta.util.SQLMerger.args=postgresql, localhost, 5432, postgres, postgres, xyz1ap101, public, former
         * meta.util.SQLMerger.args=oracle, localhost, 1521, XYZ1AP111, oracle, XE, xyz1ap111, former
         */
        if (args.length == 0) {
            /*
             * method getArguments looks for property meta.util.SQLMerger.args in the bootstrapping properties file.
             */
            args = getArguments(SQLMerger.class);
        }
        SqlMerger merger = new SqlMerger(args);
        if (merger.isInitialised()) {
            /*
             * Use method setProjectAlias to specify the project alias used to define the folder where generated scripts will be written to.
             * The project alias is also used to define the default folder used by COPY commands (see the comments on method setOldDataFolder).
             * By default or by specifying a null value, the alias will be either the Oracle schema or the PostgreSQL database name.
             */
            // merger.setProjectAlias("xyz1ap101");
            logger.info("projectAlias=" + merger.getProjectAlias());
            /*
             * Use method setOldDataFolder to specify the absolute path of the folder used by COPY commands.
             * By default or by specifying a null value, the folder will be a subfolder of the workspace directory,
             * specifically /alias/source/management/backup/dbms/oldSchema, where alias is substituted by the project alias,
             * dbms and oldSchema are substituted by their corresponding arguments, and the rest is constant.
             * PostgreSQL user must be authorized to read and write files in the specified folder.
             */
            // merger.setOldDataFolder(folder);
            logger.info("oldDataFolder=" + merger.getOldDataFolder());
            ConfiguracionBasica.setAlertLoggingLevel(LoggingLevel.OFF);
            ConfiguracionBasica configuracionBasica = new ConfiguracionBasica();
            if (configuracionBasica.build()) {
                merger.setTablesLoadMap(configuracionBasica.getTablesMap());
                merger.merge();
            }
        }
    }

}
