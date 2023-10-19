package raffaelecaravetta;

import raffaelecaravetta.entities.*;
import raffaelecaravetta.enums.Genere;
import raffaelecaravetta.enums.Sesso;
import raffaelecaravetta.enums.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D4");
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

           /* Persona persona = new Persona("Raffaele","Caravetta","raffaeleCaravetta13@gmail.com",dataNascita, Sesso.M);
            PersonaDao personaDao= new PersonaDao(em);
            personaDao.save(persona);


            Location location = new Location("Eventissimo","Cosenza");
            LocationDao locationDao= new LocationDao(em);

            location.setEvento(evento);
       eventoDAO.save(evento);
            locationDao.save(location);
*/


            Concerto concerto = new Concerto("concerto del cuore",randomDate.toString(),TipoEvento.PRIVATO,50, Genere.POP,true);
            Concerto concerto1 = new Concerto("concerto del cuore",randomDate.toString(),TipoEvento.PUBBLICO,50, Genere.CLASSICO,false);


            PartitaDiCalcio partita1 = new PartitaDiCalcio("Partita 1", randomDate.toString(), TipoEvento.PUBBLICO, 100,
                "Team C", "Team A", "Team A", 3, 1);

            PartitaDiCalcio partita2 = new PartitaDiCalcio("Partita 2", randomDate.toString(), TipoEvento.PUBBLICO, 200,
                "Team B", "Team D",null, 2, 2);






           /* GaraDiAtletica gara1 = new GaraDiAtletica("Gara 1", "2023-10-20", TipoEvento.PUBBLICO, 100, new HashSet<>(), null);
            GaraDiAtletica gara2 = new GaraDiAtletica("Gara 2", "2023-10-21", TipoEvento.PRIVATO, 50, new HashSet<>(), null);
            GaraDiAtletica gara3 = new GaraDiAtletica("Gara 3", "2023-10-22", TipoEvento.PUBBLICO, 200, new HashSet<>(), null);
            GaraDiAtletica gara4 = new GaraDiAtletica("Gara 4", "2023-10-23", TipoEvento.PRIVATO, 75, new HashSet<>(), null);
            GaraDiAtletica gara5 = new GaraDiAtletica("Gara 5", "2023-10-24", TipoEvento.PUBBLICO, 150, new HashSet<>(), null);
            GaraDiAtletica gara6 = new GaraDiAtletica("Gara 6", "2023-10-25", TipoEvento.PRIVATO, 80, new HashSet<>(), null);
            GaraDiAtletica gara7 = new GaraDiAtletica("Gara 7", "2023-10-26", TipoEvento.PUBBLICO, 120, new HashSet<>(), null);
            GaraDiAtletica gara8 = new GaraDiAtletica("Gara 8", "2023-10-27", TipoEvento.PRIVATO, 60, new HashSet<>(), null);
            GaraDiAtletica gara9 = new GaraDiAtletica("Gara 9", "2023-10-28", TipoEvento.PUBBLICO, 250, new HashSet<>(), null);
            GaraDiAtletica gara10 = new GaraDiAtletica("Gara 10", "2023-10-29", TipoEvento.PRIVATO, 90, new HashSet<>(), null);
*/



            eventoDAO.getConcertiInStreaming(false).forEach(System.out::println);
            System.out.println("-----------------");
            eventoDAO.getConcertiPerGenere(Genere.CLASSICO).forEach(System.out::println);
            System.out.println("-----------------");
            eventoDAO.getPartiteVinteInCasa();
            System.out.println("-----------------");
            eventoDAO.getPartiteVinteInTrasferta();
            System.out.println("-----------------");
            eventoDAO.getPartitePareggiate();
            System.out.println("-----------------");
            PersonaDao personaDao= new PersonaDao(em);




eventoDAO.getGareDiAtleticaPerVincitore (personaDao.getById(200));
            eventoDAO.getGareDiAtleticaPerPartecipante(personaDao.getById(247));

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
    public static Persona getRandomPersona(Set<Persona> personaEvenSet) {
        List<Persona> personaList = new ArrayList<>(personaEvenSet);
        if (!personaList.isEmpty()) {
            int randomIndex = new Random().nextInt(personaList.size());

            return personaList.get(randomIndex);
        } else {
            return null;
        }
    }
}
