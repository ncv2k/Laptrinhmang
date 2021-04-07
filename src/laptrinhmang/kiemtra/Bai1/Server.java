/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.kiemtra.Bai1;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

/**
 *
 * @author ncv
 */
public class Server {
    public static void main(String[] args){
        try {
            PhongItf ql = new PhongRMI();
            LocateRegistry.createRegistry(2805);
            System.out.println("\n Dang ky remote thanh cong...");
            Naming.bind("rmi://127.0.0.1:2805/QLPhong", ql);
            System.out.println("\n Tao doi tuong rmi thanh cong...");   
        }catch (Exception e) {
            System.out.println(" Loi: " + e);
        }  
    }
}
