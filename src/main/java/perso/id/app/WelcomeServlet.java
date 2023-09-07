package perso.id.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perso.id.app.modules.bll.ActionManager;

public class WelcomeServlet extends HttpServlet {
    private ActionManager actionManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (actionManager == null) {
            actionManager = new ActionManager(req);
        }
        else { actionManager.setRequest(req); }

        if (action == null || action.equals("null")) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            switch (action) {
                case "getUserAgentInfos":
                    resp.getWriter().write(actionManager.getUserAgentInfos());
                    break;
                case "playGuessGame":
                    resp.getWriter().write(actionManager.getPlayGuessGame());
                    break;
                case "playJanken":
                    req.getRequestDispatcher("/jsp/janken.jsp").include(req, resp);
                    break;
                default:
                    resp.getWriter().write("Error: could not find that content [action: " + action + " request: " + req.toString() + "]");
                    break;
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
