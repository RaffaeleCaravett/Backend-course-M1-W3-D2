package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Genere;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Concerto extends Evento {

    private Genere genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, status, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
