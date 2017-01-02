/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drv.eventlistner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

 public class Responder implements sendListener {
        HashMap events=new HashMap();
         ArrayList totalevents=new ArrayList();
    @Override
    public void msgsend(String var,int i) {
        
int id = ThreadLocalRandom.current().nextInt(0, 100 + 1);
       events.put("T","send");
        events.put("D","("+var+","+i+")");
        events.put("VC",System.currentTimeMillis());
        events.put("sn",id);
        System.out.println(events);
      
    }

    @Override
    public void getevents() {
         System.out.println("events");
        for(int i=0;i<=events.size();i++){
           
            System.out.println(events.get(i));
        }
    }

    @Override
    public void localevents(String var, int i) {
     int id = ThreadLocalRandom.current().nextInt(0, 100 + 1);
       events.put("T","send");
        events.put("D","("+var+","+i+")");
        events.put("VC",System.currentTimeMillis());
        events.put("sn",id);
        System.out.println(events);
    }
}