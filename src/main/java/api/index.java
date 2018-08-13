package api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public index() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        long time1 = System.currentTimeMillis();
        long time2 = time1 + 10000;
        out.println(time1);
        long i = 400000000l;
        while (System.currentTimeMillis() < time2) {
            i++;
        }
        out.print(time2);
    }
}