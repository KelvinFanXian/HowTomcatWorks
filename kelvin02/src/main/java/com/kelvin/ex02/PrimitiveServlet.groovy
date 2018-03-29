import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class PrimitiveServlet implements Servlet {
    void init(ServletConfig servletConfig) throws ServletException {
        println("init")
    }

    ServletConfig getServletConfig() {
        return null
    }

    void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        println("from service")
        PrintWriter out = response.getWriter()
        println("Hello, Role is red.")
        println("volets are nnlue")
    }

    String getServletInfo() {
        return null
    }

    void destroy() {
        println("destroy")
    }
}
