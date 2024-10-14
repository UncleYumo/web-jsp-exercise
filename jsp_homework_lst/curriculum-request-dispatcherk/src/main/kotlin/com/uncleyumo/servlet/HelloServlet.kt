package com.uncleyumo.servlet

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = ["/hello-servlet"])
class HelloServlet : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message = "This is a Servlet-KT named HelloServlet | url: /hello-servlet"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        println("Method Called | doGet-HelloServlet")
        response.contentType = "text/html"

        // Output message
        val out = response.writer
        out.println("<html><body>")
        out.println("<h1>$message</h1>")
        out.println("</body></html>")
    }

    override fun destroy() {
        println("Method Called | destroy-HelloServlet")
    }
}