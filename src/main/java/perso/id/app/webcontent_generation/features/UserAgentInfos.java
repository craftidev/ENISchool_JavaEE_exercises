package perso.id.app.webcontent_generation.features;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class UserAgentInfos {
    private HttpServletRequest request;
    public UserAgentInfos(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return getUserAgentInfos();
    }

    private String getUserAgentInfos() {
        StringBuffer sb = new StringBuffer();
        String userAgent = request.getHeader("user-agent");

        sb.append("User-Agent : ").append(userAgent).append("<br>");
        
        Enumeration<String> listeEntetes = request.getHeaderNames();
        while (listeEntetes.hasMoreElements()) 
        {
            String entete = listeEntetes.nextElement();
            sb.append(entete + " : ");
            Enumeration<String> valeurs = request.getHeaders(entete);
            while (valeurs.hasMoreElements()) 
            {
                sb.append(valeurs.nextElement());
                if (valeurs.hasMoreElements())
                {
                    sb.append(", ");
                }
            }
            sb.append("<br>");
        }
        //! Test
        System.out.println("request in user agent method is: "+request);
        System.out.println("and what it's sending is: "+sb.toString());
        return sb.toString();
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}

