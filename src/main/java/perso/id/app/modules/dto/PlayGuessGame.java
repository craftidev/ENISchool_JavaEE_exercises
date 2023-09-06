package perso.id.app.modules.dto;

import java.util.HashMap;
import java.util.Map;

public class PlayGuessGame {
    private final Integer MIN_GUESS = 1;
    private final Integer MAX_GUESS = 10;
    private Integer generatedGoal;
    private Integer userGuess;
    private Integer tryCounter = 0;
    private Map<String, String> HTMLContent = new HashMap<>();

    public PlayGuessGame(String userGuessStr) {
        if (generatedGoal == null) {
            this.generatedGoal = (int) (Math.random() * (MAX_GUESS - MIN_GUESS + 1)) + MIN_GUESS;
        }
        this.userGuess = strToInteger(userGuessStr);
        newTurn();
    }

    private void newTurn() {
        if (userGuess != null) {
            tryCounter++;
            
            if (isWinner()) {
                getWinnerContent();
                generatedGoal = (int) (Math.random() * (MAX_GUESS - MIN_GUESS + 1)) + MIN_GUESS;
            }
            else { getLoserContent(); }
        }
        else { getInitContent(); }
    }

    private Integer strToInteger(String str) {
        if (str == null) {
            return null;
        }
        else {
            return Integer.valueOf(str);
        }
    }

    public void setUserGuess(String userGuessStr) {
        this.userGuess = strToInteger(userGuessStr);
        newTurn();
    }

    public Integer getGeneratedGoal() {
        return generatedGoal;
    }

    private boolean isWinner() {
        return (generatedGoal == userGuess);
    }

    @Override
    public String toString() {
        StringBuffer resultHTML = new StringBuffer();
        for (String key : HTMLContent.keySet()) {
            String value = HTMLContent.get(key);
            resultHTML.append(value).append("<br>");
        }
        return resultHTML.toString();
    }

    private void getInitContent() {
        StringBuffer HTMLform = new StringBuffer();
        HTMLform.append("<form class=\"guess-game-form\" method=\"POST\" action=\"WelcomeServlet\" data-action=\"playGuessGame\">");
        HTMLform.append("<input type=\"number\" name=\"userGuess\">");
        HTMLform.append("<input type=\"submit\">");
        HTMLform.append("</form>");

        HTMLContent.put("message", "Start of the game.");
        HTMLContent.put("form", HTMLform.toString());
    }

    private void getWinnerContent() {
        HTMLContent.put("message", "You win. Try to guess the new number.");
    }

    private void getLoserContent() {
        HTMLContent.put("message", "You lose.");
    }
}
