package no.ssb.survey.surveycommons.codelist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Status {
    SURVEY("Survey"),
    RECRUITMENT("Recruitment"),
    DIARY("Diary"),
    QUESTIONNAIRE("Questionnaire");

    String value;
}
