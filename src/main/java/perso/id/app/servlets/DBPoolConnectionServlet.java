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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        String dynamicTableContent = new String();
        if (actionManager == null) {
            // TODO right manager
            actionManager = new ActionManager(request);
            dynamicTableContent = "first gen Meal/Food<br>";
        }
        else { actionManager.setRequest(request); }

        switch(action) {
            case "createMeal":
                dynamicTableContent += "insert m & regen Meal";
                break;
            case "createFood":
                dynamicTableContent += "insert f & regen Food";
                break;
            case "editMeal":
                dynamicTableContent += "update m & regen Meal";
                break;
            case "editFood":
                dynamicTableContent += "update f & regen Food";
                break;
            case "deleteMeal":
                dynamicTableContent += "delete m & regen Meal";
                break;
            case "deleteFood":
                dynamicTableContent += "delete f & regen Food";
                break;
            default:
                dynamicTableContent += "gen Meals & gen Foods";
                break;
        }
        request.setAttribute("dynamicTableContent", dynamicTableContent);
        request.getRequestDispatcher("/jsp/crud.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    
}
