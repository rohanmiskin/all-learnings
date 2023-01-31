package org.learning.all.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.learning.all.converter.JsonDateTimeConverter;
import org.learning.all.model.kafka.RequestMessage;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApplicationUtil {
    static ObjectMapper objectMapper;

    static JsonParser jsonParser;

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        ApplicationUtil.objectMapper = objectMapper;
    }

    public static JsonParser getJsonParser() {
        return jsonParser;
    }

    public static void setJsonParser(JsonParser jsonParser) {
        ApplicationUtil.jsonParser = jsonParser;
    }

    private ApplicationUtil(){
        throw new UnsupportedOperationException();
    }

    public static RequestMessage convertObject(GenericMessage<?> message) throws IOException {
        Object msg = message.getPayload();

        Document document = Document.parse(msg.toString());

        String jsonString = document.toJson(JsonWriterSettings
        .builder()
        .dateTimeConverter(new JsonDateTimeConverter())
        .build());

        return objectMapper.readValue(jsonString,RequestMessage.class);
    }
    public static JsonObject convertToJsonObject(GenericMessage<?> message){
        return jsonParser.parse(message.getPayload().toString()).getAsJsonObject();
    }

    public static LocalDateTime toZone(final LocalDateTime time,final ZoneId fromZone,final ZoneId toZone){
        final ZonedDateTime zonedTime = time.atZone(fromZone);
        final ZonedDateTime converted = zonedTime.withZoneSameInstant(toZone);
        return converted.toLocalDateTime();
    }


}
