/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.quanlinganhangtcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vnncv
 */
public class client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc = new Scanner(System.in);
        DatagramSocket myClient = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        String chose;
        while(true){
            System.out.println("---------------------- MENU ----------------------");
            System.out.println("1. Nap tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("3. Lich su giao dich");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            chose = sc.nextLine() + " ";
            DatagramPacket pack_send = new DatagramPacket(chose.getBytes(), chose.getBytes().length, ip, 28);
            myClient.send(pack_send);
            if(chose.equals("5 ")) return;
            if(chose.equals("1 ")||chose.equals("2 ")){
                System.out.print("Nhap so tien: ");
                chose = sc.nextLine() + " ";
                pack_send = new DatagramPacket(chose.getBytes(), chose.getBytes().length, ip, 28);
                myClient.send(pack_send);
            }
            byte[] byte_receive = new byte[1024];
            DatagramPacket pack_receive = new DatagramPacket(byte_receive, byte_receive.length);
            myClient.receive(pack_receive);
            System.out.println(new String(pack_receive.getData()));
        }
    }
}
