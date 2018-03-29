import javax.servlet.RequestDispatcher
import javax.servlet.ServletInputStream
import javax.servlet.ServletRequest

class Request implements ServletRequest{

    private InputStream input
    private String uri

    Request(InputStream input) {
        this.input = input
    }

    def getUri() {
        return uri
    }

    private String parseUri(String requestString) {
        int index1, index2
        index1 = requestString.indexOf(' ')
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1)
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2)
        }
        return null
    }

    void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048)
        int i
        byte[] buffer = new byte[2048]
        try {
            i = input.read(buffer)
        } catch (IOException e) {
            e.printStackTrace()
            i = -1
        }
        for (int j=0; j<i; j++) {
            request.append((char)buffer[j])
        }
        uri = parseUri(request.toString())
    }

    /* implementation of ServletRequest */
    Object getAttribute(String s) {
        return null
    }

    Enumeration getAttributeNames() {
        return null
    }

    String getCharacterEncoding() {
        return null
    }

    void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    int getContentLength() {
        return 0
    }

    String getContentType() {
        return null
    }

    ServletInputStream getInputStream() throws IOException {
        return null
    }

    String getParameter(String s) {
        return null
    }

    Enumeration getParameterNames() {
        return null
    }

    String[] getParameterValues(String s) {
        return new String[0]
    }

    Map getParameterMap() {
        return null
    }

    String getProtocol() {
        return null
    }

    String getScheme() {
        return null
    }

    String getServerName() {
        return null
    }

    int getServerPort() {
        return 0
    }

    BufferedReader getReader() throws IOException {
        return null
    }

    String getRemoteAddr() {
        return null
    }

    String getRemoteHost() {
        return null
    }

    void setAttribute(String s, Object o) {

    }

    void removeAttribute(String s) {

    }

    Locale getLocale() {
        return null
    }

    Enumeration getLocales() {
        return null
    }

    boolean isSecure() {
        return false
    }

    RequestDispatcher getRequestDispatcher(String s) {
        return null
    }

    String getRealPath(String s) {
        return null
    }
}
