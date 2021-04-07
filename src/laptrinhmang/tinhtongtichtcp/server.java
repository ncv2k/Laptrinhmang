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
    
    private static int cal(int a, int b, int c){
        return c==1?a + b:a*b;
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
            } else {
                os.writeInt(cal(num1, num2, pheptinh));
            }
            
        }
    }
}
