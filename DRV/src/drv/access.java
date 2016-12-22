/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drv;

import java.io.IOException;

/**
 *
 * @author user54
 */
public class access {

  private static final int N = 100;

    /**  Use a SquareServer to square all the integers from 1 to N. */
    public static void main(String[] args) throws IOException {
       Client client = new Client("localhost",
                                               Server.SQUARE_PORT);
        // send the requests to square 1...N
        for (int x = 1; x <= N; ++x) {
            client.sendRequest(x);
            System.out.println(x + "^2 = ?");
        }
        // collect the replies
        for (int x = 1; x <= N; ++x) {
            int y = client.getReply();
            System.out.println(x + "^2 = " + y);
        }
        client.close();
    }
    
}
