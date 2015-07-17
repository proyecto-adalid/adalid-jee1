/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.util;

import adalid.commons.enums.LoggingLevel;
import adalid.commons.properties.PropertiesGetter;
import adalid.commons.util.FilUtils;
import adalid.util.sql.SqlMerger;
import meta.proyecto.comun.ConfiguracionBasica;
import org.apache.commons.collections.ExtendedProperties;
import org.apache.log4j.Logger;

/**
 * @author Jorge Campins
 */
public class SQLMerger {

    private static final Logger logger = Logger.getLogger(SqlMerger.class);

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

//  add the following line to private.properties file in meta\nbproject\private folder
//  meta.util.SQLMerger.args=postgresql, localhost, 5432, postgres, postgres, xyz1ap101, public, former
    public static void main(String[] args) {
        if (args.length == 0) {
            ExtendedProperties properties = PropertiesGetter.getPrivateProperties();
            args = properties.getStringArray(SQLMerger.class.getName() + ".args");
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
        String folder = FilUtils.getWorkspaceFolderPath();
        folder += FILE_SEPARATOR + merger.getDatabase();
        folder += FILE_SEPARATOR + "source";
        folder += FILE_SEPARATOR + "management";
        folder += FILE_SEPARATOR + "backup";
        folder += FILE_SEPARATOR + merger.getDbms();
        folder += FILE_SEPARATOR + merger.getOldSchema();
        return folder;
    }

}
