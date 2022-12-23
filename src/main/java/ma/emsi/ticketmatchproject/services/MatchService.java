package ma.emsi.ticketmatchproject.services;

import lombok.AllArgsConstructor;
import ma.emsi.ticketmatchproject.dto.MatchDto;
import ma.emsi.ticketmatchproject.entities.Match;
import ma.emsi.ticketmatchproject.repos.MatchRepo;
import ma.emsi.ticketmatchproject.repos.TicketRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class MatchService implements IMatch {

    MatchRepo matchRepo;
    TicketRepo ticketRepo;

    @Override
    public Match ajouterMatch(MatchDto matchDto) {
        Match match = new Match();
        match.setReferenceMatch(matchDto.getReferenceMatch());
        match.setDateMatch(matchDto.getDateMatch());
        match.setLieuMatch(matchDto.getLieuMatch());
        match.setEquipe1(matchDto.getEquipe1());
        match.setEquipe2(matchDto.getEquipe2());
        matchRepo.save(match);
        System.out.println("Ajout d'un match avec succes");
        return match;
    }



    @Override
    public boolean supprimerMatch(Long id) {
            Match match = matchRepo.findById(id).orElse(null);
            if(match != null){
                matchRepo.delete(match);
                System.out.println("Suppression d'un match avec succes");
                System.out.println("Reference : "+match.getReferenceMatch());
                return true;
            }
            return false;
    }

    public List<Match> getAllMatchs(){
        return matchRepo.findAll();
    }
}
