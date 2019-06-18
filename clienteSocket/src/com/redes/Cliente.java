package com.redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

            // para recibir mensaje del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            System.out.println("Cliente iniciado!\n");
            System.out.println(entrada.readLine());

            do {
                System.out.println("\nIngrese mensajito: ");
                mensaje = scanner.nextLine();
                salidaServidor.writeUTF( mensaje + "\n");
                System.out.println("Esperando respuesta...");
                System.out.println(entrada.readLine()); // para recibir mensaje del servidor


            }while (true);

            //clienteSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
