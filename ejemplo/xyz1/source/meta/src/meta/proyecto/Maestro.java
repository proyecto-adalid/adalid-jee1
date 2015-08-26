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
import meta.proyecto.comun.ControlProcesos;
import meta.proyecto.comun.ControlPruebas;
import meta.proyecto.comun.ControlTareas;

/**
 * @author Jorge Campins
 */
public class Maestro extends ProyectoBase {

    public static void main(String[] args) {
//      Maestro.setLocale(Locale.ENGLISH);
        Maestro.setLocale(Locale.forLanguageTag("es"));
        Maestro.setAlertLoggingLevel(LoggingLevel.OFF);
//      Maestro.setDetailLoggingLevel(LoggingLevel.INFO);
//      Maestro.setTrackingLoggingLevel(LoggingLevel.INFO);
        Maestro maestro = new Maestro();
        if (maestro.build()) {
            maestro.putEnvironmentVariable(VERSION_JAVA, "1.8.0_25");
            maestro.putEnvironmentVariable(VERSION_GLASSFISH, "4.1");
//          maestro.putEnvironmentVariable(VERSION_JBOSS, "9.0.0.Final");
            maestro.putEnvironmentVariable(VERSION_POSTGRESQL, "9.3");
//          maestro.setSecurityRealmType(SecurityRealmType.LDAP);
//          maestro.setRoleBasedAccessControllerName("LDAP");
            maestro.setInternetAccessAllowed(true);
            maestro.setAlias("xyz1ap101");
            maestro.generate(PLATAFORMA_NETBEANS_POSTGRESQL_GLASSFISH);
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
    Auditoria modx1;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ControlAcceso modx2;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ControlProcesos modx3;

    @ProjectModule(menu = Kleenean.TRUE, role = Kleenean.TRUE)
    ControlPruebas modx4;

    @ProjectModule(menu = Kleenean.FALSE, role = Kleenean.TRUE)
    ControlTareas modx5;

}
