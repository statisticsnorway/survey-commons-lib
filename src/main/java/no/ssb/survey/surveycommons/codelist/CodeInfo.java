package no.ssb.survey.surveycommons.codelist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeInfo {
    private String value;
    private List<Status> types;
}
