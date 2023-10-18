package raffaelecaravetta;

import raffaelecaravetta.entities.Evento;
import raffaelecaravetta.entities.EventoDAO;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {

         /*   EventoDAO eventoDAO = new EventoDAO(em);
            System.out.println("Hello World!");

            List<TipoEvento> tipoEvento = new ArrayList<>();
            tipoEvento.add(TipoEvento.PRIVATO);
            tipoEvento.add(TipoEvento.PUBBLICO);

            for (int i = 0; i <= 10; i++) {
                Random random = new Random();
                int randomNumber = random.nextInt(2);

                Date endDate = new Date();
                Date startDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(365));
                long range = endDate.getTime() - startDate.getTime();
                Random random1 = new Random();

                long randomMilliseconds = (long) (random.nextDouble() * range);

                //
                Date randomDate = new Date(startDate.getTime() + randomMilliseconds);


                Evento evento = new Evento("Evento" + i, randomDate.toString(), tipoEvento.get(randomNumber), 10 + i);
                eventoDAO.save(evento);

            }
            Evento eventoFromDB = eventoDAO.getById(6);
            if (eventoFromDB != null){
                System.out.println(eventoFromDB);
            }else{
                System.err.println("L'evento che stai ricercando non esiste");
            }


            // 3. Find By Id And Delete
            eventoDAO.delete(6);

            // 4. Esempio di refresh
            eventoDAO.refresh(144);*/

            
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }
    }
}
