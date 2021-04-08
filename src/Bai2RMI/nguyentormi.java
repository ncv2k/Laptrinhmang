/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2RMI;

/**
 *
 * @author ncv
 */
public class nguyentormi implements nguyento{
    public nguyentormi(){
        
    }
    public boolean check(int n, int i){
        if(i>n/2) return true;
        return (n%i==0)?false:check(n,i+1);
    }
    
    public String songuyento(int num){
        String snt="";
        for(int i=1; i<=num; i++){
            if(check(i, 2 )) snt = snt + i +" ";
        }
        return snt;
    }
}
