/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drv;

import Action.FSMAction;
import FSM.FSM;
import static drv.MonitorProcess.INIT;
import static drv.MonitorProcess.monioringAutomata;
import static drv.MonitorProcess.startMonitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author user54
 */
public class DRV {

    public static FSM f;

    public static void testFSM() {
        try {
            f = new FSM("src/config/config.xml", new FSMAction() {
                @Override
                public boolean action(String curState, String message, String nextState, Object args) {
                    // javax.swing.JOptionPane.showMessageDialog(null, curState + ":" + message +" : " +nextState);
                    /*
                     * Here we can implement our login of how we wish to handle an action
                     */
                    return true;
                }
            });
//            ArrayList monioringAutomata = monioringAutomata();
//            System.out.println(monioringAutomata);
//            INIT();
//            startMonitor(monioringAutomata);

//            System.out.println(f.getCurrentState());
//            f.ProcessFSM("MOVELEFT");
//            System.out.println(f.getCurrentState());
//            f.ProcessFSM("MOVE");
//            System.out.println(f.getCurrentState());
//            f.ProcessFSM("MOVELEFT");
//            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DRV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DRV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DRV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testFSM();
    }

}
