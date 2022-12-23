package ma.emsi.ticketmatchproject.services;

import lombok.AllArgsConstructor;

import ma.emsi.ticketmatchproject.dto.TicketDto;
import ma.emsi.ticketmatchproject.entities.Match;
import ma.emsi.ticketmatchproject.entities.Ticket;
import ma.emsi.ticketmatchproject.enums.Statut;
import ma.emsi.ticketmatchproject.repos.MatchRepo;
import ma.emsi.ticketmatchproject.repos.TicketRepo;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TicketService implements ITicket {
    MatchRepo matchRepo;
    TicketRepo ticketRepo;
    @Override
    public Ticket acheterTicket(Long idMatch, TicketDto ticketDto) {
        Match match = matchRepo.findById(idMatch).orElse(null);
        if(match!=null){
            if(match.getTicketsDispo()>0){
                Ticket ticket = new Ticket();
                ticket.setReferenceTicket(ticketDto.getReferenceTicket());
                ticket.setPrix(ticketDto.getPrix());
                ticket.setStatut(Statut.ACTIF);
                ticket.setMatch(match);
                ticketRepo.save(ticket);
                match.setTicketsDispo(match.getTicketsDispo()-1);
                matchRepo.save(match);
                System.out.println("Ajout d'un ticket avec succes");
                return ticket;
            }
            return null  ;
        }
        return null;
    }

    @Override
    public boolean modifierStatutTicket(Long idticket) {
        Ticket ticket =ticketRepo.findById(idticket).orElse(null);
        if(ticket != null){
            ticket.setStatut(Statut.NO_ACTIF);
            ticketRepo.save(ticket);
            return true;
        }
        return false;
    }

    @Override
    public boolean supprimerTicket(Long idTicket) {
        Ticket ticket = ticketRepo.findById(idTicket).orElse(null);

        if (ticket!= null){

            Match match = matchRepo.findById(ticket.getMatch().getId()).orElse(null);
            match.setTicketsDispo(match.getTicketsDispo()+1);
            matchRepo.save(match);
            ticketRepo.delete(ticket);

            return true;
        }

        return false;
    }


}
