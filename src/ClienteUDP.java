
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramao
 */
public class ClienteUDP {

	public static void main(String args[]) throws Exception {

		try {
			InetAddress serverAddress;
			int port = 12345;
			Scanner scanner;

			DatagramSocket udpSocket = new DatagramSocket(12346);
			System.out.println("Running UDP Client at " + InetAddress.getLoopbackAddress().getHostAddress());

			scanner = new Scanner(System.in);
			serverAddress = InetAddress.getByName("127.0.0.1");
			while (true) {
				String entrada = scanner.nextLine();

				DatagramPacket p = new DatagramPacket(entrada.getBytes(), entrada.getBytes().length, serverAddress,
						port);

				udpSocket.send(p);

				//DatagramSocket udpSocket2 = new DatagramSocket(12345); eu recebo e envio da mesma porta, por isso não preciso criar outro

				String mensagem;

				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);

				udpSocket.receive(packet);
				mensagem = new String(packet.getData()).trim();

				System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + mensagem);

				if (entrada.equals("FIM")) {
					System.out.println("Cliente saindo...");
					break;
				}

			}

		} catch (SocketException ex) {
			Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);

		} catch (IOException ex) {
			Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
