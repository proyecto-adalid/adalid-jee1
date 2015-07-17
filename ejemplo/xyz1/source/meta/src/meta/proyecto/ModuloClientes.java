/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.proyecto;

import adalid.core.Project;
import meta.entidad.ActividadEconomica;
import meta.entidad.Cliente;
import meta.entidad.Jurisdiccion;
import meta.entidad.PersonaJuridica;
import meta.entidad.PersonaNatural;

/**
 * @author Jorge Campins
 */
public class ModuloClientes extends Project {

    @Override
    protected void settleAttributes() {
        super.settleAttributes();
        setDefaultLabel("Clientes");
        setDefaultDescription("Módulo de Clientes");
    }

    ActividadEconomica actividadEconomica;

    Cliente cliente;

    Jurisdiccion jurisdiccion;

    PersonaJuridica personaJuridica;

    PersonaNatural personaNatural;

}
