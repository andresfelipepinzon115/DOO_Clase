package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

import static co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper.ZERO;

public final  class DepartamentoEntity {

    private int id;
    private String  nombre;
    private PaisEntity  pais;

    public DepartamentoEntity(int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(PaisEntity.build());
    }

    public DepartamentoEntity(final int id,final String nombre, final PaisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);

    }
    public static final DepartamentoEntity build(final int id) {
        return new DepartamentoEntity(id);

    }
    protected static final DepartamentoEntity build() {
        return new DepartamentoEntity(ZERO);

    }
    public static final DepartamentoEntity build(final int id, final String nombre, final PaisEntity pais) {
        return new DepartamentoEntity(id, nombre, pais);

    }


    private final DepartamentoEntity setId(final int id) {
        this.id = id;
        return this;
    }

    private final DepartamentoEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    private final DepartamentoEntity setPais(final PaisEntity pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisEntity.build());
        return this;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PaisEntity getPais() {
        return pais;
    }
}
