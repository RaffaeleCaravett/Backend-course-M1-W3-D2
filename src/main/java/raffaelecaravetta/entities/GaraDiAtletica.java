package raffaelecaravetta.entities;

import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {


    @ManyToMany
    @JoinTable(name = "gare_persone",
        joinColumns = @JoinColumn(name = "gara_id"),
        inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;
    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, status, numeroMassimoPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
