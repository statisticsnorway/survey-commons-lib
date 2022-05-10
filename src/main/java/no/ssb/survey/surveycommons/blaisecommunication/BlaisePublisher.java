package no.ssb.survey.surveycommons.blaisecommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BlaisePublisher {

    private String mainSurveyId;

    private static BlaisePublisher publisher = null;

    private BlaisePublisher() {
    }

    public static BlaisePublisher getInstance() {
        if (publisher == null) {
            publisher = new BlaisePublisher();
        }
        return publisher;
    }

    public void publish(String projectId, String topicId, BlaiseMessage message) throws IOException, ExecutionException, InterruptedException {
        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            publisher = Publisher.newBuilder(topicName).build();

            BlaiseMessage bMessage = bootstrapMessage(message);

            ByteString data = ByteString.copyFromUtf8(mapper.writeValueAsString(bMessage));

            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data)
                    .putAttributes("mainSurveyId", this.mainSurveyId).build();

            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            log.info("Published message ID: {}", messageId);

        } finally {
            if (publisher != null) {
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }

    }

    private BlaiseMessage bootstrapMessage(BlaiseMessage message) {
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        message.setMainSurveyId(this.mainSurveyId);

        return message;
    }

    public void setMainSurveyId(String mainSurveyId) {
        this.mainSurveyId = mainSurveyId;
    }

}
