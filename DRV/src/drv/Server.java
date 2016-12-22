package drv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /** Default port number where the server listens for connections. */
    public static final int SQUARE_PORT = 65535;

    private ServerSocket serverSocket;
    // Rep invariant: serverSocket != null

    /** Make a SquareServer that listens for connections on port.
     *  @param port port number, requires 0 <= port <= 65535 */
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    /** Run the server, listening for connections and handling them.
     *  @throws IOException if the main server socket is broken */
    public void serve() throws IOException {
        while (true) {
            // block until a client connects
            Socket socket = serverSocket.accept();
            try {
                handle(socket);
            } catch (IOException ioe) {
                ioe.printStackTrace(); // but don't terminate serve()
            } finally {
                socket.close();
            }
        }
    }

    /** Handle one client connection. Returns when client disconnects.
     *  @param socket socket where client is connected
     *  @throws IOException if connection encounters an error */
    private void handle(Socket socket) throws IOException {
        System.err.println("client connected");

        // get the socket's input stream, and wrap converters around it
        // that convert it from a byte stream to a character stream,
        // and that buffer it so that we can read a line at a time
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    socket.getInputStream()));

        // similarly, wrap character=>bytestream converter around the
        // socket output stream, and wrap a PrintWriter around that so
        // that we have more convenient ways to write Java primitive
        // types to it.
        PrintWriter out = new PrintWriter(new OutputStreamWriter(
                                  socket.getOutputStream()));

        try {
            // each request is a single line containing a number
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                System.err.println("request: " + line);
                try {
                    int x = Integer.valueOf(line);
                    // compute answer and send back to client
                    int y = x * x;
                    System.err.println("reply: " + y);
                    out.print(y + "\n");
                } catch (NumberFormatException e) {
                    // complain about ill-formatted request
                    System.err.println("reply: err");
                    out.println("err");
                }
                // important! flush our buffer so the reply is sent
                out.flush();
            }
        } finally {
            out.close();
            in.close();
        }
    }

    /** Start a SquareServer running on the default port. */
    public static void main(String[] args) {
        try {
           Server server = new Server(SQUARE_PORT);
            server.serve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}