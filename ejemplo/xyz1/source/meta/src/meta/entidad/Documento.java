/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.entidad;

import adalid.core.ProcessOperation;
import adalid.core.annotations.AbstractClass;
import adalid.core.annotations.Allocation;
import adalid.core.annotations.BusinessKey;
import adalid.core.annotations.CharacterDataGen;
import adalid.core.annotations.ColumnField;
import adalid.core.annotations.DescriptionProperty;
import adalid.core.annotations.DiscriminatorColumn;
import adalid.core.annotations.EntityClass;
import adalid.core.annotations.EntityDeleteOperation;
import adalid.core.annotations.EntityInsertOperation;
import adalid.core.annotations.EntitySelectOperation;
import adalid.core.annotations.EntityUpdateOperation;
import adalid.core.annotations.FileReference;
import adalid.core.annotations.ForeignKey;
import adalid.core.annotations.InheritanceMapping;
import adalid.core.annotations.InstanceReference;
import adalid.core.annotations.ManyToOne;
import adalid.core.annotations.OperationClass;
import adalid.core.annotations.ParameterField;
import adalid.core.annotations.ProcessOperationClass;
import adalid.core.annotations.PropertyField;
import adalid.core.annotations.StringField;
import adalid.core.enums.DefaultCondition;
import adalid.core.enums.InheritanceMappingStrategy;
import adalid.core.enums.Kleenean;
import adalid.core.enums.MasterDetailView;
import adalid.core.enums.Navigability;
import adalid.core.enums.OnDeleteAction;
import adalid.core.enums.OnUpdateAction;
import adalid.core.enums.OperationAccess;
import adalid.core.enums.ResourceType;
import adalid.core.enums.SpecialTemporalValue;
import adalid.core.interfaces.Artifact;
import adalid.core.interfaces.Check;
import adalid.core.interfaces.State;
import adalid.core.parameters.StringParameter;
import adalid.core.properties.DateProperty;
import adalid.core.properties.StringProperty;
import adalid.core.properties.TimestampProperty;
import java.lang.reflect.Field;
import meta.entidad.base.PersistentEntityBase;
import meta.entidad.comun.auditoria.ArchivoAdjunto;

/**
 * Documento Persistent Entity.
 *
 * @author Jorge Campins
 */
@AbstractClass
@EntityClass(resourceType = ResourceType.OPERATION, independent = Kleenean.FALSE)
@InheritanceMapping(strategy = InheritanceMappingStrategy.SINGLE_TABLE)
@EntityUpdateOperation(access = OperationAccess.PROTECTED)
@EntityInsertOperation(access = OperationAccess.PROTECTED)
@EntityDeleteOperation(access = OperationAccess.PROTECTED)
@EntitySelectOperation(access = OperationAccess.PROTECTED)
public class Documento extends PersistentEntityBase {

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
    private Documento() {
        this(null, null);
    }

    public Documento(Artifact declaringArtifact, Field declaringField) {
        super(declaringArtifact, declaringField);
    }
    // </editor-fold>

    @Override
    protected void settleAttributes() {
        super.settleAttributes();
    }

    @DiscriminatorColumn
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    public TipoDocumento tipo;

    @BusinessKey
    @CharacterDataGen(function = "util.string_codigo_entidad", nullable = 0)
    @StringField(maxLength = 20)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    public StringProperty codigo;

    @DescriptionProperty
    @CharacterDataGen(function = "util.string_descripcion_entidad", nullable = 0)
    @PropertyField(required = Kleenean.TRUE, table = Kleenean.TRUE, report = Kleenean.TRUE, create = Kleenean.TRUE, update = Kleenean.TRUE)
    public StringProperty descripcion;

