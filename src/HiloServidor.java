import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread{

    DataInputStream fentrada;
    DataOutputStream fsalida;
    Socket socket = null;

    public HiloServidor(Socket socket) {
        this.socket = socket;

        try{
            fsalida = new DataOutputStream(socket.getOutputStream());
            fentrada = new DataInputStream(socket.getInputStream());

        }catch(IOException ex){
            System.out.println("ERROR al leer/enviar datos");
        }
    }


    public void run() {
        String cadena="";

        try{
            while(!cadena.trim().equals("*")){
                System.out.println("Comunico con: " + socket.toString());
                cadena = fentrada.readUTF();//obtener cadena
                fsalida.writeUTF(cadena.trim().toUpperCase()); //enviar mayusc
            }//fin while
            System.out.println("Fin con: " + socket.toString());
            //cierro streams y socket
            fentrada.close();
            fsalida.close();
            socket.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
