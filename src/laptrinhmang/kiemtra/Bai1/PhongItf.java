/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.kiemtra.Bai1;

import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author ncv
 */
public interface PhongItf extends Remote{
    public void Search();
    public void ShowAll();
    public void Thue();
    
}
