/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author ramao
 */
public class ServidorUDP {

    public static void main(String[] args) throws Exception {
    	
        DatagramSocket udpSocket = new DatagramSocket(12345);
        System.out.println("Servidor executando no endereço " + InetAddress.getLoopbackAddress().getHostAddress());
        
        String mensagem;
        
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        
        
        while(true) {
        	udpSocket.receive(packet);
            mensagem = new String(packet.getData()).trim();
            
            System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + mensagem);
            
            Scanner scanner = new Scanner(System.in);
            String entrada = scanner.nextLine();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int port = 12346;
            
            DatagramPacket p = new DatagramPacket(entrada.getBytes(), entrada.getBytes().length, serverAddress, port);

            udpSocket.send(p);
            
            if (entrada.contentEquals("FIM")) {
				System.out.println("Fechando servidor...");
				break;
			}
        }
        
        
    }
}
