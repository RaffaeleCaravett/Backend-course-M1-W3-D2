package raffaelecaravetta.entities;


import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento{


    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private double numeroGolSquadraCasa;
    private double numeroGolSquadraOspite;


    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, String dataEvento, TipoEvento status, double numeroMassimoPartecipanti) {
        super(titolo, dataEvento, status, numeroMassimoPartecipanti);
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

    public void setNumeroGolSquadraCasa(double numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public double getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(double numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}
