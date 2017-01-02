

package drv.eventlistner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
 interface localeventListener {
    void localevent(String var,int i);
}
public class localresponder implements localeventListener {
        HashMap events=new HashMap();
         ArrayList totalevents=new ArrayList();
    @Override
    public void localevent(String var,int i) {
        
int id = ThreadLocalRandom.current().nextInt(0, 100 + 1);
  
        events.put("T","internal");
        events.put("D","internal");
        events.put("VC",System.currentTimeMillis());
        events.put("sn",id);
        
        System.out.println(events);
//        events.add(id);
//        events.add(System.currentTimeMillis());
//        totalevents.addAll(events);
      
    }

 
} 