/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.proyecto;

import adalid.core.Project;
import meta.entidad.Documento;
import meta.entidad.DocumentoCliente;
import meta.entidad.DocumentoProducto;

/**
 * @author Jorge Campins
 */
public class ModuloDocumentos extends Project {

    @Override
    protected void settleAttributes() {
        super.settleAttributes();
        setDefaultLabel("Documentos");
        setDefaultDescription("Módulo de Documentos");
    }

    Documento documento;

    DocumentoCliente documentoCliente;

    DocumentoProducto documentoProducto;

}
