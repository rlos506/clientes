/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rouse
 */
public class UDPCliente {
    public static void main(String args[]){
DatagramSocket clientSocket;
BufferedReader inFromUser;
InetAddress IPAddress;
String sentence;
String host = "127.0.0.1";
int port = 12000;
inFromUser = new BufferedReader(new InputStreamReader(System.in));
      
        try {
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName(host);
            byte[] sendData = new byte[8];
            byte[] receiveData = new byte[8];
            System.out.println("CLIENTE:");
            //lee lo que hay en el buffer y lo almacena en la variable String sentence
            sentence = inFromUser.readLine();
            //almacena cada en el vector de tipo byte cada caracter representado en bytes
            sendData = sentence.getBytes();
            //para enviar la informacion con el protocolo udp se usa la clase DatagramPacket para poder enviar paquetes a traves de la red
            // donde se le pasa el vector que contiene el flujo de datos en byte, el tama;o del vector la direccion ip y el numero de puerto
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
           
            //cierra el socket cliente
            clientSocket.close();
            
            
        } catch (UnknownHostException e) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        }
         catch (IOException ex) {
             System.out.println("Error de E/S en " + host + ":" + port);
        }
    }// Main
 
}
