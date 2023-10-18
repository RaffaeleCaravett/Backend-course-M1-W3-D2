package raffaelecaravetta.entities;

import javax.persistence.*;

public class Location {
    @Id // Serve per definire chi sarà la chiave primaria
    @GeneratedValue // Si usa se si vuol far gestire gli id al DB
    // private UUID id; // UUID genera come id una stringa univoca
    private long id; // long genera come id un intero di tipo serial (autoincrementante)

    @Column(name = "nome")
    private String nome;

    @Column(name = "città")
    private String città;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false) // <-- CHIAVE SECONDARIA
    private Evento evento;

    public Location(){}
    public Location( String nome, String città) {
        this.nome = nome;
        this.città = città;
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

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", città='" + città + '\'' +
            ", evento=" + evento +
            '}';
    }
}
