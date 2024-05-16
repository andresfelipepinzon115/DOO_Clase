package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

import static co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper.ZERO;

public final class PaisEntity {
    private int id;
    private String  nombre;

    public PaisEntity( final int id) {
        setNombre(TextHelper.EMPTY);
    }

    public PaisEntity(final int id,  final String nombre) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }
    public static final PaisEntity build(final int id) {
        return new PaisEntity(id);
    }
    protected static final PaisEntity build() {
        return new PaisEntity(ZERO);
    }

    public static final PaisEntity build(final int id, final String nombre) {
        return new PaisEntity(id, nombre);
    }



    private PaisEntity setId(final int id) {
        this.id = id;
        return this;
    }

    private PaisEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
