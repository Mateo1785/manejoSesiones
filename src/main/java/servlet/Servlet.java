package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    //Sobreescribimos el metodo doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //Creamos la sesion
        HttpSession session = req.getSession();
        //
        //Creamos una variable de tipo string
        String titulo = null;
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
        //Evaluamos las condicion si es
        //la primera vez que ingreses a la aplicacion
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido a mi aplicacion por primera vez";
        }else {
            contadorVisitas = contadorVisitas+1;
            titulo = "Bienvenido a mi aplicacion nuevamente";
        }
        //seteamos o agregamos los nuevos valores a la sesion
        session.setAttribute("contadorVisitas", contadorVisitas);

        out.println("<html><body>");
        out.println("<h1>" +  titulo + "</h1>");
        out.println("<h2>Numero de sesion iniciada: #" +  contadorVisitas + "</h2>");
        out.println("</body></html>");
    }
}
