/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tinhtongtichtcp;

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
    
    public static String pheptinhtoString(int a){
        return (a==1)?"+":"x";
    }
    
    public static void main(String[] args) throws IOException{
        Socket myclient = new Socket("127.0.0.1", 28);
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = new DataInputStream(myclient.getInputStream());
        DataOutputStream dos = new DataOutputStream(myclient.getOutputStream());
        int num1, num2, pheptinh;
        while(true){
            System.out.println("------------ MENU ------------");
            System.out.print("Nhap so 1:");
            dos.writeInt(num1 = sc.nextInt());
            System.out.print("Nhap so 2:");
            dos.writeInt(num2 = sc.nextInt());
            do{
                System.out.print("Ban muon + hay * (1|2). Nhap 0 de thoat:");
                pheptinh = sc.nextInt();
                
            }while(pheptinh!=1&&pheptinh!=2);
            dos.writeInt(pheptinh);
            if(pheptinh == 0){
                return;
            }
            System.out.println("Ket qua: " + num1 + pheptinhtoString(pheptinh) + num2 + "= " + dis.readInt());
        }
    }
}
