import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int puerto = 6850;
        ServerSocket serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor establecido en puerto " + serverSocket.getLocalPort());

        while (true){
            Socket cliente = serverSocket.accept(); //server acepta conexión
            HiloServidor hilo = new HiloServidor(cliente); // acciones con cliente definidas en clase HiloServidor
            hilo.start(); //realiza acciones
        }
    }
}