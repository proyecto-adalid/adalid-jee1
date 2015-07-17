/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.entidad;

import adalid.core.*;
import adalid.core.annotations.*;
import adalid.core.enums.*;
import adalid.core.interfaces.*;
import adalid.core.parameters.*;
import adalid.core.properties.*;
import java.lang.reflect.Field;

/**
 * Cliente Persistent Entity.
 *
 * @author Jorge Campins
 */
@AbstractClass
@InheritanceMapping(strategy = InheritanceMappingStrategy.JOINED)
@EntityTableView(inserts = Kleenean.FALSE)
@EntityDataGen(start = 1, step = 1, stop = 100)
public class Cliente extends AbstractPersistentEntity {

    // <editor-fold defaultstate="collapsed" desc="code templates">
    //
    // Available entity class annotation code templates:
    //
    // $abstract	Code template for an abstract class annotation
    // $allocover	Code template for a single allocation override annotation
    // $allocovers	Code template for a set of allocation override annotations
    // $console         Code template for an entity console view annotation
    // $delete          Code template for an entity delete operation annotation
    // $detail          Code template for an entity detail view annotation
    // $disval          Code template for a discriminator value annotation
    // $entity          Code template for an entity class annotation
    // $export          Code template for an entity export operation annotation
    // $inhmap          Code template for an entity inheritance mapping annotation
    // $insert          Code template for an entity insert operation annotation
    // $report          Code template for an entity report operation annotation
    // $search          Code template for an entity reference search annotation
    // $select          Code template for an entity select operation annotation
    // $table           Code template for an entity table view annotation
    // $tree            Code template for an entity tree view annotation
    // $triggers	Code template for an entity triggers annotation
    // $update          Code template for an entity update operation annotation
    //
    // Available property field code templates:
    //
    // $bigdecpro	Code template for a big decimal property field
    // $bigintpro	Code template for a big integer property field
    // $boolpro         Code template for a boolean property field
    // $bytepro         Code template for a byte property field
    // $charbizkey	Code template for a character business key property field
    // $charkey         Code template for a character key property field
    // $charpro         Code template for a character property field
    // $code            Code template for a business key property field
    // $datepro         Code template for a date property field
    // $description	Code template for a description property field
    // $doublepro	Code template for a double property field
    // $entpro          Code template for an entity reference property field
    // $filerefpro	Code template for a file reference property field
    // $floatpro	Code template for a float property field
    // $id              Code template for a long primary key property field
    // $inactive	Code template for an inactive indicator property field
    // $intpro          Code template for a integer property field
    // $longpro         Code template for a long property field
    // $many            Code template for a many-to-one entity reference property field
    // $name            Code template for a name property field
    // $number          Code template for an integer primary key property field
    // $numbizkey	Code template for a numeric business key property field
    // $numkey          Code template for a numeric key property field
    // $one             Code template for a one-to-one entity reference property field
    // $owner           Code template for an owner entity reference property field
    // $parent          Code template for a parent entity reference property field
    // $segment         Code template for a segment entity reference property field
    // $shortpro	Code template for a short property field
    // $stringpro	Code template for a string property field
    // $timepro         Code template for a time property field
    // $stamppro        Code template for a timestamp property field
    // $url             Code template for an URL property field
    // $version         Code template for a version property field
    //
    // Available property annotation code templates:
    //
    // $alloc           Code template for an allocation annotation
    // $base            Code template for a base field annotation
    // $bigdec          Code template for a big decimal field annotation
    // $casting         Code template for a casting field annotation
    // $column          Code template for a column field annotation
    // $discol          Code template for a discriminator column annotation
    // $extension	Code template for an extension annotation
    // $fileref         Code template for a file reference annotation
    // $property	Code template for a property field annotation
    // $string          Code template for a string field annotation
    // $time            Code template for a time field annotation
    // $stamp           Code template for a timestamp field annotation
    // $unique          Code template for a unique key annotation
    //
    // Available entity key field code templates:
    //
    // $key             Code template for a key field
    //
    // Available entity tab field code templates:
    //
    // $tab             Code template for a tab field
    //
    // Available entity instance field code templates:
    //
    // $instance	Code template for a instance field
    //
    // Available entity trigger field code templates:
    //
    // $trigger         Code template for a trigger field
    //
    // Available entity expression field code templates:
    //
    // $checkx          Code template for a check expression field
    // $segmentx	Code template for a segment expression field
    // $statex          Code template for a state expression field
    //
    // Available operation class code templates:
    //
    // $exportop        Code template for an export operation
    // $operation       Code template for an operation class annotation
    // $procedure       Code template for a procedure operation
    // $process         Code template for a process operation
    // $reportop        Code template for a report operation
    //
    // Available parameter field code templates:
    //
    // $bigdecpar	Code template for a big decimal parameter field
    // $bigintpar	Code template for a big integer parameter field
    // $boolpar         Code template for a boolean parameter field
    // $bytepar         Code template for a byte parameter field
    // $charpar         Code template for a character parameter field
    // $datepar         Code template for a date parameter field
    // $doublepar	Code template for a double parameter field
    // $entpar          Code template for an entity reference parameter field
    // $filerefpar	Code template for a file reference parameter field
    // $floatpar	Code template for a float parameter field
    // $insrefpar	Code template for an instance reference parameter field
    // $intpar          Code template for a integer parameter field
    // $longpar         Code template for a long parameter field
    // $shortpar	Code template for a short parameter field
    // $stringpar	Code template for a string parameter field
    // $timepar         Code template for a time parameter field
    // $stamppar        Code template for a timestamp parameter field
    //
    // Available parameter annotation code templates:
    //
    // $alloc           Code template for an allocation annotation
    // $bigdec          Code template for a big decimal field annotation
    // $fileref         Code template for a file reference annotation
    // $insref          Code template for an instance reference parameter annotation
    // $parameter	Code template for a parameter field annotation
    // $string          Code template for a string field annotation
    // $time            Code template for a time field annotation
    // $stamp           Code template for a timestamp field annotation
    //
    // Available operation transition field code templates:
    //
    // $transition	Code template for a transition field
    //
    // </editor-fold>
/**/
    // <editor-fold defaultstate="collapsed" desc="class constructors">
    @Deprecated()
    private Cliente() {
        this(null, null);
    }

