/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.entidad.comun.operacion.basica;

import adalid.commons.util.KVP;
import adalid.core.annotations.AddAttributesMethod;
import static meta.postgresql.PostgreSQLAttributes.FILLFACTOR;
import static meta.postgresql.PostgreSQLAttributes.WITH;

/**
 * @author Jorge Campins
 */
public class PostgreSQLAttributes {

    @AddAttributesMethod
    public static void addAttributes(TareaUsuario entity) {
//      String tablespace = getTablespace();
        entity.addAttribute(WITH, KVP.join(FILLFACTOR, 70));
//      entity.addAttribute(TABLESPACE, tablespace);
        entity.destinatario.addAttribute(WITH, KVP.join(FILLFACTOR, 100));
//      entity.destinatario.addAttribute(TABLESPACE, tablespace);
        entity.funcion.addAttribute(WITH, KVP.join(FILLFACTOR, 100));
//      entity.funcion.addAttribute(TABLESPACE, tablespace);
        entity.key1.addAttribute(WITH, KVP.join(FILLFACTOR, 90));
//      entity.key1.addAttribute(TABLESPACE, tablespace);
        entity.key2.addAttribute(WITH, KVP.join(FILLFACTOR, 80));
//      entity.key2.addAttribute(TABLESPACE, tablespace);
    }

}
