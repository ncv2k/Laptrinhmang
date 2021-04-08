/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Test.Bai2RMI;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author ncv
 */
public class Client {

    public static void main(String[] args) {
        try {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Ket noi den Server...");
                nguyento nt = (nguyento) Naming.lookup("rmi://127.0.0.1:2805/nguyento");
                System.out.print("Nhap n:");
                int n = sc.nextInt();
                System.out.println("Cac so nguyen to nho hon " + n + " la: " + nt.songuyento(n));
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
    }
}
