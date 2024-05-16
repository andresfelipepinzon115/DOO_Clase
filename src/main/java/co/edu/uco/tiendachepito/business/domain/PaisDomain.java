public class PaisDomain{
    private int id;
    private String nombre;

    public PaisDomain(final int id, final String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static final PaisDomain crear(final int id, final String nombre){
        return new PaisDomain(int id, String nombre)
    }

    private PaisDomain(){
        setNombre(Text.helper.EMPTY);
        setPais(PaisDomain.crear());
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