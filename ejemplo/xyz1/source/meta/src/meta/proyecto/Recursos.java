/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.proyecto;

import adalid.commons.enums.LoggingLevel;
import adalid.core.annotations.ProjectModule;
import adalid.core.enums.Kleenean;
import java.util.Locale;
import meta.proyecto.base.ProyectoBase;
import meta.proyecto.comun.Auditoria;
import meta.proyecto.comun.ControlAcceso;
import meta.proyecto.comun.ControlPruebas;

/**
 * @author Jorge Campins
 */
public class Recursos extends ProyectoBase {

    public static void main(String[] args) {
//      Maestro.setLocale(Locale.ENGLISH);
        Recursos.setLocale(Locale.forLanguageTag("es"));
        Recursos.setAlertLoggingLevel(LoggingLevel.OFF);
//      Maestro.setDetailLoggingLevel(LoggingLevel.INFO);
//      Maestro.setTrackingLoggingLevel(LoggingLevel.INFO);
        Recursos maestro = new Recursos();
        if (maestro.build()) {
            maestro.setAlias("xyz1ap101");
            maestro.putEnvironmentVariable(VERSION_JAVA, "1.8.0_25");
            maestro.putEnvironmentVariable(VERSION_GLASSFISH, "4.1");
            maestro.putEnvironmentVariable(VERSION_POSTGRESQL, "9.3");
//          maestro.setSecurityRealmType(SecurityRealmType.LDAP);
//          maestro.setRoleBasedAccessControllerName("LDAP");
            maestro.generate("resources");
        }
    }

    @Override
    protected void settleAttributes() {
        super.settleAttributes();
        setDefaultLabel("Gestión de Recursos Empresariales");
        setDefaultDescription("Gestión de Recursos Empresariales");
    }

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ModuloClientes mod1;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ModuloPedidos mod2;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ModuloDocumentos mod3;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ControlAcceso modx;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    Auditoria mody;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ControlPruebas modz;

}
