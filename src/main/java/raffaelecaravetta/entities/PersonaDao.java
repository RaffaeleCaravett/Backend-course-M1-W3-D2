package raffaelecaravetta.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonaDao {

    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(persona);

        transaction.commit();
        System.out.println("Nuova persona salvata correttamente");
    }

    public  Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(long id) {

        Persona found = em.find(Persona.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("La persona con l'id " + id + " è stata cancellata correttamente");
        } else {
            System.err.println("La persona con l'id " + id + " non è stata trovata");
        }
    }

    public void refresh(long id){
        Persona personaFromDB2 = this.getById(id);
        if (personaFromDB2 != null) {
            personaFromDB2.setNome("Nuovo Nome");
            System.out.println("PRE REFRESH");
            System.out.println(personaFromDB2.toString());

            em.refresh(personaFromDB2);
            System.out.println("POST REFRESH");
            System.out.println(personaFromDB2.toString());
        }else{
            System.err.println("Impossibile eseguire il refresh sulla persona con id " + id + " : non esiste!");
        }
    }


    public Set<Long> findAllEvenPersonaIds() {
        TypedQuery<Long> getPersonaIdsQuery = em.createQuery("SELECT p.id FROM Persona p WHERE p.id %2=0", Long.class); // Query JPQL
        List<Long> idList = getPersonaIdsQuery.getResultList();
        return new HashSet<>(idList);
    }
    public Set<Long> findAllOddsPersonaIds() {
        TypedQuery<Long> getPersonaIdsQuery = em.createQuery("SELECT p.id FROM Persona p WHERE p.id %2!=0", Long.class); // Query JPQL
        List<Long> idList = getPersonaIdsQuery.getResultList();
        return new HashSet<>(idList);
    }
}

