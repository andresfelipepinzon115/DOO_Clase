package co.edu.uco.tiendachepito.entity;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import org.springframework.context.annotation.Import;
import static co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper.ZERO;


public  final class CiudadEntity {
    private int id;
    private String  nombre;
    private DepartamentoEntity departamento;

    private CiudadEntity( final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setDepartamento(departamento.build());
    }

    private CiudadEntity( final DepartamentoEntity departamento, final  int id, final String nombre) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public static final CiudadEntity build( final int id) {
        return new CiudadEntity(id);
    }

    public static final CiudadEntity build( final int  id, final String nombre, final DepartamentoEntity departamento) {
        return new CiudadEntity(departamento, id, nombre);
    }
    private final  CiudadEntity setId(final int id) {
        this.id = id;
        return this;
    }

    private  final CiudadEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    private final  CiudadEntity setDepartamento(final DepartamentoEntity departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, DepartamentoEntity.build());
        return this;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }
    protected static  final CiudadEntity build() {
        return new CiudadEntity(ZERO);
    }
}
