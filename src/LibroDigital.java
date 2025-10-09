public class LibroDigital extends Libro {

    private double pesoArchivo; // en MB
    private boolean disponible;

    public LibroDigital(String titulo, String autor, double precio, int cantidad, double pesoArchivo, boolean disponible) {
        super(titulo, autor, precio, cantidad);
        this.pesoArchivo = pesoArchivo;
        this.disponible = disponible;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(double pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void prestar() {
        if (getDisponible()) {
            setDisponible(false);
            System.out.println("Libro digital prestado con éxito.");
        } else {
            System.out.println("No se puede prestar. El libro no está disponible.");
        }
    }

    public void devolver() {
        setDisponible(true);
        System.out.println("Libro digital devuelto correctamente.");
    }

    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso del archivo: " + pesoArchivo + " MB");
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
}
