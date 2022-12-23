package ma.emsi.ticketmatchproject.services;


import ma.emsi.ticketmatchproject.dto.TicketDto;
import ma.emsi.ticketmatchproject.entities.Ticket;

public interface ITicket {
    public Ticket acheterTicket(Long idMatch, TicketDto ticketDto);
    public boolean modifierStatutTicket(Long idticket);
    public boolean supprimerTicket(Long idTicket);

}
