package ma.emsi.ticketmatchproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MatchDto {

    private String referenceMatch;
    private Date dateMatch;
    private String lieuMatch;
    private String equipe1;
    private String equipe2;
}
