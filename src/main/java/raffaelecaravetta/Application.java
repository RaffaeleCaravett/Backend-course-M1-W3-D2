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

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {

            EventoDAO eventoDAO = new EventoDAO(em);
            System.out.println("Hello World!");
            List<Date> dateList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Date date = new Date();
                dateList.add(date);
            }

            List<TipoEvento> tipoEvento = new ArrayList<>();
            tipoEvento.add(TipoEvento.PRIVATO);
            tipoEvento.add(TipoEvento.PUBBLICO);

            for (int i = 0; i <= 10; i++) {
                Random random = new Random();
                int randomNumber = random.nextInt(2);
                // 1. Salvataggio nuovo evento
                Evento evento = new Evento("Evento" + i, dateList.get(i).toString(), tipoEvento.get(randomNumber), 10 + i);
                eventoDAO.save(evento);

                // 2. Find By Id
                Evento eventoFromDB = eventoDAO.getById(6);
                if (eventoFromDB != null)
                    System.out.println(eventoFromDB);

                // 3. Find By Id And Delete
                eventoDAO.delete(5);

                // 4. Esempio di refresh
eventoDAO.refresh(10);
            }
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }
    }
}
