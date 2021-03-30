/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.quanlinganhangudp;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author vnncv
 */
public class server {
    private static String history="";
    private static int balance = 0;
    
    private static String check_Balance(){
        return "Balance: "+balance;
    }
    
    private static String deposit(int x){
        balance +=x;
        history = history + "Deposit " + x + "/0";
        return "Successful deposit " + x;
    }
    
    private static String withdrawal(int x){
        if(x>balance){
            return "Insufficient balance";
        }
        balance -= x;
        history = history + "Withdrawal " + x + "/0";
        return "Successful withdrawal " + x;
    }
    
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket myServer = new DatagramSocket(28);
        byte[] byte_receive = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(byte_receive, byte_receive.length);
        while(true){
            myServer.receive(pack_receive);
            int chose = parseInt(new String(pack_receive.getData()).split(" ")[0]);
            System.out.println(chose);
            byte[] byte_send = new byte[1024];
            switch(chose){
                case 1: myServer.receive(pack_receive); byte_send = deposit(parseInt(new String(pack_receive.getData()).split(" ")[0])).getBytes(); break;
                case 2: myServer.receive(pack_receive); byte_send = withdrawal(parseInt(new String(pack_receive.getData()).split(" ")[0])).getBytes(); break;
                case 3: byte_send = check_Balance().getBytes(); break;
                case 4: byte_send = history.getBytes(); break;
                case 5: return;
                default: return;
            }
            DatagramPacket pack_send = new DatagramPacket(byte_send, byte_send.length, pack_receive.getAddress(), pack_receive.getPort());
            myServer.send(pack_send);
        }
    }
    
}
