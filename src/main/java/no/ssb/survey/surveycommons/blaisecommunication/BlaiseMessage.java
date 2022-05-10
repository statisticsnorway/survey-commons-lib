package no.ssb.survey.surveycommons.blaisecommunication;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlaiseMessage {

    @NonNull
    private BlaiseMessageType type;

    @NonNull
    private String ioNumber;

    @NonNull
    private String password;

    @NonNull
    private String ioIdNumber;

    @NonNull
    private Timestamp timestamp;

    @NonNull
    private String mainSurveyId;
}
