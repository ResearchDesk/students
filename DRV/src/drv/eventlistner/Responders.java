/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drv.eventlistner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Responders implements recieveListener {
        HashMap events=new HashMap();
         ArrayList totalevents=new ArrayList();
    @Override
    public void msgrecieved(String var,int i) {
        
int id = ThreadLocalRandom.current().nextInt(0, 100 + 1);
          events.put("T","recieve");
        events.put("D","("+var+","+i+")");
        events.put("VC",System.currentTimeMillis());
        events.put("sn",id);
        System.out.println(events);
      
    }

    @Override
    public void localdata(String var, int i) {
         int id = ThreadLocalRandom.current().nextInt(0, 100 + 1);
       events.put("T","local");
        events.put("D","("+var+","+i+")");
        events.put("VC",System.currentTimeMillis());
        events.put("sn",id);
        System.out.println(events);
    }


} 