/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drv.eventlistner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
 
 interface recieveListener {
    void msgrecieved(String variable,int i);
   void localdata(String var,int i);
}

public class NIOServer {
   private List<recieveListener> listeners = new ArrayList<recieveListener>();
 private List<localeventListener> listeners1 = new ArrayList<localeventListener>();
  public void addListenerlocal(localeventListener toAdd) {
        listeners1.add(toAdd);
    }
    public void addListener(recieveListener toAdd) {
        listeners.add(toAdd);
    }
      public  void local(String var,int i){
         for (localeventListener hl : listeners1)
            hl.localevent(var,i);
    }
        public void msgrecieved(SocketChannel crunchifyClient,ByteBuffer buffer,int i,String variable) throws IOException {
      //  System.out.println("Hello!");
    crunchifyClient.read(buffer);
        // Notify everybody that may be interested.
        for (recieveListener hl : listeners)
            hl.msgrecieved(variable,i);
//        for (sendListener hl : listeners)
//            hl.getevents();
    }
	@SuppressWarnings("unused")
	public  void data() throws IOException {
 int i=0;
		// Selector: multiplexor of SelectableChannel objects
		Selector selector = Selector.open(); // selector is open here
 
		// ServerSocketChannel: selectable channel for stream-oriented listening sockets
		ServerSocketChannel crunchifySocket = ServerSocketChannel.open();
		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
 
		// Binds the channel's socket to a local address and configures the socket to listen for connections
		crunchifySocket.bind(crunchifyAddr);
 
		// Adjusts this channel's blocking mode.
		crunchifySocket.configureBlocking(false);
 
		int ops = crunchifySocket.validOps();
		SelectionKey selectKy = crunchifySocket.register(selector, ops, null);
 
		// Infinite loop..
		// Keep server running
		while (true) {
 
			//log("i'm a server and i'm waiting for new connection and buffer select...");
			// Selects a set of keys whose corresponding channels are ready for I/O operations
			selector.select();
 
			// token representing the registration of a SelectableChannel with a Selector
			Set<SelectionKey> crunchifyKeys = selector.selectedKeys();
			Iterator<SelectionKey> crunchifyIterator = crunchifyKeys.iterator();
 
			while (crunchifyIterator.hasNext()) {
				SelectionKey myKey = crunchifyIterator.next();
 
				// Tests whether this key's channel is ready to accept a new socket connection
				if (myKey.isAcceptable()) {
					SocketChannel crunchifyClient = crunchifySocket.accept();
 
					// Adjusts this channel's blocking mode to false
					crunchifyClient.configureBlocking(false);
 
					// Operation-set bit for read operations
					crunchifyClient.register(selector, SelectionKey.OP_READ);
					//log("Connection Accepted: " + crunchifyClient.getLocalAddress() + "\n");
 
					// Tests whether this key's channel is ready for reading
				} else if (myKey.isReadable()) {
					
					SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
					ByteBuffer crunchifyBuffer = ByteBuffer.allocate(256);
                                        i=i+1;
                                        msgrecieved(crunchifyClient,crunchifyBuffer,i,"i");
					local( "i",i);
					String result = new String(crunchifyBuffer.array()).trim();
 
					log("Message received: ");
 
					if (result.equals("Crunchify")) {
						crunchifyClient.close();
						//log("\nIt's time to close connection as we got last company name 'Crunchify'");
						//log("\nServer will keep running. Try running client again to establish new connection");
					}
				}
				crunchifyIterator.remove();
			}
		}
	}
 
	private static void log(String str) {
		System.out.println(str);
	}
        public static void main(String[] args) throws IOException {
            NIOServer as=new NIOServer();
            Responders ass=new Responders();
            localresponder asss=new localresponder();
            
             as.addListenerlocal(asss);
            as.addListener(ass);
            as.data();
        
    }
}