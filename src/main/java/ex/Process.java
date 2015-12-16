package ex;

import com.sample.persistence.Sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Process {
    public static void main(String[] args){
        System.out.println("Process run");
        EntityManager manager = getEm();

        Sample sample = new Sample();
        sample.setTitle ("new Book");

        Sample sample1 = new Sample();
        sample1.setTitle ("new Book1");


        manager.getTransaction().begin();
        manager.persist(sample);
        manager.persist(sample1);
        manager.getTransaction().commit();

//        manager.find(Sample.class,sample );
//        manager.persist(sample);
//        manager.close();

        System.out.println("Process end");
    }

    private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
