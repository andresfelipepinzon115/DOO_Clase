public class DepartamentoDomain{
    private int id;
    private String nombre;

    public DepartamentoDomain(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public static final DepartamentoDomain crear(final int id, final String nombre){
        return new DepartamentoDomain(int id, String nombre);
    }

    private DepartamentoDomain(){
        setNombre(Text.helper.EMPTY);
        setDepartamento(PaisDomain.crear());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setId(int id) {
        this.id = id;
    }
}