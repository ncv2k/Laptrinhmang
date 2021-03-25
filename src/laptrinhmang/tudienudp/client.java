package laptrinhmang.tudienudp;

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
        System.out.println("------------- MENU -------------");
        System.out.print("Nhap tu hoac nhap full de hien thi tat ca (Nhap 0 de thoat): ");
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc = new Scanner(System.in);
        while(true){
            menu();
            String select = sc.nextLine();
            DatagramSocket  myclient= new DatagramSocket();
            String a= select + " ";
            byte[] send_data= a.getBytes();
            InetAddress ip= InetAddress.getByName("localhost");
            DatagramPacket send_pack= new DatagramPacket(send_data, send_data.length,ip, 28);
            myclient.send(send_pack);
            if(select.equals("0")){
                return;
            }
            byte[] receive_data= new byte[1024];
            DatagramPacket pack_receive= new DatagramPacket(receive_data, receive_data.length);
            myclient.receive(pack_receive);
            System.out.println(select + " - "+ new String(pack_receive.getData()));
        }
    }
}
