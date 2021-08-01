/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai2TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vnncv
 */
public class Client {
    static Scanner sc = new Scanner(System.in);
    public static String timkiem(){
        String result;
        int c;
        do{
            System.out.println("1. Tim kiem theo so nha");
            System.out.println("2. Tim kiem theo tinh trang");
            System.out.print("Lua chon: ");
            c = sc.nextInt();
        }while(c!=1&&c!=2);
        if(c==1){
            System.out.print("Nhap so nha: ");
            result = "1" + sc.nextInt();
        } else {
            System.out.println("1. Nha con trong");
            System.out.println("2. Nha khong con trong");
            System.out.print("Lua chon: ");
            result = "2" + sc.nextInt();
        }
        return result;
    }
    
    
    public static void menu(){
        System.out.println("--------------- QUAN LY NHA ---------------");
        System.out.println("1. Tim kiem");
        System.out.println("2. Thue nha");
        System.out.println("3. Them nha");
        System.out.println("4. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
    }
    
    public static void main(String[] args) {
        try {
            Socket myClient = new Socket("127.0.0.1", 2805);
            
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            int chose;
            while(true){
                menu();
                chose = sc.nextInt();
                dos.writeInt(chose);
                switch(chose){
                    case 1:{
                        dos.writeChars(timkiem());
                        System.out.println(dis.readUTF());
                    }
                    case 2:{
                        
                    }
                    case 3:{
                        
                    }
                    case 4:{
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
    }
}
