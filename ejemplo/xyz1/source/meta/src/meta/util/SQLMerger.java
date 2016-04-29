/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.util;

import adalid.commons.enums.LoggingLevel;
import adalid.commons.util.FilUtils;
import adalid.util.Utility;
import adalid.util.sql.SqlMerger;
import meta.proyecto.comun.ConfiguracionBasica;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Jorge Campins
 */
public class SQLMerger extends Utility {

    private static final Logger logger = Logger.getLogger(SqlMerger.class);

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

//  must specify program arguments or add one the following lines to the bootstrapping properties file
//  meta.util.SQLMerger.args=oracle, localhost, 1521, XYZ1AP111, oracle, XE, xyz1ap111, former
//  meta.util.SQLMerger.args=postgresql, localhost, 5432, postgres, postgres, xyz1ap101, public, former
    public static void main(String[] args) {
//      setBootstrappingFileName("bootstrapping.properties");
        if (args.length == 0) {
            args = getArguments(SQLMerger.class);
        }
        SqlMerger merger = new SqlMerger(args);
        if (merger.isInitialised()) {
//          Use method setOldDataFolder to specify the absolute path of the folder used by COPY commands.
//          By default or by specifying a null value, the folder will be a subfolder of the test folder.
//          PostgreSQL user must be authorized to read and write files in the specified folder.
            String folder = defaultOldDataFolder(merger);
            merger.setOldDataFolder(folder);
            logger.info("oldDataFolder=" + merger.getOldDataFolder());
            ConfiguracionBasica.setAlertLoggingLevel(LoggingLevel.OFF);
            ConfiguracionBasica configuracionBasica = new ConfiguracionBasica();
            if (configuracionBasica.build()) {
                merger.setTablesLoadMap(configuracionBasica.getTablesMap());
                merger.merge();
            }
        }
    }

    private static String defaultOldDataFolder(SqlMerger merger) {
        String dbms = merger.getDbms();
        String database = merger.getDatabase();
        String newSchema = merger.getNewSchema();
        String oldSchema = merger.getOldSchema();
        boolean xe = StringUtils.equalsIgnoreCase(dbms, "oracle") && StringUtils.equalsIgnoreCase(database, "XE");
        String folder = FilUtils.getWorkspaceFolderPath();
        folder += FILE_SEPARATOR + (xe ? newSchema : database);
        folder += FILE_SEPARATOR + "source";
        folder += FILE_SEPARATOR + "management";
        folder += FILE_SEPARATOR + "backup";
        folder += FILE_SEPARATOR + dbms;
        folder += FILE_SEPARATOR + oldSchema;
        return folder;
    }

}
