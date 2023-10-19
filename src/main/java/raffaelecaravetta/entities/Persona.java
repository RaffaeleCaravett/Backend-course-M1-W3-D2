package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Sesso;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "people")

public class Persona {
    @Id // Serve per definire chi sarà la chiave primaria
    @GeneratedValue // Si usa se si vuol far gestire gli id al DB
    // private UUID id; // UUID genera come id una stringa univoca
    private long id; // long genera come id un intero di tipo serial (autoincrementante)

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "cognome")
    private String cognome;


    @Column(name = "email")
    private String email;

    @Column(name = "data_nascita")
    private Date dataNascita;

    @Enumerated(EnumType.STRING)
    @Column(name = "sesso")
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    @OrderBy("persona ASC")
    private List<Partecipazione> partecipazioni; // Non viene creato a DB, serve
    // solo lato Java per permetterci di ottenere la lista di tutti i blog
    // scritti da un certo utente


    @ManyToMany
    @JoinTable(name = "gare_persone",
        joinColumns = @JoinColumn(name = "persona_id"),
        inverseJoinColumns = @JoinColumn(name = "gara_id"))
    private Set<GaraDiAtletica> gare;
    public Persona(){}

    public Persona(long id, String nome, String cognome, String email, Date dataNascita, Sesso sesso, List<Partecipazione> partecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.partecipazioni = partecipazioni;
        this.gare = gare;
    }

    public long getId() {
        return id;
    }

    public Set<GaraDiAtletica> getGare() {
        return gare;
    }

    public void setGare(Set<GaraDiAtletica> gare) {
        this.gare = gare;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getBlogPosts() {
        return partecipazioni ;
    }

    public void setBlogPosts(List<Partecipazione> blogPosts) {
        this.partecipazioni = blogPosts;
    }


    @Override
    public String toString() {
        return "Persona{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", cognome='" + cognome + '\'' +
            ", email='" + email + '\'' +
            ", dataNascita=" + dataNascita +
            ", sesso=" + sesso +
            ", blogPosts=" + partecipazioni  +
            '}';
    }
}
