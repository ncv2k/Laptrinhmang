/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.bai1_rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

/**
 *
 * @author vnncv
 */
public class server { 
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2805);
            Calculator ca = new CalculatorImpl();
            System.out.println("\n Dang ky remote thanh cong...");
            Naming.bind("rmi://127.0.0.1:2805/Calculator1", ca);
            System.out.println("\n Tao doi tuong rmi thanh cong...");   
        }catch (Exception e) {
            System.out.println(" Loi: " + e);
        }  
    }
}

