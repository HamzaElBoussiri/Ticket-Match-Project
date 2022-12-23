package ma.emsi.ticketmatchproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchTicketInfoDto {
    private String referenceMatch;
    private String equipe1;
    private String equipe2;
    private List<String> referenceTicket;
}

