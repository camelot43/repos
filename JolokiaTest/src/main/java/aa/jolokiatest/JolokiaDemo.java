/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.jolokiatest;

import org.jolokia.client.*;
import org.jolokia.client.request.*;
import java.util.Map;


/**
 *
 * @author aanciaes
 */
public class JolokiaDemo {

    
    public static void main(String[] args) throws Exception {
        J4pClient j4pClient = new J4pClient("http://172.17.0.2:8080/jolokia");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory",
                                                "HeapMemoryUsage");
        J4pReadResponse resp = j4pClient.execute(req);
        Map<String,String> vals = resp.getValue();
        
        System.out.println(vals);
//        int used = Integer.parseInt(vals.get("used"));
//        int max = Integer.parseInt(vals.get("max"));
//        int usage = (int) (used * 100 / max);
//        System.out.println("Memory usage: used: " + used + 
//                           " / max: " + max + " = " + usage + "%");
    }    
    
    
}
