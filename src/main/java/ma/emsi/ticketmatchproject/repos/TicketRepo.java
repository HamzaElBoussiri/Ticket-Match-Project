package ma.emsi.ticketmatchproject.repos;



import ma.emsi.ticketmatchproject.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
    List<Ticket> findByMatch_Id(Long idMatch);
}
