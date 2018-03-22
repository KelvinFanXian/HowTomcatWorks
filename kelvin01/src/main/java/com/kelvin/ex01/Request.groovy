package com.kelvin.ex01

/**
 * @author Kelvin范显
 * @createDate 2018年03月21日
 */
class Request {
    private InputStream input
    private String uri

    Request(InputStream input) {
        this.input = input
    }

    def parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048)
        int i
        byte[] buffer = new byte[2048]
        try {
            i = input.read(buffer)
        } catch (ex) {
            ex.printStackTrace()
            i = -1
        }

        for (int j; j < i; j++) {
            request.append((char)buffer[j])//byte to char,remember to cast
        }
        print(request.toString())
        uri = parseUri(request.toString())
    }

    String parseUri(String requestString) {
        int index1, index2
        index1 = requestString.indexOf(" ")
        if (index1!=-1) {
            index2 = requestString.indexOf(" ",index1+1)
            if (index2>index1)
                return requestString.substring(index1+1,index2)//[)
        }
        return null
    }
}
