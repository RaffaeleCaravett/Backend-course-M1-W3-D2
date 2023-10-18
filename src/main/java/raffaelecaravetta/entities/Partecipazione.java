package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Sesso;
import raffaelecaravetta.enums.Stato;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "partecipations")
public class Partecipazione {
    @Id // Serve per definire chi sarà la chiave primaria
    @GeneratedValue // Si usa se si vuol far gestire gli id al DB
    // private UUID id; // UUID genera come id una stringa univoca
    private long id; // long genera come id un intero di tipo serial (autoincrementante)

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private Stato stato;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "events_partecipations",
        joinColumns = @JoinColumn(name = "partecipation_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Evento> eventoSet;
    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Set<Evento> getEventoSet() {
        return eventoSet;
    }

    public void setEventoSet(Set<Evento> eventoSet) {
        this.eventoSet = eventoSet;
    }

    public long getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
            "id=" + id +
            ", persona=" + persona +
            ", evento=" + evento +
            ", stato=" + stato +
            ", eventoSet=" + eventoSet +
            '}';
    }
}
