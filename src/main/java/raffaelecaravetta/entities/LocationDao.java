package raffaelecaravetta.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDao {

    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(location);

        transaction.commit();
        System.out.println("Nuova location salvata correttamente");
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delete(long id) {

        Location found = em.find(Location.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("La location con l'id " + id + " è stata cancellata correttamente");
        } else {
            System.err.println("La location con l'id " + id + " non è stata trovata");
        }
    }

    public void refresh(long id){
        Location locationFromDB2 = this.getById(id);
        if (locationFromDB2 != null) {
            locationFromDB2.setNome("Nuovo Nome");
            System.out.println("PRE REFRESH");
            System.out.println(locationFromDB2.toString());

            em.refresh(locationFromDB2);
            System.out.println("POST REFRESH");
            System.out.println(locationFromDB2.toString());
        }else{
            System.err.println("Impossibile eseguire il refresh sulla location con id " + id + " : non esiste!");
        }
    }
}


