package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Sesso;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private List<Partecipazione> blogPosts; // Non viene creato a DB, serve
    // solo lato Java per permetterci di ottenere la lista di tutti i blog
    // scritti da un certo utente

    public Persona(){}

    public Persona( String nome, String cognome, String email, Date dataNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
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
        return blogPosts;
    }

    public void setBlogPosts(List<Partecipazione> blogPosts) {
        this.blogPosts = blogPosts;
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
            ", blogPosts=" + blogPosts +
            '}';
    }
}
