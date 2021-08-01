/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlyhocsinhUDP;

/**
 *
 * @author vnncv
 */
public class hocsinh {
    private String mahs, hoten, diachi, gioitinh;
    private float diem;

    public hocsinh(String mahs, String hoten, String diachi, String gioitinh, float diem) {
        this.mahs = mahs;
        this.hoten = hoten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.diem = diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
    public String hocbong(){
        return mahs + " - " + hoten + ": " +diem;
    }
    
}
