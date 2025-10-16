import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int contadorDigital = 1;
    static int contadorImpreso = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("------ MENU------");
            System.out.println("1. Agregar libro Digital");
            System.out.println("2. Agregar libro Impreso");
            System.out.println("3. Buscar libro por titulo");
            System.out.println("4. Lista de libros");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    String codigoD = "LD00" + contadorDigital++;
                    System.out.print("Título: ");
                    String td = sc.nextLine();
                    System.out.print("Autor: ");
                    String ad = sc.nextLine();
                    System.out.print("Precio: ");
                    double pd = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cd = sc.nextInt();
                    System.out.print("Tamaño archivo (MB): ");
                    double peso = sc.nextDouble();
                    libros.add(new LibroDigital(codigoD, td, ad, pd, cd, peso));
                    System.out.println("Libro Digital agregado con código " + codigoD);
                    break;

                case 2:
                    String codigoI = "LF00" + contadorImpreso++;
                    System.out.print("Título: ");
                    String ti = sc.nextLine();
                    System.out.print("Autor: ");
                    String ai = sc.nextLine();
                    System.out.print("Precio: ");
                    double pi = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int ci = sc.nextInt();
                    System.out.print("Peso fisico (g): ");
                    double pf = sc.nextDouble();
                    System.out.print("Numero de ejemplares: ");
                    int ne = sc.nextInt();
                    libros.add(new LibroImpreso(codigoI, ti, ai, pi, ci, pf, ne));
                    System.out.println("Libro Impreso agregado con codigo " + codigoI);
                    break;

                case 3:
                    System.out.print("Ingrese el titulo del libro: ");
                    String bus = sc.nextLine();
                    boolean ok = false;
                    for (Libro l : libros) {
                        if (l.getTitulo().equalsIgnoreCase(bus)) {
                            l.mostrarLibro();
                            ok = true;
                        }
                    }
                    if (!ok) System.out.println("No encontrado.");
                    break;

                case 4:
                    System.out.println("------ LISTA DE LIBROS ------");
                    for (Libro l : libros) l.mostrarLibro();
                    break;

                case 5:
                    System.out.println("gracias");
                    break;

                default:
                    System.out.println("Opción invalida");
            }
        }
        sc.close();
    }
}