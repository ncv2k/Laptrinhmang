/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2RMI;
import java.rmi.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ncv
 */
public class Server extends UnicastRemoteObject{
    public Server() throws RemoteException{
        
    }
    public static void main(String[] args){
        try{
            nguyento nt =  new nguyentormi();
            LocateRegistry.createRegistry(2805).rebind("", new Server());
            System.out.println("Dang ky remote thanh cong");
            Naming.bind("rmi://127.0.0.1:2805/nguyento", nt);
            System.out.println("OK");
        } catch (Exception e){
            System.out.println("Loi " + e);
        }
    }
    
}
