/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai1RMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author vnncv
 */
public class Server extends UnicastRemoteObject{
    public Server() throws RemoteException{
        
    }
    public static void main(String[] args) {
        try{
            Boi a = new BoiRMI();
            LocateRegistry.createRegistry(2805).rebind("", new Server());
            Naming.bind("rmi://127.0.0.1:2805/Boi", a);
        }catch(Exception e){
            System.out.println("Loi: " + e);
        }
   }
}
