package perso.id.app.database.lunch_feature.errors;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorMessage {
    public String getErrorMessage(int code, String language) throws IOException {
        String message = new String();
        
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("ErrorMessages.json"));

            String messageKey = String.valueOf(code);

            JsonNode messageNode = jsonData.get(messageKey);
            message = messageNode.get(language).asText();
        } catch (IOException e) {
            // TODO handle exception
        }

        return message;
    }
}
