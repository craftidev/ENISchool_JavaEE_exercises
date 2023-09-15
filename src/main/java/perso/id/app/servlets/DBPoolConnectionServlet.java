package perso.id.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.errors.LogicException;
import perso.id.app.database.lunch_feature.logic.MealManager;

public class DBPoolConnectionServlet extends HttpServlet {
    private MealManager mealManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        String dynamicTableContent = new String();
        if (mealManager == null) {
            // TODO right manager
            mealManager = new MealManager();
            dynamicTableContent = "first gen Meal/Food<br>";
        }

        switch(action) {
            case "createMeal":
                dynamicTableContent += "insert m & regen Meal";
                try {
                    mealManager.add(request.getParameter("dateInput"), request.getParameter("foodList"));
                } catch (LogicException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (CommandException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
