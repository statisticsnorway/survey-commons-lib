package no.ssb.survey.surveycommons.blaisecommunication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.pubsub.v1.PubsubMessage;

public interface BlaiseMessageHandler {
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
                case avtale -> System.out.println("avtale not implemented");
                default -> System.out.printf("Hit default case for message: %s", bMessage);
            }

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    void onStatusUpdate(BlaiseMessage message);

    void onContactUpdate(BlaiseMessage message);
}
