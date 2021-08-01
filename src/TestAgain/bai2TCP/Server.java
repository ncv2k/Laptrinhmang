/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai2TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vnncv
 */
public class Server {
    
    public static void main(String[] args){
        try{
            ServerSocket myServer = new ServerSocket(2805);
            Socket acp = myServer.accept();
            DataOutputStream dos = new DataOutputStream(acp.getOutputStream());
            DataInputStream dis = new DataInputStream(acp.getInputStream());
            while (true) {                
                int chose = dis.readInt();
                System.out.println("Chose: " + chose);
            }
        } catch (Exception e){
            System.out.println("Loi: " + e);
        }
    }
}
