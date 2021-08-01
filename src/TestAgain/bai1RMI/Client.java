/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai1RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author vnncv
 */
public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException{
        Scanner sc = new Scanner(System.in);
        Boi a = (Boi)Naming.lookup("rmi://127.0.0.1:2805/Boi");
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        System.out.print("Nhap boi toi da: ");
        int max = sc.nextInt();
        a.boi(n, max);
    }
}
