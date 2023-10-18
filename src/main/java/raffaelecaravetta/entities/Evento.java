package raffaelecaravetta.entities;

import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "events_partecipations",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "partecipation_id"))
    private Set<Partecipazione> partecipazioni; // Non viene creato a DB, serve
    // solo lato Java per permetterci di ottenere la lista di tutti i blog
    // scritti da un certo utente

    @OneToOne // 1 to 1 diventa così BIDIREZIONALE
    private Location location; // Questa non sarà una colonna della tabella
    // serve solo lato Java per permetterci di ottenere il documento
    // di un certo utente

    public Evento() {
    }

    public Evento(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.status = status;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Set<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "Evento{" +
            "id=" + id +
            ", titolo='" + titolo + '\'' +
            ", dataEvento='" + dataEvento + '\'' +
            ", status=" + status +
            ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
            '}';
    }

}
