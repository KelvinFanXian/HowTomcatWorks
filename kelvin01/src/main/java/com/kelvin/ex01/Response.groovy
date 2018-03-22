package com.kelvin.ex01

/**
 * @author Kelvin范显
 * @createDate 2018年03月21日
 */
class Response {
    private static final int BUFFER_SIZE = 1024

    Request request
    OutputStream output

    Response(OutputStream output) {
        this.output = output
    }

    def sendStaticResource() {
        byte[] bytes = new byte[BUFFER_SIZE]
        FileInputStream fis = null
        try{
            File file = new File(HttpServer.WEB_ROOT,request.uri)
            if (file.exists()) {
                //write protocol@Kelvin
                def header = """HTTP/1.1 200 ok
"Content-Type: text/html
"Content-Length: 300

"""
                output.write(header.getBytes())

                fis = new FileInputStream(file)
                int ch = fis.read(bytes,0,BUFFER_SIZE)
                while (ch!=-1) {
                    output.write(bytes,0,BUFFER_SIZE)
                    ch =fis.read(bytes,0,BUFFER_SIZE)
                }
            } else {//404
                String errorMessage = """HTTP/1.1 404 File Not Found
Content-Type: text/html
Content-Length: 23

<h1>File Not Found</h1>
"""
                output.write(errorMessage.getBytes())
            }
        }catch (ex){
            print(ex)
        }finally{
            if (fis != null){
                fis.close()
            }
        }
    }
}
