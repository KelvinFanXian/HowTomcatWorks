import javax.servlet.ServletOutputStream
import javax.servlet.ServletResponse

class ResponseFacade implements ServletResponse{
    private ServletResponse response = null

    ResponseFacade(ServletResponse response) {
        this.response = response
    }

    String getCharacterEncoding() {
        return null
    }

    ServletOutputStream getOutputStream() throws IOException {
        return response.getOutputStream()
    }

    PrintWriter getWriter() throws IOException {
        return response.getWriter()
    }

    void setContentLength(int i) {

    }

    void setContentType(String s) {

    }

    void setBufferSize(int i) {

    }

    int getBufferSize() {
        return 0
    }

    void flushBuffer() throws IOException {

    }

    void resetBuffer() {

    }

    boolean isCommitted() {
        return false
    }

    void reset() {

    }

    void setLocale(Locale locale) {

    }

    Locale getLocale() {
        return null
    }
}
