package perso.id.app.webcontent_generation.instance_manager;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public String getUserAgentInfos();
    public String getPlayGuessGame();
    public void setRequest(HttpServletRequest request);
}
