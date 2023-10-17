package raffaelecaravetta.entities;

import org.hibernate.annotations.GeneratorType;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;


@Entity
@Table(name = "events")
public class Evento {
    @Id // Serve per definire chi sarà la chiave primaria
    @GeneratedValue // Si usa se si vuol far gestire gli id al DB
    // private UUID id; // UUID genera come id una stringa univoca
    private long id; // long genera come id un intero di tipo serial (autoincrementante)

    @Column(name = "titolo", length = 255)
    private String titolo;

    @Column(name = "data_evento")
    private String dataEvento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TipoEvento status;

    @Column(name = "numero_massimo_partecipanti")
    private double numeroMassimoPartecipanti;

    public Evento() {
    }

    public Evento(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.status = status;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public TipoEvento getStatus() {
        return status;
    }

    public void setStatus(TipoEvento status) {
        this.status = status;
    }

    public double getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(double numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
