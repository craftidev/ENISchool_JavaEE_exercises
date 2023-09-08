package perso.id.app.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JavaScriptBundleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/javascript");

        try (PrintWriter out = resp.getWriter()) {
            // JS files to bundle together
            out.println(readFile("js/ajaxActionTrigger.js"));
        }
    }

    private String readFile(String filePath) throws IOException {
        InputStream inputStream = getServletContext().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        return content.toString();
    }
}