    @FileReference
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE)
    public StringProperty archivo;

    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    public ArchivoAdjunto adjunto;

    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE, defaultCondition = DefaultCondition.UNCONDITIONALLY)
    public TimestampProperty ultimaCarga;

    @ColumnField(nullable = Kleenean.FALSE)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.TRUE)
    public EstadoDocumento estado;

    @ColumnField(nullable = Kleenean.FALSE)
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    public DateProperty fechaEstado;

    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE)
    public StringProperty observaciones;

    @Override
    protected void settleProperties() {
        super.settleProperties();
        estado.setInitialValue(estado.MODIFICABLE);
        estado.setDefaultValue(estado.MODIFICABLE);
        fechaEstado.setInitialValue(SpecialTemporalValue.CURRENT_DATE);
        fechaEstado.setDefaultValue(SpecialTemporalValue.CURRENT_DATE);
    }

    public State modificable, verificable, verificado, rechazado;

    @Override
    protected void settleExpressions() {
        super.settleExpressions();
        modificable = estado.isEqualTo(estado.MODIFICABLE);
        modificable.setDefaultErrorMessage("el documento no está Modificable");
        verificable = estado.isEqualTo(estado.VERIFICABLE);
        verificable.setDefaultErrorMessage("el documento no está Verificable");
        verificado = estado.isEqualTo(estado.VERIFICADO);
        verificado.setDefaultErrorMessage("el documento no está Verificado");
        rechazado = estado.isEqualTo(estado.RECHAZADO);
        rechazado.setDefaultErrorMessage("el documento no está Rechazado");
    }

    @Override
    protected void settleFilters() {
        setUpdateFilter(modificable);
        setDeleteFilter(modificable);
    }

    @Override
    protected void settleOperations() {
        super.settleOperations();
        insert.addTransition(null, modificable);
        solicitarVerificacion.addTransition(modificable, verificable);
        aceptar.addTransition(verificable, verificado);
        rechazar.addTransition(verificable, rechazado);
        /**/
        aceptar.addTriggerOn(verificable);
    }

    protected Cargar cargar;

    public class Cargar extends ProcessOperation {

        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Documento documento;

        @FileReference(joinField = "adjunto")
        @ParameterField(required = Kleenean.TRUE, linkedField = "archivo")
        protected StringParameter archivo;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            documento.ultimaCarga.setCurrentValue(SpecialTemporalValue.CURRENT_TIMESTAMP);
        }

        Check check0101;

        @Override
        protected void settleExpressions() {
            super.settleExpressions();
            check0101 = documento.modificable.isTrue();
        }

        @Override
        protected void settleFilters() {
            super.settleFilters();
            documento.setSearchQueryFilter(check0101);
        }

    }

    protected SolicitarVerificacion solicitarVerificacion;

    @OperationClass
    @ProcessOperationClass(overloading = Kleenean.FALSE)
    public class SolicitarVerificacion extends ProcessOperation {

        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Documento documento;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            documento.estado.setCurrentValue(estado.VERIFICABLE);
            documento.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_DATE);
        }

    }

    protected Aceptar aceptar;

    @OperationClass
    @ProcessOperationClass(overloading = Kleenean.FALSE)
    public class Aceptar extends ProcessOperation {

        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Documento documento;

        @ParameterField(required = Kleenean.FALSE, linkedField = "observaciones")
        protected StringParameter observaciones;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            documento.estado.setCurrentValue(estado.VERIFICADO);
            documento.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_DATE);
        }

    }

    protected Rechazar rechazar;

    @OperationClass
    @ProcessOperationClass(overloading = Kleenean.FALSE)
    public class Rechazar extends ProcessOperation {

        @InstanceReference
        @Allocation(maxDepth = 1, maxRound = 0)
        protected Documento documento;

        @ParameterField(required = Kleenean.FALSE, linkedField = "observaciones")
        protected StringParameter observaciones;

        @Override
        protected void settleParameters() {
            super.settleParameters();
            documento.estado.setCurrentValue(estado.RECHAZADO);
            documento.fechaEstado.setCurrentValue(SpecialTemporalValue.CURRENT_DATE);
        }

    }

}
