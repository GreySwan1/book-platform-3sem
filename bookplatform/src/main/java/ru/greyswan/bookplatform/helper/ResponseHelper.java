package ru.greyswan.bookplatform.helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ResponseHelper {

    private static final String MOCK_FOLDER = "/home/greyswan/Documents/Study/BookPlatform/bookplatform/src/main/resources/mock/";

    private final JSONParser jsonParser;

    public ResponseHelper(JSONParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    public ResponseEntity<String> response(String path) {
        JSONObject body = getResponseBodyFromFile(path);
        return getResponseEntity(body);
    }

    private JSONObject getResponseBodyFromFile(String path) {
        try {
            return (JSONObject) jsonParser.parse(new FileReader(MOCK_FOLDER + path, StandardCharsets.UTF_8));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private ResponseEntity<String> getResponseEntity(JSONObject responseBody) {
        return ResponseEntity.ok()
                .body(responseBody.toJSONString());
    }

}
