package com.redes;

import java.io.*;
import java.util.Scanner;

public class Cliente extends Conexion {


    public Cliente() throws IOException {super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        Scanner scanner = new Scanner(System.in);
        String mensaje = "";
        int contador = 0; // borrar
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(clienteSocket.getOutputStream());

            //Se enviarán dos mensajes
            /*for (int i = 0; i < 23; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                System.out.println("Ingrese mensajito: ");
                mensaje = scanner.nextLine();
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + mensaje + "\n");
            }*/
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            // para recibir mensaje del servidor ??
            System.out.println("Cliente iniciado\n");

            do {
                    System.out.println(entrada.readLine()); // para recibir mensaje del servidor

                System.out.println("Ingrese mensajito: ");
                mensaje = scanner.nextLine();
                salidaServidor.writeUTF("[Cliente]: " + mensaje + "\n");

            }while (true);

            //clienteSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
