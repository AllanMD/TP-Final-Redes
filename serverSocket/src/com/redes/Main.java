package com.redes;

import java.io.IOException;

// https://www.programarya.com/Cursos-Avanzados/Java/Sockets // este proyecto esta hecho con este
//http://codigoprogramacion.com/cursos/java/103-sockets-en-java-con-cliente-y-servidor.html#.XPWv6rh7m1t
//https://www.solvetic.com/tutoriales/article/2657-como-abrir-o-cerrar-un-puerto-con-el-firewall-en-windows-10/ -->
// creo que es para esto: g) Verificar que el firewall tenga en inbound rules los permisos correctos para la entrada y salida de data.
// https://rootear.com/windows/activa-telnet-w10

//https://www.programacion.com.py/escritorio/java-escritorio/sockets-en-java-udp-y-tcp // socket tcp y sockets udp// diferencias
public class Main {

    public static void main(String[] args) {

        Servidor serv = null;
        try {
            serv = new Servidor();//Se crea el servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor

    }


    // lo q hace este proyecto es levantar el servidor, que se levanta en el puerto 3000 y espera una conexion
    // esta conexion puede ser del telnet, ( que emula un cliente) , o del otro proyecto clienteSocket, que es el cliente real


}
