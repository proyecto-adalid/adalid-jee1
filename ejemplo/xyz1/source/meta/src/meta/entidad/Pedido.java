/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.entidad;

import adalid.core.AbstractPersistentEntity;
import adalid.core.ExportOperation;
import adalid.core.ProcessOperation;
import adalid.core.ReportOperation;
import adalid.core.View;
import adalid.core.annotations.Allocation;
import adalid.core.annotations.BigDecimalField;
import adalid.core.annotations.BusinessKey;
import adalid.core.annotations.CharacterDataGen;
import adalid.core.annotations.ColumnField;
import adalid.core.annotations.EntityDataGen;
import adalid.core.annotations.ExportOperationClass;
import adalid.core.annotations.ForeignKey;
import adalid.core.annotations.InstanceReference;
import adalid.core.annotations.ManyToOne;
import adalid.core.annotations.NumericDataGen;
import adalid.core.annotations.OperationClass;
import adalid.core.annotations.ParameterField;
import adalid.core.annotations.PrimaryKey;
import adalid.core.annotations.ProcessOperationClass;
import adalid.core.annotations.PropertyField;
import adalid.core.annotations.ReportOperationClass;
import adalid.core.annotations.StringField;
import adalid.core.annotations.TemporalDataGen;
import adalid.core.annotations.VersionProperty;
import adalid.core.enums.DataGenType;
import adalid.core.enums.Kleenean;
import adalid.core.enums.MasterDetailView;
import adalid.core.enums.Navigability;
import adalid.core.enums.OnDeleteAction;
import adalid.core.enums.OnUpdateAction;
import adalid.core.enums.OperationAccess;
import adalid.core.enums.SortOption;
import adalid.core.enums.SpecialTemporalValue;
import adalid.core.enums.StandardRelationalOp;
import adalid.core.enums.ViewFieldAggregation;
import adalid.core.interfaces.Artifact;
import adalid.core.interfaces.State;
import adalid.core.parameters.BigDecimalParameter;
import adalid.core.parameters.DateParameter;
import adalid.core.parameters.StringParameter;
import adalid.core.properties.BigDecimalProperty;
import adalid.core.properties.DateProperty;
import adalid.core.properties.LongProperty;
import adalid.core.properties.StringProperty;
import adalid.core.properties.TimestampProperty;
import java.awt.Color;
import java.lang.reflect.Field;

/**
 * Pedido Persistent Entity.
 *
 * @author Jorge Campins
 */
@EntityDataGen(start = 1, step = 1, stop = 10000)
public class Pedido extends AbstractPersistentEntity {

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
    private Pedido() {
        this(null, null);
    }

    public Pedido(Artifact declaringArtifact, Field declaringField) {
        super(declaringArtifact, declaringField);
    }
    // </editor-fold>

    @PrimaryKey
    public LongProperty id;

    @VersionProperty
    public LongProperty version;

    /**
     * business key property field
     */
    @BusinessKey
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    @CharacterDataGen(type = DataGenType.SERIES, pattern = "000000000000000000")
    public StringProperty numero;