    public Cliente(Artifact declaringArtifact, Field declaringField) {
        super(declaringArtifact, declaringField);
    }
    // </editor-fold>

    @Override
    protected void settleAttributes() {
        super.settleAttributes();
    }

    @PrimaryKey
    public LongProperty id;

    @VersionProperty
    public LongProperty version;

    @DiscriminatorColumn
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    public TipoCliente tipo;

    /**
     * business key property field
     */
    @BusinessKey
    @CharacterDataGen(function = "util.string_codigo_entidad")
    public StringProperty codigo;

    /**
     * name property field
     */
    @NameProperty
    @CharacterDataGen(function = "util.string_nombre_entidad", nullable = 0)
    public StringProperty nombre;

    /**
     * string property field
     */
    @PropertyField(create = Kleenean.TRUE)
    @CharacterDataGen(nullable = 100)
    public StringProperty telefonos;

    /**
     * string property field
     */
    @PropertyField(create = Kleenean.TRUE)
    @CharacterDataGen(nullable = 100)
    public StringProperty direccion;

    /**
     * many-to-one entity reference property field
     */
    @Allocation(maxDepth = 2, maxRound = 1)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    @PropertyField(create = Kleenean.TRUE, search = Kleenean.TRUE)
    public Jurisdiccion jurisdiccion;

    /**
     * many-to-one entity reference property field
     */
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    @PropertyField(create = Kleenean.TRUE, search = Kleenean.TRUE)
    public ActividadEconomica actividadEconomica;

    /**
     * date property field
     */
    public DateProperty fechaInicioRelacion;

    /**
     * big decimal property field
     */
    @BigDecimalField(precision = 16, scale = 2)
    @PropertyField(create = Kleenean.TRUE, update = Kleenean.TRUE, table = Kleenean.FALSE, access = PropertyAccess.RESTRICTED_READING)
    @NumericField(divisorRule = DivisorRule.ROUND)
    @NumericDataGen(min = "10", max = "1000")
    public BigDecimalProperty ingresoPromedioMensual;

    /**
     * big decimal property field
     */
    @BigDecimalField(precision = 16, scale = 2)
    @PropertyField(create = Kleenean.TRUE, update = Kleenean.TRUE, table = Kleenean.FALSE, access = PropertyAccess.RESTRICTED_WRITING, report = Kleenean.TRUE)
    @NumericField(divisorRule = DivisorRule.ROUND)
    @NumericDataGen(min = "10", max = "1000")
    public BigDecimalProperty limiteCredito;

    /**
     * boolean property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @PropertyField(create = Kleenean.TRUE, update = Kleenean.TRUE, search = Kleenean.TRUE, table = Kleenean.FALSE, report = Kleenean.FALSE)
    public BooleanProperty analizado;

    /**
     * boolean property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @PropertyField(create = Kleenean.TRUE, update = Kleenean.TRUE, search = Kleenean.TRUE, table = Kleenean.FALSE, report = Kleenean.FALSE)
    public BooleanProperty aprobado;

    /**
     * boolean property field
     */
    @ColumnField(nullable = Kleenean.TRUE)
    @PropertyField(create = Kleenean.TRUE, update = Kleenean.TRUE, search = Kleenean.TRUE, table = Kleenean.FALSE, report = Kleenean.FALSE)
    @BooleanDataGen(nullable = 50)
    public BooleanProperty auditado;

    @Override
    protected void settleProperties() {
        super.settleProperties();
        analizado.setInitialValue(Boolean.TRUE);
        analizado.setDefaultValue(Boolean.TRUE);
        fechaInicioRelacion.setDefaultLabel("fecha de inicio de la relación");
        limiteCredito.setDefaultLabel("límite de crédito");
    }

    protected Tab tab001, tab002;

    @Override
    protected void settleTabs() {
        super.settleTabs();
        tab001.setDefaultLabel("cliente");
        tab001.newTabField(telefonos, direccion, jurisdiccion, actividadEconomica, fechaInicioRelacion);
        tab002.setDefaultLabel("credito");
        tab002.newTabField(ingresoPromedioMensual, limiteCredito, analizado, aprobado, auditado);
    }

