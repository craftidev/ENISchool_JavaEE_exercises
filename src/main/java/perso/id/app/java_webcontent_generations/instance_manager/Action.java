package perso.id.app.java_webcontent_generations.instance_manager;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public String getUserAgentInfos();
    public String getPlayGuessGame();
    public void setRequest(HttpServletRequest request);
}
