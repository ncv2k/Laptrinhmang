/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tong2sotcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vnncv
 */
public class client {
    public static void main(String[] args) throws IOException{
        Socket mySocket = new Socket ("127.0.0.1",28);
        DataOutputStream os = new DataOutputStream(mySocket.getOutputStream());
        DataInputStream is = new DataInputStream(mySocket.getInputStream());
        System.out.print("Nhap 2 so nguyen duong: ");
        Scanner sc = new Scanner(System.in);
        os.write(sc.nextInt());
        os.write(sc.nextInt());
        System.out.println(is.read());
    }
}
