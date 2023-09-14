package perso.id.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perso.id.app.webcontent_generation.instance_manager.ActionManager;

public class SPAServlet extends HttpServlet {
    private ActionManager actionManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (actionManager == null) {
            actionManager = new ActionManager(request);
        }
        else { actionManager.setRequest(request); }
        // TODO handle that null string from JS more gracefully please
        if (action == null || action.equals("null")) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            switch (action) {
                case "getUserAgentInfos":
                    response.getWriter().write(actionManager.getUserAgentInfos());
                    break;
                case "playGuessGame":
                    response.getWriter().write(actionManager.getPlayGuessGame());
                    break;
                case "playJanken":
                    request.getRequestDispatcher("/jsp/janken.jsp").include(request, response);
                    break;
                case "crud":
                    request.getRequestDispatcher("/jsp/crud.jsp").include(request, response);
                    break;
                default:
                    response.getWriter().write("Error: could not find that content [action: " + action + " request: " + request.toString() + "]");
                    break;
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
