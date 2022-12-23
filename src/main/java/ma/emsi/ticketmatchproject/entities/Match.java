package ma.emsi.ticketmatchproject.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matchs")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 16,nullable = false,unique = true)
    private String referenceMatch;
    private Date dateMatch;
    private String lieuMatch;
    private String equipe1;
    private String equipe2;
    private int ticketsDispo=2022;

}
