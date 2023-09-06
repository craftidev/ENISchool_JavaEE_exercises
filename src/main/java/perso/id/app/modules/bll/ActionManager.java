package perso.id.app.modules.bll;

import javax.servlet.http.HttpServletRequest;

import perso.id.app.modules.dto.PlayGuessGame;
import perso.id.app.modules.dto.UserAgentInfos;

public class ActionManager implements Action {
    private HttpServletRequest request;
    private UserAgentInfos userAgentInfos;
    private PlayGuessGame playGuessGame;

    public ActionManager(HttpServletRequest request) {
        this.request = request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUserAgentInfos() {
        if (userAgentInfos == null) {
            userAgentInfos = new UserAgentInfos(request);
        }

        return userAgentInfos.toString();
    }

    public String getPlayGuessGame() {
        String userGuess = request.getParameter("userGuess");

        if (playGuessGame == null) {
            playGuessGame = new PlayGuessGame(userGuess);
        }
        else {
            playGuessGame.setUserGuess(userGuess);
        }

        return playGuessGame.toString();
    }
}
