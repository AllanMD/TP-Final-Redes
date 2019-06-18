package com.redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Servidor extends Conexion{

    public Servidor() throws IOException {super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando un cliente..."); //Esperando conexión

            clienteSocket = serverSocket.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Se conectó un cliente!\n");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(clienteSocket.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada\n"); // borrado por ahora // mejor no

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String mensaje = "";
            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
                salidaCliente.writeUTF("[Server]: Mensaje recibido \n");
                //System.out.println("Ingrese mensajito: ");
                //mensaje = scanner.nextLine();
                //salidaCliente.writeUTF("[Server]: \n" + mensaje);
            }

            System.out.println("Fin de la conexión");

            serverSocket.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
