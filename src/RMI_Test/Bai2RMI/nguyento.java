/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Test.Bai2RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ncv
 */
public interface nguyento extends Remote, Serializable{
    public boolean check(int n, int i) throws RemoteException;
    public String songuyento(int num) throws RemoteException;
}
