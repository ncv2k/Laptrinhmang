/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.kiemtra.Bai2;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



/**
 *
 * @author ncv
 */
public class server {
    public static boolean check(int a, int i){
        if(i>a/2) return true;
        return (a%i==0)?false:check(a,i+1);
    }
    
    public static String songuyento(int num){
        String snt="";
        for(int i=2; i<=num; i++){
            if(check(i, 2 )) snt = snt + i +" ";
        }
        return snt;
    }
    
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket myServer = new DatagramSocket(28);
        byte[] receive_byte = new byte[1024];
        DatagramPacket receive_pack = new DatagramPacket(receive_byte, receive_byte.length);
        while (true){
            myServer.receive(receive_pack);
            String[] receve_data = new String(receive_pack.getData()).split(" ");
            int num = parseInt(receve_data[0]);
            String send_data = songuyento(num);
            byte[] send_byte = send_data.getBytes();
            DatagramPacket send_pack = new DatagramPacket(send_byte, send_byte.length, receive_pack.getAddress(), receive_pack.getPort());
            myServer.send(send_pack);
        }
    }
}
