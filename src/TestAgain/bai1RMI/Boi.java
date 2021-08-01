/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai1RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vnncv
 */
public interface Boi extends Remote{
    public void boi(int n, int max) throws RemoteException;
}
