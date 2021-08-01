/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai1RMI;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author vnncv
 */
public class BoiRMI implements Boi, Serializable {

    @Override
    public void boi(int n, int max) {
        System.out.print("Cac boi nho hon " + max + " cua " + n + ":");
        for (int i = 2; n * i < max; i++) {
            System.out.print(n * i + " ");
        }
    }
}
