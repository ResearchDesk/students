/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drv;

import static drv.DRV.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author user54
 */
public class MonitorProcess {

    public static HashMap history = new HashMap();
    public static HashMap w_tokens = new HashMap();
    public static HashMap gv0 = new HashMap();
    public static ArrayList GV = new ArrayList();
   public static String start = "START";
      public static   List transition = Arrays.asList("MOVELEFT", "MOVE", "MOVELEFT");
    public static ArrayList monioringAutomata() {
        System.out.println("Generating Monitor Automata");
        ArrayList fullautomata = new ArrayList();
        List states = f.getAllStates();
     
        fullautomata.add(states);
        fullautomata.add(start);
        fullautomata.add(transition);
        System.out.println("Automata Generated successfully");
        return fullautomata;
    }

    public static void INIT() {
        System.out.println("running the initialiser");
        gv0.put("gstate", start);
        gv0.put("q",f.ProcessFSM(transition.get(0).toString()) );
        gv0.put("p_trans", "");
        gv0.put("tokens", "");
        GV.add(gv0);
        System.out.println("All values intialised successfully");
    }

    /**
     *
     * @param monioringAutomata
     */
    public static String  startMonitor(ArrayList monioringAutomata){
        System.out.println("starting the monitor process");
        List Q;
        String q0;
        List del;
        String lambda;
       Q=(List)monioringAutomata.get(0);
        q0=(String)monioringAutomata.get(1);
        del=(List)monioringAutomata.get(2);
//        System.out.println(Q);
//         System.out.println(q0);
//          System.out.println(del);
          int i=1;
          while (i==1){
              ArrayList m=recieve();
              if (!m.isEmpty()){
                  RecieveToken(m);
              }
              ArrayList e= read();
              if(!e.isEmpty()){
                 ReceiveEvents(e); 
              }
          }
        return null;
    }

    private static ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static ArrayList recieve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void RecieveToken(ArrayList m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void ReceiveEvents(ArrayList e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
