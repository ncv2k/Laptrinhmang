/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlyhocsinhUDP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author vnncv
 */
public class Server {

    static ArrayList<hocsinh> lisths = new ArrayList<hocsinh>();

    public static void importdata() {
        try {
            FileReader fr = new FileReader("hocsinh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                String[] data = line.split("\\$");
                lisths.add(new hocsinh(data[0], data[1], data[2], data[3], Float.parseFloat(data[4])));
                line=br.readLine();
            }
            System.out.println("Nhap data thanh cong");
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
    }

    public static void main(String[] args) throws SocketException, IOException {
        importdata();
        DatagramSocket myServer = new DatagramSocket(2805);
        byte[] byte_receive = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(byte_receive, byte_receive.length);
        myServer.receive(pack_receive);
        String data_receive = new String(pack_receive.getData()).split("|")[0];
        if(data_receive.equals("1")){
            
        
        } 
    }
}
