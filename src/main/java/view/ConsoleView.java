package view;

public class ConsoleView {
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarError(String mensaje){
        System.err.println(mensaje);
    }
}
