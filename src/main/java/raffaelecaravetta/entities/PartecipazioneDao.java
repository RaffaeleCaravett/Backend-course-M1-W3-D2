package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Stato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDao {

    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(partecipazione);

        transaction.commit();
        System.out.println("Nuova partecipazione salvata correttamente");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(long id) {

        Partecipazione found = em.find(Partecipazione.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("La partecipazione con l'id " + id + " è stata cancellata correttamente");
        } else {
            System.err.println("La partecipazione con l'id " + id + " non è stata trovata");
        }
    }

    public void refresh(long id){
        Partecipazione partecipazioneFromDB2 = this.getById(id);
        if (partecipazioneFromDB2 != null) {
            partecipazioneFromDB2.setStato(Stato.CONFERMATA);
            System.out.println("PRE REFRESH");
            System.out.println(partecipazioneFromDB2.toString());

            em.refresh(partecipazioneFromDB2);
            System.out.println("POST REFRESH");
            System.out.println(partecipazioneFromDB2.toString());
        }else{
            System.err.println("Impossibile eseguire il refresh sulla partecipazione con id " + id + " : non esiste!");
        }
    }
}


