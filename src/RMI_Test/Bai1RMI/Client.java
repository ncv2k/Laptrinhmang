/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Test.Bai1RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ncv
 */
public class Client {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ket noi toi Server");
            PhongItf Phong = (PhongItf)Naming.lookup("rmi://localhost:2805/QLPhong");
            Phong.init();
            int c;
            while(true){
                System.out.println("--------- QUAN LY PHONG ---------");
                System.out.println("1. Tim phong");
                System.out.println("2. Hien thi tat ca phong");
                System.out.println("3. Thue Phong");
                System.out.println("4. Thoat");
                System.out.print("Nhap lua chon:");
                c= sc.nextInt();
                switch(c){
                    case 1: Phong.Search(); break;
                    case 2: Phong.ShowAll(); break;
                    case 3: Phong.Thue(); break;
                    case 4: return;
                    default: continue;
                }
            }
        } catch (Exception e) {
            System.out.println(" Loi: "+ e);
        }
    }
}