    /**
     * many-to-one entity reference property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.TABLE_AND_DETAIL)
    @PropertyField(table = Kleenean.TRUE, report = Kleenean.TRUE)
    public Cliente cliente;

    /**
     * date property field
     */
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE, heading = Kleenean.TRUE)
    @TemporalDataGen(min = "-30D", max = "0")
    public DateProperty fecha;

    /**
     * big decimal property field
     */
    @BigDecimalField(precision = 16, scale = 2)
    @ColumnField(nullable = Kleenean.FALSE)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE, heading = Kleenean.TRUE)
    @NumericDataGen(min = "100", max = "10000")
    public BigDecimalProperty monto;

    /**
     * many-to-one entity reference property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE)
    public EstadoPedido estado;

    /**
     * date property field
     */
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, heading = Kleenean.TRUE)
    @TemporalDataGen(min = "-30D", max = "0")
    public TimestampProperty fechaEstado;

    /**
     * string property field
     */
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    @StringField(maxLength = 20)
    @CharacterDataGen(nullable = 100)
    public StringProperty tarjeta;

    /**
     * string property field
     */
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    @CharacterDataGen(nullable = 100)
    public StringProperty direccion;

    @Override
    protected void settleProperties() {
        super.settleProperties();
        numero.setDefaultLabel("número");
        fecha.setDefaultValue(SpecialTemporalValue.CURRENT_DATE);
        monto.setDefaultValue(0);
        estado.setDefaultValue(estado.RECIBIDO);
        fechaEstado.setDefaultValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        tarjeta.setDefaultDescription("número de tarjeta de crédito utilizada para el pago");
        direccion.setDefaultLabel("dirección");
        direccion.setDefaultDescription("dirección de envío (si es diferente a la dirección del cliente)");
    }

    View v1;

    @Override
    protected void settleViews() {
        super.settleViews();
        v1.setDefaultLabel("Pedidos por Estado y Aprobación");
        v1.newControlField(estado.codigo);
        v1.newControlField(cliente.aprobado);
        v1.newDetailField(numero, SortOption.ASC);
        v1.newDetailField(fecha);
        v1.newDetailField(fechaEstado);
        v1.newDetailField(cliente.nombre);
        v1.newDetailField(cliente.codigo);
        v1.newDetailField(monto, ViewFieldAggregation.SUM_COUNT_AVERAGE_DEVIATION_MINIMUM_MAXIMUM);
    }

    State recibido, procesado, cobrado, enviado, cancelable, cancelado;

    @Override
    protected void settleExpressions() {
        super.settleExpressions();
        /**/
        recibido = estado.isEqualTo(estado.RECIBIDO);
        recibido.setDefaultErrorMessage("el pedido no está recibido");
        /**/
        procesado = estado.isEqualTo(estado.PROCESADO);
        procesado.setDefaultErrorMessage("el pedido no está procesado");
        /**/
        cobrado = estado.isEqualTo(estado.COBRADO);
        cobrado.setDefaultErrorMessage("el pedido no está cobrado");
        /**/
        enviado = estado.isEqualTo(estado.ENVIADO);
        enviado.setDefaultErrorMessage("el pedido no está enviado");
        /**/
        cancelado = estado.isEqualTo(estado.CANCELADO);
        cancelado.setDefaultErrorMessage("el pedido no está cancelado");
        /**/
        cancelable = recibido.or(procesado).or(cobrado);
        cancelable.setDefaultErrorMessage("el pedido no está recibido, procesado o cobrado");
    }

    @Override
    protected void settleFilters() {
        setUpdateFilter(recibido);
        setDeleteFilter(recibido);
    }

    protected Procesar procesar;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class Procesar extends ProcessOperation {

        /**
         * instance reference parameter field
         */
        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Pedido pedido;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            pedido.estado.setCurrentValue(estado.PROCESADO);
            pedido.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        }

    }

    protected cobrar cobrar;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class cobrar extends ProcessOperation {

        /**
         * instance reference parameter field
         */
        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Pedido pedido;

        /**
         * string parameter field
         */
        @ParameterField(linkedField = "tarjeta", required = Kleenean.TRUE)
        @StringField(maxLength = 20)
        protected StringParameter tarjeta;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            pedido.estado.setCurrentValue(estado.COBRADO);
            pedido.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        }

    }

    protected enviar enviar;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class enviar extends ProcessOperation {

        /**
         * instance reference parameter field
         */
        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Pedido pedido;

        /**
         * string parameter field
         */
        @ParameterField(linkedField = "direccion", required = Kleenean.FALSE)
        protected StringParameter direccion;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            pedido.estado.setCurrentValue(estado.ENVIADO);
            pedido.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        }

    }

    protected cancelar cancelar;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class cancelar extends ProcessOperation {

        /**
         * instance reference parameter field
         */
        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Pedido pedido;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            pedido.estado.setCurrentValue(estado.CANCELADO);
            pedido.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        }

    }

    protected EmitirInformePorEstadoAprobacion emitirInformePorEstadoAprobacion;

    @ReportOperationClass(viewField = "v1", detailRowsLimit = 2000, summaryRowsLimit = 3000, chartRowsLimit = 1000)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class EmitirInformePorEstadoAprobacion extends ReportOperation {

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected Cliente cliente;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fecha", operator = StandardRelationalOp.GTEQ)
        protected DateParameter desdeFecha;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fecha", operator = StandardRelationalOp.LTEQ)
        protected DateParameter hastaFecha;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "monto", operator = StandardRelationalOp.GTEQ)
        protected BigDecimalParameter desdeMonto;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "monto", operator = StandardRelationalOp.LTEQ)
        protected BigDecimalParameter hastaMonto;

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected EstadoPedido estado;

        @Override
        protected void settleAttributes() {
            super.settleAttributes();
            setDefaultLabel("emitir informe por estado y aprobación");
            clearChartColorList();
            addChartColor(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE);
        }

    }

    protected ExportarArchivoPorEstadoAprobacion exportarArchivoPorEstadoAprobacion;

    @ExportOperationClass(viewField = "v1", detailRowsLimit = 4000, summaryRowsLimit = 5000)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class ExportarArchivoPorEstadoAprobacion extends ExportOperation {

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected Cliente cliente;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fecha", operator = StandardRelationalOp.GTEQ)
        protected DateParameter desdeFecha;

        /**
         * date parameter field
         */
        @ParameterField(linkedField = "fecha", operator = StandardRelationalOp.LTEQ)
        protected DateParameter hastaFecha;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "monto", operator = StandardRelationalOp.GTEQ)
        protected BigDecimalParameter desdeMonto;

        /**
         * big decimal parameter field
         */
        @ParameterField(linkedField = "monto", operator = StandardRelationalOp.LTEQ)
        protected BigDecimalParameter hastaMonto;

        /**
         * entity reference parameter field
         */
        @ParameterField
        protected EstadoPedido estado;

        @Override
        protected void settleAttributes() {
            super.settleAttributes();
            setDefaultLabel("exportar archivo por estado y aprobación");
        }

    }

    @Override
    protected void settleOperations() {
        super.settleOperations();
        insert.addTransition(null, recibido);
        procesar.addTransition(recibido, procesado);
        cobrar.addTransition(procesado, cobrado);
        enviar.addTransition(cobrado, enviado);
        cancelar.addTransition(cancelable, cancelado);
        /**/
        procesar.addTriggerOn(recibido);
        cobrar.addTriggerOn(procesado);
        enviar.addTriggerOn(cobrado);
    }

}
