public class LibroDigital extends Libro {

    private double pesoArchivo;
    private boolean disponible;

    public LibroDigital(String codigo, String titulo, String autor, double precio, int cantidad, double pesoArchivo) {
        super(codigo, titulo, autor, precio, cantidad);
        this.pesoArchivo = pesoArchivo;
        this.disponible = true;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro digital prestado correctamente.");
        } else {
            System.out.println("El libro digital no se encuentra disponible");
        }
    }

    public void devolver() {
        disponible = true;
        System.out.println("el libro fue devuelto correctamente");
    }

    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso del archivo: " + pesoArchivo + " MB");
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
}
