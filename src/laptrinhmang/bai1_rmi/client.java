/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.bai1_rmi;
import java.util.*;
import java.rmi.*;

/**
 *
 * @author vnncv
 */
public class client {
    public static void main(String[] args) {
        try {
            System.out.println("\n Ket noi den may chu...");
            Calculator ca = (Calculator)Naming.lookup("rmi://localhost:2805/Calculator1");
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print(" a = ");
                int a = sc.nextInt();
                System.out.print(" b = ");
                int b = sc.nextInt();
                sc.nextLine();
                System.out.print("Ban muon thuc hien cong hay tru (+|-): ");
                String c=sc.nextLine();
                if(c.equals("+"))
                    System.out.println(" Ket qua: " + ca.addNum(a, b));
                else
                    System.out.println(" Ket qua: " + ca.subNum(a, b));
            }
        }catch (Exception e) {
            System.out.println(" Loi: "+ e);
        }
    }
}
