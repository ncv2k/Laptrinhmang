/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAgain.bai2TCP;

/**
 *
 * @author vnncv
 */
public class Nha {
    private int sonha, giaban;
    boolean tinhtrang;

    public Nha(int sonha, int giaban, boolean tinhtrang) {
        this.sonha = sonha;
        this.giaban = giaban;
        this.tinhtrang = tinhtrang;
    }

    public int getSonha() {
        return sonha;
    }

    public boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
    public String toString(){
        return "So nha: " + sonha +"\nGia ban: " + giaban + "\nTinh trang: " + tinhtrang +"\n---------------------------------\n";
    }
}
