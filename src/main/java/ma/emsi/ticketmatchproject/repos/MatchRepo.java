package ma.emsi.ticketmatchproject.repos;


import ma.emsi.ticketmatchproject.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepo extends JpaRepository<Match,Long> {
    List<Match> findByticketsDispoEquals(int nbr);
}
