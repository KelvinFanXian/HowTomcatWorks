import javax.servlet.RequestDispatcher
import javax.servlet.ServletInputStream
import javax.servlet.ServletRequest

class RequestFacade implements ServletRequest{

    private ServletRequest request = null

    RequestFacade(ServletRequest request) {
        this.request = request
    }
/**
     * implementation of the ServletRequest
     */
    Object getAttribute(String s) {
        return request.getAttribute(s)
    }

    Enumeration getAttributeNames() {
        return request.getAttributeNames()
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
