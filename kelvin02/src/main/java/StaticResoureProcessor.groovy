class StaticResoureProcessor {

    def process(Request request, Response response) {

        try {
            response.sendStaticResource()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}