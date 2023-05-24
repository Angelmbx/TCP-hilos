import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6850;

        //creo socket cliente
        Socket cliente = new Socket(host, puerto);

        //output stream to Server
        DataOutputStream fsalida = new DataOutputStream(cliente.getOutputStream());

        //input stream from Server
        DataInputStream fentrada = new DataInputStream(cliente.getInputStream());

        //Standar input stream
        Scanner sc = new Scanner(System.in);


        String cadena, cadenaMayus = "";
        System.out.println("Introduce cadena: ");
        cadena = sc.nextLine(); //recibe texto
        while (cadena != null){
            fsalida.writeUTF(cadena); //envio cadena al server
            cadenaMayus = fentrada.readUTF(); // cadena mayus vale lo que envie el server
            System.out.println("En mayus: " + cadenaMayus);
            System.out.println("Introduce cadena");
            cadena = sc.nextLine();//recibe texto
        }


        //close streams and socket
        fentrada.close();
        fsalida.close();
        sc.close();
        cliente.close();
    }

}
