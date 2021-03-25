package laptrinhmang.tudienudp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class server {
    static ArrayList<word> arr_dic = new ArrayList<>();
    
    private static void import_dic() throws FileNotFoundException, IOException{
        BufferedReader br= new BufferedReader(new FileReader("tudien.txt"));
        String b= br.readLine();
        while(b!=null){
                String dic[] = b.split("\\$", 2);
                arr_dic.add(new word(dic[0], dic[1]));
                b= br.readLine();
            }
            br.close();
    }
    
    private static String translate(String EN){
        String VN;
        for(word temp:arr_dic){
            if (temp.getEN().equals(EN)){
                VN = temp.getVN();
                return VN;
            }
        }
        return "Không có dữ liệu";
    }
    
    private static String full() throws FileNotFoundException, IOException{
        String VN;
        String kq="";
        for(word temp:arr_dic){
            kq=kq + temp.getEN() + " - " + temp.getVN() + "\n";
        }
        return kq;
    }
    
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket myServer = new DatagramSocket(28);
        import_dic();
        while (true){
            byte[] data_receive = new byte[1024];
            DatagramPacket pack_receive = new DatagramPacket(data_receive, data_receive.length);
            myServer.receive(pack_receive);
            String receive = new String(pack_receive.getData()).split(" ")[0];
            System.out.println("Server nhan |" + receive + "|");
            byte[] data_send = new byte[1024];
            if (receive.equals("0")){
                return;
            }
            if (receive.equals("full")){         
                //Hien thi tat ca
                data_send = full().getBytes();
                DatagramPacket pack_send = new DatagramPacket(data_send, data_send.length, pack_receive.getAddress(), pack_receive.getPort());
                myServer.send(pack_send);
                continue;
            }
            // Dich tu da nhap
            data_send = translate(receive).getBytes();
            DatagramPacket pack_send = new DatagramPacket(data_send, data_send.length, pack_receive.getAddress(), pack_receive.getPort());
            myServer.send(pack_send);
        }
        
    }
}
