package no.ssb.survey.surveycommons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationException extends RuntimeException {
    private final List<String> errors;
}
