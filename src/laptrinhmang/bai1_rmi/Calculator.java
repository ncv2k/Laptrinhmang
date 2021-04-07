/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.bai1_rmi;
import java.rmi.*;

public interface Calculator extends Remote{
    public int addNum(int a, int b) throws RemoteException;
    public int subNum(int a, int b) throws RemoteException;
}
