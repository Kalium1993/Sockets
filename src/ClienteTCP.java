/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramao
 */
public class ClienteTCP {

    public static void main(String args[]) {

        try {
            //Criando socket com endereço e porta do processo servidor
            Socket cliente = new Socket("127.0.0.1", 12345);
            
            //Criando bufferedreader para possibilitar a leitura de dados a partir do cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            
            //Criando printwriter para possibilitar o envio de dados para o servidor
            PrintWriter saida = new PrintWriter(cliente.getOutputStream(),true); // Passa o OutputStream do socket para o PrintWriter.
            
            // Enviando o dado para o servidor a partir da saida criado.
            saida.println("Mensagem do Cliente!");
            
            
            //encerrando conexões
            entrada.close();
            saida.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
