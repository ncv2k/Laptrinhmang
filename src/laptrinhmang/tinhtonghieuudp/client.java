/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tinhtonghieuudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vnncv
 */
public class client {
    public static void menu(){
        System.out.println("----------------------- MENU -----------------------");
        System.out.println("1. Tinh tong");
        System.out.println("2. Tinh hieu");
        System.out.println("3. Thoat");
        System.out.print("Lua chon cua ban: ");
    }
    
    public static String insert_num(){
        String return_Str;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so 1: ");
        return_Str = sc.nextLine() + " ";
        System.out.print("Nhap so 2: ");
        return_Str = return_Str + sc.nextLine() + " ";
        return return_Str;
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc = new Scanner(System.in);
        DatagramSocket myClient = new DatagramSocket();
        InetAddress ip= InetAddress.getByName("localhost");
        while(true){
            menu();
            String send_String;
            send_String=sc.nextLine() + " ";
            if(send_String.split(" ")[0].equals("3")) {
                byte[] send_byte = send_String.getBytes();
                DatagramPacket send_packet = new DatagramPacket(send_byte, send_byte.length, ip, 28);
                myClient.send(send_packet);
                return;
            };
            send_String = send_String + insert_num();
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
