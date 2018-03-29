package com.kelvin.ex03.connector.http

class HttpConnector implements Runnable{
    boolean stopped
    private String scheme = "http"

    String getScheme() {
        return scheme
    }

    void run() {
        ServerSocket serverSocket = null
        int port = 8803
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))
        } catch (IOException e) {
            e.printStackTrace()
            System.exit(1)
        }

        while (!stopped) {
            Socket socket = null
            try {
                socket = serverSocket.accept()
            } catch (Exception e) {
                continue
            }
            HttpProcessor processor = new HttpProcessor(this)
            processor.process(socket)
        }
    }

    void start() {
        Thread thread = new Thread(this)
        thread.start()
    }
}
