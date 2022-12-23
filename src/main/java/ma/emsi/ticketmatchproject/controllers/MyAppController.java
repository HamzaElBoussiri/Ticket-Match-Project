package ma.emsi.ticketmatchproject.controllers;

import lombok.AllArgsConstructor;
import ma.emsi.ticketmatchproject.dto.MatchDto;
import ma.emsi.ticketmatchproject.dto.TicketDto;
import ma.emsi.ticketmatchproject.entities.Match;
import ma.emsi.ticketmatchproject.entities.Ticket;
import ma.emsi.ticketmatchproject.services.MatchService;
import ma.emsi.ticketmatchproject.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(produces = "application/json",path = "controle")
public class MyAppController {
    MatchService matchService;
    TicketService ticketService;

    @GetMapping("allMatchs")
    public List<Match> getAllMatchs(){
        return matchService.getAllMatchs();
    }


    @PostMapping("/ajouterMatch")
    public Match addMatch(@RequestBody MatchDto matchDto){
        return matchService.ajouterMatch(matchDto);
    }


    @DeleteMapping("/supprmierMatch/{idMatch}")
    public boolean deleteMatch(@PathVariable Long idMatch){
        return matchService.supprimerMatch(idMatch);
    }


    @PostMapping("/acheterTicket/{idMatch}")
    public Ticket buyTicket(@PathVariable Long idMatch, @RequestBody TicketDto ticketDto){return
            ticketService.acheterTicket(idMatch, ticketDto);}


    @PutMapping("changerStatutTicket/{idTicket}")
    public boolean updateTicket(@PathVariable Long idTicket){
        return ticketService.modifierStatutTicket(idTicket);
    }


    @DeleteMapping("/supprimerTicket/{idTicket}")
    public boolean deleteTicket(@PathVariable Long idTicket){return ticketService.supprimerTicket(idTicket);}


}
