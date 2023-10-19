package raffaelecaravetta.entities;


import raffaelecaravetta.enums.TipoEvento;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@NamedQuery(
    name = "getPartiteVinteInCasa",
    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente =  p.squadraDiCasa"
)
@NamedQuery(
    name = "getPartiteVinteInTrasferta",
    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente =  p.squadraOspite "
)
@NamedQuery(
    name = "getPartitePareggiate",
    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL "
)
public class PartitaDiCalcio extends Evento{


    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraCasa;
    private int numeroGolSquadraOspite;


    public PartitaDiCalcio() {
    }


    public PartitaDiCalcio(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, status, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public double getNumeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public double getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}
