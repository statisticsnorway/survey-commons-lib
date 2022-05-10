package no.ssb.survey.surveycommons.blaisecommunication;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BlaiseSubscriber {

    public static void subscribe(String projectId, String subscriptionId, BlaiseMessageHandler handler) {
        ProjectSubscriptionName subscriptionName =
                ProjectSubscriptionName.of(projectId, subscriptionId);

        // Instantiate an asynchronous message receiver.
        MessageReceiver receiver =
                (PubsubMessage message, AckReplyConsumer consumer) -> {
                    // Handle incoming message, then ack the received message.
                    System.out.println("Id: " + message.getMessageId());
                    System.out.println("Data: " + message.getData().toStringUtf8());
                    handler.process(message);
                    consumer.ack();
                };

        Subscriber subscriber = null;
        subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
        // Start the subscriber.
        subscriber.startAsync().awaitRunning();
        log.info("Listening for messages on {}:\n", subscriptionName);
    }

    public static void subscribeAll(String projectId, List<String> subscriptionIds, BlaiseMessageHandler handler) {
        subscriptionIds.forEach(subscriptionId -> subscribe(projectId, subscriptionId, handler));

    }
}
