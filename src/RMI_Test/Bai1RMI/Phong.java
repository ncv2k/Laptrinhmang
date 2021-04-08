/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Test.Bai1RMI;

import java.io.Serializable;

/**
 *
 * @author ncv
 */
public class Phong implements Serializable{
    private String Maphong, DiaChi, TinhTrang, loai;

    public Phong(String Maphong, String DiaChi, String TinhTrang, String loai) {
        this.Maphong = Maphong;
        this.DiaChi = DiaChi;
        this.TinhTrang = TinhTrang;
        this.loai = loai;
    }

    public String getMaphong() {
        return Maphong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public String getLoai() {
        return loai;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    public void Show(){
        System.out.println("Ma Phong: " + Maphong);
        System.out.println("Dia Chi: " + DiaChi);
        System.out.println("Tinh Tran: " + TinhTrang);
        System.out.println("Loai: " + loai);
    }
    
}
