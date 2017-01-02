/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drv.eventlistner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
 import java.util.concurrent.ThreadLocalRandom;


interface sendListener {
    void msgsend(String var,int i);
    void getevents();
    void localevents(String var,int i);
}

 
public class NIOClient {
     private List<sendListener> listeners = new ArrayList<sendListener>();
   private List<localeventListener> listeners1 = new ArrayList<localeventListener>();
    public void addListener(sendListener toAdd) {
        listeners.add(toAdd);
    }
   public void addListenerlocal(localeventListener toAdd) {
        listeners1.add(toAdd);
    }
    public  void local(String var,int i){
         for (localeventListener hl : listeners1)
            hl.localevent(var,i);
    }
     
    public void msgsend(SocketChannel crunchifyClient,ByteBuffer buffer,String var,int i) throws IOException {
      //  System.out.println("Hello!");
    crunchifyClient.write(buffer);
        // Notify everybody that may be interested.
        for (sendListener hl : listeners)
            hl.msgsend(var,i);
//        for (sendListener hl : listeners)
//            hl.getevents();
    }
   
    
	public  void data() throws IOException, InterruptedException {
 
		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
		SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);
 
		//log("Connecting to Server on port 1111...");
 
		ArrayList<String> companyDetails = new ArrayList<String>();
 
		// create a ArrayList with companyName list
		companyDetails.add("Facebook");
		companyDetails.add("Twitter");
		companyDetails.add("IBM");
		companyDetails.add("Google");
		companyDetails.add("Crunchify");
 int j=0;
		for (String companyName : companyDetails) {
 
			byte[] message = new String(companyName).getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(message);
                        
			 msgsend( crunchifyClient, buffer,"j",j);
                         local("j",j);
 j++;
			log("sending: ");
			buffer.clear();
 
			// wait for 2 seconds before sending next message
			Thread.sleep(2000);
		}
		//crunchifyClient.close();
	}
 
	private static void log(String str) {
		System.out.println(str);
	}
        
        public static void main(String[] args) throws IOException, InterruptedException {
        NIOClient c1=new NIOClient();
        Responder responder = new Responder();
        c1.addListener(responder);
        c1.data();
        
    }
}