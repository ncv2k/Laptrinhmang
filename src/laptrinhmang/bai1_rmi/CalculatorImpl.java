/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.bai1_rmi;

/**
 *
 * @author vnncv
 */
import java.rmi.*;
import java.rmi.server.*;
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    public CalculatorImpl() throws RemoteException {
    }

    @Override
    public int addNum(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int subNum(int a, int b) throws RemoteException {
        return a-b;
    }
}