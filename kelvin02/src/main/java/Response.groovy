import javax.servlet.ServletOutputStream
import javax.servlet.ServletResponse

class Response implements ServletResponse{

    private static final int BUTTFER_SIZE = 1024
    Request request
    OutputStream output
    PrintWriter writer

    Response(OutputStream output) {
        this.output = output
    }

    def setRequest(Request request) {
        this.request = request
    }

    /**
     * This method is used to serve static pages
     */
    def sendStaticResource() throws IOException{
        byte[] bytes = new byte[BUTTFER_SIZE]
        FileInputStream fis = null
        try {
            // request.getUri => request.getRequestURI
            File file = new File(Constants.WEEB_ROOT, request.getUri())
            fis = new FileInputStream(file)
            int ch = fis.read(bytes, 0, BUTTFER_SIZE)
            while (ch != -1) {
                output.write(bytes, 0, ch)
                ch = fis.read(bytes, 0, BUTTFER_SIZE)
            }
        } catch (FileNotFoundException e) {
            String errorMessage = """HTTP/1.1 404 File Not Found
Content-Type: text/html
Content-Length: 23

<h1>File Not Found</h1>
"""
            output.write(errorMessage.getBytes())
        } finally {
            if (fis != null) {
                fis.close()
            }
        }
    }

    /** implementation of ServletResponse */
    String getCharacterEncoding() {
        return null
    }

    ServletOutputStream getOutputStream() throws IOException {
        return null
    }

    PrintWriter getWriter() throws IOException {
        // autoflush is true, println() will flush,
        //but print() will not
        writer = new PrintWriter(output, true)
        return writer
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
