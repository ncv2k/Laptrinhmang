/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang.tinhtongtichtcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vnncv
 */
public class server {
    
    private static int sum(int a, int b){
        return a + b;
    }
    
    private static int mul(int a, int b){
        return a * b;
    }
    
    public static void main(String[] args) throws IOException{
        ServerSocket myserver = new ServerSocket(28);
        Socket acp = myserver.accept();
        DataInputStream is = new DataInputStream(acp.getInputStream());
        DataOutputStream os = new DataOutputStream(acp.getOutputStream());
        while(true){     
            int num1 = is.readInt();
            int num2 = is.readInt();
            int pheptinh = is.readInt();
            if(pheptinh == 0){
                return;
            }
            if(pheptinh == 1){
                os.writeInt(sum(num1, num2));
            }
            if (pheptinh == 2){
                os.writeInt(mul(num1, num2));
            }
        }
    }
}
