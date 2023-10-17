package raffaelecaravetta.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(evento);

        transaction.commit();
        System.out.println("Nuovo evento salvato correttamente");
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {

        Evento found = em.find(Evento.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("L'evento' con l'id " + id + " è stato cancellato correttamente");
        } else {
            System.err.println("L'evento' con l'id " + id + " non è stato trovato");
        }
    }

    public void refresh(long id){
        Evento eventoFromDB2 = this.getById(6);
        if (eventoFromDB2 != null) {
            eventoFromDB2.setTitolo("Nuovo Titolo");
            System.out.println("PRE REFRESH");
            System.out.println(eventoFromDB2);

            em.refresh(eventoFromDB2);
            System.out.println("POST REFRESH");
            System.out.println(eventoFromDB2);
        }else{
            System.err.println("Impossibile eseguire il refresh sull'elemento con id " + id + " : non esiste!");
        }
    }
}
