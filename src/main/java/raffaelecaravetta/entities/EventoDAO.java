package raffaelecaravetta.entities;

import raffaelecaravetta.enums.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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
        Evento eventoFromDB2 = this.getById(id);
        if (eventoFromDB2 != null) {
            eventoFromDB2.setTitolo("Nuovo Titolo");
            System.out.println("PRE REFRESH");
            System.out.println(eventoFromDB2.toString());

            em.refresh(eventoFromDB2);
            System.out.println("POST REFRESH");
            System.out.println(eventoFromDB2.toString());
        }else{
            System.err.println("Impossibile eseguire il refresh sull'elemento con id " + id + " : non esiste!");
        }
    }


    public List<Concerto> getConcertiInStreaming(boolean bool){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :bool", Concerto.class);
        query.setParameter("bool", bool);


        return query.getResultList();

    }
    public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);

        return query.getResultList();
    }

    public void getPartiteVinteInCasa(String team) {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        query.setParameter("team", team);
        System.out.println("Lista di partite vinte in casa da " + team);
        query.getResultList().forEach(System.out::println);
        System.out.println("Numero totale partite vinte in casa : " +query.getResultList().size());
    }

    public void getPartiteVinteInTrasferta(String team) {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        query.setParameter("team", team);
        System.out.println("Lista di partite vinte in trasferta da " + team);
        query.getResultList().forEach(System.out::println);
        System.out.println("Numero totale partite vinte in trasferta : " +query.getResultList().size());
    }

}
