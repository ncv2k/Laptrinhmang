/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tong2sotcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vnncv
 */
public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket  myServer  = new ServerSocket(28);
        Socket  clientSocket = myServer.accept();
        DataInputStream is = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
        while (true){
            os.write(is.read() + is.read());
        }
    }
}
