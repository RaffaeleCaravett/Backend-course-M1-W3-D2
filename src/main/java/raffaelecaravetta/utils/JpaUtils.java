package raffaelecaravetta.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory = null;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("simplejpa");
        }catch (Throwable ex){
            System.out.println("Initial EntityManagerFactory creation failed."+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

}
