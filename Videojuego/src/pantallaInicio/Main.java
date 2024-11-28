package pantallaInicio;

public class Main {
    public static void main(String[] args) {
        // Inicializar el controlador
        Controlador controlador = new Controlador();
        controlador.cambiarPantalla("PantallaInicio");
        System.out.println("Pantalla de inicio mostrada");
    }
}