package ma.emsi.ticketmatchproject.services;

import ma.emsi.ticketmatchproject.dto.MatchDto;
import ma.emsi.ticketmatchproject.entities.Match;


public interface IMatch {
    public Match ajouterMatch(MatchDto matchDto);

    public boolean supprimerMatch(Long id);

}
