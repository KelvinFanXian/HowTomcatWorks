package com.kelvin.ex03

import com.kelvin.ex03.connector.http.HttpRequest
import com.kelvin.ex03.connector.http.HttpResponse

class StaticResourceProcessor {
    void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}
