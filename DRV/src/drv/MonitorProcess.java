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
        ArrayList fullautomata = new ArrayList();
        List states = f.getAllStates();
     
        fullautomata.add(states);
        fullautomata.add(start);
        fullautomata.add(transition);
        return fullautomata;
    }

    public static void INIT() {

        gv0.put("gstate", start);
        gv0.put("q",f.ProcessFSM(transition.get(0).toString()) );
        gv0.put("p_trans", "");
        gv0.put("tokens", "");
        GV.add(gv0);
    }

    /**
     *
     * @param monioringAutomata
     */
    public static void  startMonitor(ArrayList monioringAutomata){
        List Q;
        String q0;
        List del;
        String lambda;
        for(int i=0;i<=monioringAutomata.size();i++){
            
        }
    }
}
