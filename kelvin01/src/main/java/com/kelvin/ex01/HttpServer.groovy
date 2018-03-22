package com.kelvin.ex01

/**
 * @author Kelvin范显
 * @createDate 2018年03月21日
 */
class HttpServer {

    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN"
    static final String WEB_ROOT = System.getProperty("user.dir")+File.separator+"webroot"

    // the shutdown command received
    private boolean shutdown = false

    static void main(String[] args) {
//        System.out.println("hello tomcat");
        HttpServer httpServer = new HttpServer()
        httpServer.await()
    }

    private void await() {
        ServerSocket serverSocket = null
        try {
            int port = 8801
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))
        } catch (ex) {
            ex.printStackTrace()
            System.exit(1)
        }
        // Loop waiting for a request
        while (!shutdown) {
            Socket socket = null
            InputStream input =null
            OutputStream output = null
            try {
                socket = serverSocket.accept()
                input = socket.getInputStream()
                output = socket.getOutputStream()

                // create Request object and parse
                Request request = new Request(input)
                request.parse()

                // create Response object
                Response response = new Response(output)
                response.setRequest(request)
                response.sendStaticResource()

                // Close the socket
                socket.close()
                // check if the previous URI is a shutdown command
                shutdown = SHUTDOWN_COMMAND.equalsIgnoreCase(request.uri)
            } catch (ex) {
                ex.printStackTrace()
                continue
            }
        }
    }
}

