import javax.servlet.Servlet
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class ServletProcessor2 {
    def process(Request request, Response response) {
        String uri = request.getUri()
        String servletName = uri.substring(uri.lastIndexOf("/")+1)
        URLClassLoader loader = null
        try {
            //create a URLClassLoader
            URL[] urls = new URL[1]
            URLStreamHandler streamHandler = null
            File classPath = new File(Constants.WEEB_ROOT)
            //the forming of repository is taken from the
            //createClassLoader method in
            //org.apache.catalina.startup.ClassLoaderFactory
            println("""---->${classPath.getCanonicalPath()}""")
            String repository = (new URL("file", null,
                    classPath.getCanonicalPath().concat(File.separator))).toString()
            // the code for forming the URL is taken from
            // the addRepository method in
            //org.apache.catalina.StandardClassLoader.
            urls[0] = new URL(null, repository, (URLStreamHandler)streamHandler)
            loader = new URLClassLoader(urls)
        } catch (IOException e) {
            print(e.toString())
        }
        Class myClass = null
        try {
            myClass = loader.loadClass(servletName)
        } catch (ClassNotFoundException e) {
            print(e.toString())
        }

        Servlet servlet = null
        RequestFacade requestFacade = new RequestFacade(request)
        ResponseFacade responseFacade = new ResponseFacade(response)

        try {
            servlet = (Servlet) myClass.newInstance()
            servlet.service((ServletRequest)requestFacade, (ServletResponse)responseFacade)//You also upcast
        } catch (Exception e) {
            println(e.toString())
        } catch (Throwable e) {
            println(e.toString())
        }

    }
}
