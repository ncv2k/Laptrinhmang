/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tinhtonghieuudp;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author vnncv
 */
public class server {
    private static int cal(int a, int b, int c){
        return (c==1)?a+b:a-b;
    }
    
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket myServer = new DatagramSocket(28);
        byte[] receive_byte = new byte[1024];
        DatagramPacket receive_pack = new DatagramPacket(receive_byte, receive_byte.length);
        while(true){
            myServer.receive(receive_pack);
            String[] receve_data = new String(receive_pack.getData()).split(" ");
            int select = parseInt(receve_data[0]);
            if (select==3) {
                System.out.println("Client yeu cau dong!!!");
                return;
            }
            int num1 = parseInt(receve_data[1]);
            int num2 = parseInt(receve_data[2]);
            int kq = cal(num1, num2, select);
            
            String send_data = num1 + " " +(select==1?"+":"-") + " " + num2 + " = " + kq;
            System.out.println(send_data);
            byte[] send_byte = send_data.getBytes();
            DatagramPacket send_pack = new DatagramPacket(send_byte, send_byte.length, receive_pack.getAddress(), receive_pack.getPort());
            myServer.send(send_pack);
        }
        
    }
}
