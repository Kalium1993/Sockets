/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramao
 */
public class ServidorTCP {
     
    public static void main(String args[]){
        try {
            //Criando o serversocket que ficará escutando a porta 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Servidor iniciado na porta 12345");
             
            //Espera na porta por uma conexão com o cliente
            Socket cliente = server.accept(); //Gera um socket que representa a conexão com o cliente
            System.out.println("Cliente conectado do IP "+cliente.getInetAddress().
                    getHostAddress());
            
            //Criando bufferedreader para possibilitar a leitura de dados a partir do servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            
            //Criando printwriter para possibilitar o envio de dados para o cliente
            PrintWriter saida = new PrintWriter(cliente.getOutputStream(),true);
            
            //Recebendo mensagem do cliente a partir da "entrada" criada
            String mensagemRecebida = entrada.readLine();
            
            System.out.println(mensagemRecebida);
            
            //encerrando conexões
            entrada.close();
            saida.close();
            cliente.close();
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
