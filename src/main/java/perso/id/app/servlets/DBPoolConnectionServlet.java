package perso.id.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perso.id.app.webcontent_generation.instance_manager.ActionManager;

public class DBPoolConnectionServlet extends HttpServlet {
    private ActionManager actionManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String dynamicTableContent = new String();
        if (actionManager == null) {
            actionManager = new ActionManager(request);
        }
        else { actionManager.setRequest(request); }

        switch(action) {
            case "createMeal":
                dynamicTableContent = "insert m & gen Meals";
                break;
            case "createFood":
                dynamicTableContent = "insert f & gen Foods";
                break;
            case "editMeal":
                dynamicTableContent = "update m & gen Meals";
                break;
            case "editFood":
                dynamicTableContent = "update f & gen Foods";
                break;
            case "deleteMeal":
                dynamicTableContent = "delete m & gen Meals";
                break;
            case "deleteFood":
                dynamicTableContent = "delete f & gen Foods";
                break;
            case "readFood":
                dynamicTableContent = "gen Foods";
                break;
            default:
                dynamicTableContent = "gen Meals & gen Foods";
                break;
        }
        request.setAttribute("dynamicTableContent", dynamicTableContent);
        request.getRequestDispatcher("/jsp/crud.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
}
