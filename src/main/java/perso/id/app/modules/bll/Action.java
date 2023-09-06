package perso.id.app.modules.bll;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public String getUserAgentInfos();
    public String getPlayGuessGame();
    public void setRequest(HttpServletRequest request);
}
