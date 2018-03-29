package com.kelvin.ex03.startup

import com.kelvin.ex03.connector.http.HttpConnector

class Bootstrap {
    static void main(String[] args) {
        HttpConnector connector = new HttpConnector()
        connector.start()
    }
}
