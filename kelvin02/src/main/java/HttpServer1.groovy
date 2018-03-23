class HttpServer1 {

    // shutdown command
    static final String SHUTDOWN_COMMAND = "/SHUTDOWN"

    // the shutdown command received
    private boolean shutdown = false

    static void main(String[] args) {
        HttpServer1 server = new HttpServer1()
        server.await()
    }

    void await() {
        ServerSocket serverSocket = null
        int port = 8802
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))
        } catch (ex) {
            ex.printStackTrace()
            System.exit(1)
        }

        //Loop waiting for a request
        while (!shutdown) {
            Socket socket = null
            InputStream input = null
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

                // check if this is a request for a servlet or
                // a static resource
                // a request for a servlet begins with "/servlet/"
                if (request.getUri().startsWith("/servlet/")) {
                    ServletProcessor1 processor = new ServletProcessor1()
                    processor.process(request, response)
                } else {
                    StaticResoureProcessor processor = new StaticResoureProcessor()
                    processor.process(request,response)
                }

                // Close the socket
                socket.close()
                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND)
            } catch (ex) {
                ex.printStackTrace()
                System.exit(1)
            }
        }
    }
}