    View v1;

    @Override
    protected void settleViews() {
        super.settleViews();
        ViewField vf;
        v1.setDefaultLabel("Clientes por Jurisdicción, Actividad Económica y Tipo de Cliente");
        vf = v1.newControlField(jurisdiccion.codigo);
        vf.setDefaultLabel("jurisdicción");
        v1.newHeadingField(jurisdiccion.nombre, jurisdiccion.codigo);
        vf = v1.newHeadingField(jurisdiccion.superior.codigo, jurisdiccion.codigo);
        vf.setDefaultLabel("jurisdicción superior");
        vf = v1.newHeadingField(jurisdiccion.superior.nombre, jurisdiccion.codigo);
        vf.setDefaultLabel("nombre de jurisdicción superior");
        vf = v1.newControlField(actividadEconomica.codigo);
        vf.setDefaultLabel("actividad económica");
        v1.newHeadingField(actividadEconomica.nombre, actividadEconomica.codigo);
        vf = v1.newControlField(tipo.codigo);
        vf.setDefaultLabel("tipo de cliente");
        v1.newDetailField(codigo);
        v1.newDetailField(nombre, SortOption.ASC);
        vf = v1.newDetailField(fechaInicioRelacion);
        vf.setDefaultLabel("inicio de la relación");
        vf.setDefaultShortLabel("cliente desde");
        vf.setPixels(96);
        vf = v1.newDetailField(analizado);
        vf.setPixels(64);
        vf = v1.newDetailField(aprobado);
        vf.setPixels(64);
        vf = v1.newDetailField(auditado);
        vf.setPixels(64);
        v1.newDetailField(limiteCredito, ViewFieldAggregation.AVERAGE_DEVIATION_MINIMUM_MAXIMUM);
    }

    protected EmitirInformePorJurisdiccionActividadTipo emitirInformePorJurisdiccionActividadTipo;

    @ReportOperationClass(viewField = "v1", detailRowsLimit = 2000, summaryRowsLimit = 3000, chartRowsLimit = 1000)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class EmitirInformePorJurisdiccionActividadTipo extends ReportOperation {

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected ActividadEconomica actividadEconomica;

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected Jurisdiccion jurisdiccion;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fechaInicioRelacion", operator = StandardRelationalOp.GTEQ)
        protected DateParameter desdeFecha;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fechaInicioRelacion", operator = StandardRelationalOp.LTEQ)
        protected DateParameter hastaFecha;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "limiteCredito", operator = StandardRelationalOp.GTEQ)
        protected BigDecimalParameter desdeMonto;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "limiteCredito", operator = StandardRelationalOp.LTEQ)
        protected BigDecimalParameter hastaMonto;

        @Override
        protected void settleAttributes() {
            super.settleAttributes();
            setDefaultLabel("emitir informe por jurisdicción, actividad económica y tipo de cliente");
        }

    }

    protected ExportarArchivoPorJurisdiccionActividadTipo exportarArchivoPorJurisdiccionActividadTipo;

    @ExportOperationClass(viewField = "v1", detailRowsLimit = 4000, summaryRowsLimit = 5000)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class ExportarArchivoPorJurisdiccionActividadTipo extends ExportOperation {

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected ActividadEconomica actividadEconomica;

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected Jurisdiccion jurisdiccion;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fechaInicioRelacion", operator = StandardRelationalOp.GTEQ)
        protected DateParameter desdeFecha;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fechaInicioRelacion", operator = StandardRelationalOp.LTEQ)
        protected DateParameter hastaFecha;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "limiteCredito", operator = StandardRelationalOp.GTEQ)
        protected BigDecimalParameter desdeMonto;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "limiteCredito", operator = StandardRelationalOp.LTEQ)
        protected BigDecimalParameter hastaMonto;

        @Override
        protected void settleAttributes() {
            super.settleAttributes();
            setDefaultLabel("exportar archivo por jurisdicción, actividad económica y tipo de cliente");
        }

    }

    protected Marcar marcar;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class Marcar extends ProcessOperation {

        /**
         * instance reference parameter field
         */
        @InstanceReference
        protected Cliente cliente;

        /**
         * boolean parameter field
         */
        @ParameterField(required = Kleenean.TRUE, linkedField = "analizado")
        protected BooleanParameter analizado;

        /**
         * boolean parameter field
         */
        @ParameterField(required = Kleenean.TRUE, linkedField = "aprobado")
        protected BooleanParameter aprobado;

        /**
         * boolean parameter field
         */
        @ParameterField(required = Kleenean.FALSE, linkedField = "auditado")
        protected BooleanParameter auditado;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            analizado.setInitialValue(Boolean.TRUE);
            analizado.setDefaultValue(Boolean.TRUE);
            aprobado.setInitialValue(Boolean.TRUE);
            aprobado.setDefaultValue(Boolean.TRUE);
            auditado.setInitialValue(Boolean.TRUE);
            auditado.setDefaultValue(Boolean.TRUE);
        }

    }

}
