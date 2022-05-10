package no.ssb.survey.surveycommons.blaisecommunication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BlaiseMessageHandler {

    Logger log = LoggerFactory.getLogger(BlaiseMessageHandler.class);

    default void process(PubsubMessage message) {
        parseMessage(message.getData().toStringUtf8());
    }

    default void parseMessage(String message) {
        ObjectMapper mapper = new ObjectMapper();
        BlaiseMessage bMessage = null;
        try {
            bMessage = mapper.readValue(message, BlaiseMessage.class);

            switch (bMessage.getType()) {
                case status -> onStatusUpdate(bMessage);
                case kontaktinformasjon -> onContactUpdate(bMessage);
                case avtale -> log.error("avtaler status not implemented");
                default -> log.warn("Hit default case for message: {}", bMessage);
            }

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    void onStatusUpdate(BlaiseMessage message);

    void onContactUpdate(BlaiseMessage message);
}
