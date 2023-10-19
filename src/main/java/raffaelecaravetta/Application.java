package raffaelecaravetta;

import raffaelecaravetta.entities.*;
import raffaelecaravetta.enums.Sesso;
import raffaelecaravetta.enums.Stato;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dataNascita = dateFormat.parse("13-10-1994");
            EventoDAO eventoDAO = new EventoDAO(em);

            Date endDate = new Date();
            Date startDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(365));
            long range = endDate.getTime() - startDate.getTime();
            Random random1 = new Random();
            Random random = new Random();
            long randomMilliseconds = (long) (random.nextDouble() * range);

            //
            Date randomDate = new Date(startDate.getTime() + randomMilliseconds);
           // Evento evento = new Evento("Evento" , randomDate.toString(), TipoEvento.PRIVATO, 10);

            Persona persona = new Persona("Raffaele","Caravetta","raffaeleCaravetta13@gmail.com",dataNascita, Sesso.M);
            PersonaDao personaDao= new PersonaDao(em);
            personaDao.save(persona);



            Location location = new Location("Eventissimo","Cosenza");
            LocationDao locationDao= new LocationDao(em);

            //location.setEvento(evento);
       //   eventoDAO.save(evento);
            locationDao.save(location);


        //    Concerto concerto = new Concerto("concerto del cuore",randomDate);







         /*   Partecipazione partecipazione = new Partecipazione(persona,evento, Stato.CONFERMATA);
            PartecipazioneDao partecipazioneDao= new PartecipazioneDao(em);
            partecipazioneDao.save(partecipazione);


            Evento evento1= eventoDAO.getById(212);
            if(evento1!=null){
                System.out.println(evento1.getLocation());
                System.out.println(evento1.getPartecipazioni());

            }
            EventoDAO eventoDAO = new EventoDAO(em);
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
