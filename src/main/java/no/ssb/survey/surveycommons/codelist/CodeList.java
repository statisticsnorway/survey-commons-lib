package no.ssb.survey.surveycommons.codelist;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@AllArgsConstructor
public class CodeList {

    public static final Map<String, CodeInfo> status = Map.ofEntries(
            /**
             * recruitment codes
             */
            entry("FINISHED", new CodeInfo("Ferdig/avsluttet", List.of(Status.SURVEY, Status.DIARY, Status.QUESTIONNAIRE))),
            entry("STARTED", new CodeInfo("Påbegynt",List.of(Status.SURVEY, Status.DIARY, Status.QUESTIONNAIRE))),
            entry("NOT_STARTED", new CodeInfo("Ikke påbegynt",List.of(Status.RECRUITMENT, Status.SURVEY, Status.DIARY, Status.QUESTIONNAIRE))),

            entry("INTERVIEWED", new CodeInfo("Intervjuet",List.of(Status.SURVEY))),
            entry("LOGININFO_SENT", new CodeInfo("Innloggingsinformasjon sendt",List.of(Status.SURVEY))),

            entry("01", new CodeInfo("Rekruttert",List.of(Status.RECRUITMENT))),
            entry("02", new CodeInfo("Påbegynt",List.of(Status.RECRUITMENT))),
            entry("03", new CodeInfo("Ikke påbegynt",List.of(Status.RECRUITMENT))),

            /**
             * drop-out codes
             */
            entry("11", new CodeInfo("Ikke tid",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("12", new CodeInfo("Ønsker ikke å delta",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("13", new CodeInfo("Hard nekt, trusler",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("14", new CodeInfo("Andre nekter for IO",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("15", new CodeInfo("Gir ikke samtykke",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("21", new CodeInfo("Kortvarig sykdom",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("22", new CodeInfo("Langvarig sykdom, svekkelse, psykisk utv hemmet ",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("23", new CodeInfo("Sykdom/dødsfall i familien, annen uforutsett hendelse",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("24", new CodeInfo("Språkproblemer",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("25", new CodeInfo("Midlertidig fraværende på grunn av skolegang/arbeid",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("26", new CodeInfo("Midlertidig fraværende på grunn av ferie ol.",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("27", new CodeInfo("Ikke internett, datamaskin el.",List.of(Status.SURVEY))),
            entry("44", new CodeInfo("Mangler kun  telefonnummer/feil telefonnummer",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("45", new CodeInfo("Ingen kontakt",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("46", new CodeInfo("Mangler både telefonnummer og epost",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("47", new CodeInfo("Mangler kun epost",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("71", new CodeInfo("Annen frafallsgrunn",List.of(Status.SURVEY, Status.RECRUITMENT))),

            /**
             * tranfer codes
             */
            entry("81", new CodeInfo("Intervjuer kjenner IO",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("82", new CodeInfo("Kapasitetsproblemer, sykdom ol hos intervjuer",List.of(Status.SURVEY, Status.RECRUITMENT))),

            /**
             * avgang (departure) codes
             */
            entry("91", new CodeInfo("Død",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("92", new CodeInfo("Bosatt i utlandet minst 6 mnd og i hele datafangsperioden",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("93", new CodeInfo("Bosatt i institusjon",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("94", new CodeInfo("Har ikke fast bopel",List.of(Status.SURVEY, Status.RECRUITMENT))),
            entry("99", new CodeInfo("Andre avgangsgrunner",List.of(Status.SURVEY, Status.RECRUITMENT)))

    );
}
