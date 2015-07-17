/*
 * Este programa es software libre; usted puede redistribuirlo y/o modificarlo bajo los terminos
 * de la licencia "GNU General Public License" publicada por la Fundacion "Free Software Foundation".
 * Este programa se distribuye con la esperanza de que pueda ser util, pero SIN NINGUNA GARANTIA;
 * vea la licencia "GNU General Public License" para obtener mas informacion.
 */
package meta.entidad;

import adalid.core.ProcessOperation;
import adalid.core.Tab;
import adalid.core.annotations.Allocation;
import adalid.core.annotations.CharacterDataGen;
import adalid.core.annotations.ColumnField;
import adalid.core.annotations.DiscriminatorValue;
import adalid.core.annotations.EntityDataGen;
import adalid.core.annotations.EntityReferenceDataGen;
import adalid.core.annotations.FileReference;
import adalid.core.annotations.ForeignKey;
import adalid.core.annotations.InstanceReference;
import adalid.core.annotations.ManyToOne;
import adalid.core.annotations.OneToOne;
import adalid.core.annotations.OperationClass;
import adalid.core.annotations.ParameterField;
import adalid.core.annotations.ProcessOperationClass;
import adalid.core.annotations.PropertyField;
import adalid.core.annotations.TemporalDataGen;
import adalid.core.enums.Kleenean;
import adalid.core.enums.MasterDetailView;
import adalid.core.enums.Navigability;
import adalid.core.enums.OnDeleteAction;
import adalid.core.enums.OnUpdateAction;
import adalid.core.enums.OperationAccess;
import adalid.core.interfaces.*;
import adalid.core.parameters.StringParameter;
import adalid.core.properties.DateProperty;
import adalid.core.properties.StringProperty;
import java.lang.reflect.Field;

/**
 * PersonaNatural Persistent Entity.
 *
 * @author Jorge Campins
 */
@DiscriminatorValue("2")
@EntityDataGen(start = 1, step = 1, stop = 1000)
public class PersonaNatural extends Cliente {

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
    private PersonaNatural() {
        this(null, null);
    }

    public PersonaNatural(Artifact declaringArtifact, Field declaringField) {
        super(declaringArtifact, declaringField);
    }
    // </editor-fold>

    /**
     * date property field
     */
    @PropertyField(create = Kleenean.TRUE, report = Kleenean.TRUE)
    @TemporalDataGen(min = "-80Y", max = "-21Y")
    public DateProperty fechaNacimiento;

    /**
     * many-to-one entity reference property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    public SexoCliente sexo;

    /**
     * many-to-one entity reference property field
     */
    @ColumnField(nullable = Kleenean.FALSE)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @ManyToOne(navigability = Navigability.UNIDIRECTIONAL, view = MasterDetailView.NONE)
    public EstadoCivil estadoCivil;

    /**
     * one-to-one entity reference property field
     */
    @Allocation(maxDepth = 2, maxRound = 1)
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @OneToOne(navigability = Navigability.UNIDIRECTIONAL)
    @PropertyField(create = Kleenean.TRUE)
    @EntityReferenceDataGen(nullable = 100)
    public PersonaNatural conyuge;

    /**
     * one-to-one entity reference property field
     */
    @ForeignKey(onDelete = OnDeleteAction.NONE, onUpdate = OnUpdateAction.NONE)
    @OneToOne(navigability = Navigability.UNIDIRECTIONAL)
    @PropertyField(create = Kleenean.TRUE)
    public PersonaJuridica empleador;

    @FileReference
    @PropertyField(create = Kleenean.FALSE, update = Kleenean.FALSE, table = Kleenean.TRUE, report = Kleenean.FALSE)
    @CharacterDataGen(nullable = 0)
    public StringProperty foto;

    protected Tab tab101;

    @Override
    protected void settleTabs() {
        super.settleTabs();
        setDefaultTab(tab101);
        tab101.setDefaultLabel("persona natural");
        tab101.newTabField(fechaNacimiento, sexo, estadoCivil, conyuge, empleador, foto);
    }

    Check check101, check102, check103;

    @Override
    protected void settleExpressions() {
        super.settleExpressions();
        check101 = estadoCivil.isEqualTo(estadoCivil.SOLTERO).implies(conyuge.isNull());
        check101.setDefaultErrorMessage("el conyuge no se puede especificar si la persona está soltera");
        check102 = conyuge.isNull().or(conyuge.isNotEqualTo(this));
        check102.setDefaultErrorMessage("el conyuge tiene que ser otra persona");
        check103 = conyuge.isNull().or(conyuge.sexo.isNotEqualTo(sexo));
        check103.setDefaultErrorMessage("el conyuge tiene que ser una persona del sexo opuesto");
        conyuge.setSearchQueryFilter(conyuge.isNotEqualTo(this).and(conyuge.sexo.isNotEqualTo(sexo)));
    }

    protected CargarFoto cargarFoto;

    @ProcessOperationClass(overloading = Kleenean.FALSE)
    @OperationClass(access = OperationAccess.RESTRICTED)
    public class CargarFoto extends ProcessOperation {

        @InstanceReference
        protected PersonaNatural persona;

        @FileReference
        @ParameterField(linkedField = "foto", required = Kleenean.TRUE)
        protected StringParameter foto;

    }

}
