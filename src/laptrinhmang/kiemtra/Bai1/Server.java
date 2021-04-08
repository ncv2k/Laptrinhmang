/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.kiemtra.Bai1;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

/**
 *
 * @author ncv
 */
public class Server extends UnicastRemoteObject {
    public Server() throws RemoteException{
        
    }
    public static void main(String[] args){
        try {
            PhongItf ql = new PhongRMI();
            LocateRegistry.createRegistry(2805).rebind("", new Server());
            System.out.println("\n Dang ky remote thanh cong...");
            Naming.bind("rmi://127.0.0.1:2805/QLPhong", ql);
            System.out.println("\n Tao doi tuong rmi thanh cong...");   
        }catch (Exception e) {
            System.out.println(" Loi: " + e);
        }  
    }
}
