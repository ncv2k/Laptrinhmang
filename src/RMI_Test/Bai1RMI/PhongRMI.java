/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Test.Bai1RMI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author ncv
 */
public class PhongRMI implements PhongItf, Serializable{
    ArrayList<Phong> listPhong;
    public void init(){
        listPhong = new ArrayList<Phong>();
        listPhong.add(new Phong("01", "Thanh Xuan", "Trong", "2"));
        listPhong.add(new Phong("02", "Ha Dong", "Khong Trong", "1"));
        listPhong.add(new Phong("03", "Thanh Xuan", "Trong", "2"));
        listPhong.add(new Phong("04", "Ha Dong", "Trong", "1"));
        listPhong.add(new Phong("05", "Thanh Xuan", "Khong Trong", "1"));
        listPhong.add(new Phong("06", "Dong Da", "Trong", "2"));
    }
    public void Search() {
        Scanner sc = new Scanner(System.in);
        int c;
        String nd;
        while(true){
            System.out.println("TIM KIEM PHONG");
            System.out.println("1. Tim kiem theo Ma Phong");
            System.out.println("2. Tim kiem theo Loai Phong");
            System.out.println("3. Tim kiem theo dia chi");
            System.out.println("4. Thoat");
            System.out.print("Nhap lua chon: ");
            c = sc.nextInt();
            sc.nextLine();
            if(c==4) return;
            switch(c){
                case 1: 
                    System.out.print("Nhap Ma Phong: ");
                    nd = sc.nextLine();
                    for(Phong tmp: listPhong){
                        if(tmp.getMaphong().equals(nd)){
                            tmp.Show();
                            sc.nextLine();
                            return;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhap Loai Phong: ");
                    nd = sc.nextLine();
                    for(Phong tmp: listPhong){
                        if(tmp.getLoai().equals(nd)){
                            tmp.Show();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap Dia Chi: ");
                    nd = sc.nextLine();
                    for(Phong tmp: listPhong){
                        if(tmp.getDiaChi().equals(nd)){
                            tmp.Show();
                        }
                    }
                    break;
                default: continue;
            }
        }
        
        
    }

    @Override
    public void ShowAll() {
        System.out.println("Tat ca cac phong\n");
        for(Phong tmp: listPhong){
            tmp.Show();
            System.out.println("----------------------");
        }
    }

    @Override
    public void Thue() {
        String Maphong;
        Scanner sc = new Scanner(System.in);
        System.out.println("THUE PHONG");
        System.out.println("Nhap Ma Phong muon thue");
        Maphong = sc.nextLine();
        for(Phong tmp: listPhong){
            if(tmp.getMaphong().equals(Maphong)) {
                if(tmp.getTinhTrang().equals("Khong Trong")){
                    System.out.println("Phong da duoc thue, vui long tim phong khac");
                    sc.nextLine();
                    return;
                }
                tmp.setTinhTrang("Khong Trong");
                System.out.println("Thue phong Thanh Cong");
                sc.nextLine();
                return;
            }
        }
        System.out.println("Khong tim thay phong ma " + Maphong);
    }
    
}
