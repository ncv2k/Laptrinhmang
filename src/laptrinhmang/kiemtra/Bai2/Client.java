/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.kiemtra.Bai2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author ncv
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc = new Scanner(System.in);
        DatagramSocket myClient = new DatagramSocket();
        InetAddress ip= InetAddress.getByName("localhost");
        while(true){
            System.out.print("Nhap so: ");
            String send_String;
            send_String=sc.nextLine() + " ";
            byte[] send_byte = send_String.getBytes();
            DatagramPacket send_packet = new DatagramPacket(send_byte, send_byte.length, ip, 28);
            myClient.send(send_packet);
            
            byte[] receive_byte = new byte[1024];
            DatagramPacket receive_packet = new DatagramPacket(receive_byte, receive_byte.length);
            myClient.receive(receive_packet);
            System.out.println("KQ: " + new String(receive_packet.getData()));
        }
    }
}
