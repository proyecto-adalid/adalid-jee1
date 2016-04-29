/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.postgresql;

import adalid.commons.util.KVP;
import adalid.core.Key;
import adalid.core.TLC;
import adalid.core.annotations.AddAttributesMethod;
import adalid.core.interfaces.PersistentEntity;

/**
 * @author Jorge Campins
 */
public class PostgreSQLAttributes {

    public static final String WITH = "WITH";

    public static final String FILLFACTOR = "fillfactor";

    public static final String AUTOVACUUM_ENABLED = "autovacuum_enabled";

    public static final String TABLESPACE = "TABLESPACE";

    @AddAttributesMethod(120)
    public static void addAttributes(PersistentEntity entity) {
        String tablespace = getTablespace();
        entity.addAttribute(WITH,
            KVP.join(FILLFACTOR, 80),
            KVP.join(AUTOVACUUM_ENABLED, true)
        );
        entity.addAttribute(TABLESPACE, tablespace);
        entity.addAttribute(entity.getPrimaryKeyProperty(), WITH, KVP.join(FILLFACTOR, 100));
//      entity.addAttribute(entity.getPrimaryKeyProperty(), TABLESPACE, tablespace);
        entity.addAttribute(entity.getVersionProperty(), WITH, KVP.join(FILLFACTOR, 100));
//      entity.addAttribute(entity.getVersionProperty(), TABLESPACE, tablespace);
        entity.addAttribute(entity.getBusinessKeyProperty(), WITH, KVP.join(FILLFACTOR, 90));
//      entity.addAttribute(entity.getBusinessKeyProperty(), TABLESPACE, tablespace);
        entity.addAttribute(entity.getNameProperty(), WITH, KVP.join(FILLFACTOR, 80));
//      entity.addAttribute(entity.getNameProperty(), TABLESPACE, tablespace);
    }

    @AddAttributesMethod
    public static void addAttributes(Key key) {
//      String tablespace = getTablespace();
        key.addAttribute(WITH, KVP.join(FILLFACTOR, 90));
//      key.addAttribute(TABLESPACE, tablespace);
    }

    public static String getTablespace() {
        return TLC.getProject().getAlias();
    }

}
