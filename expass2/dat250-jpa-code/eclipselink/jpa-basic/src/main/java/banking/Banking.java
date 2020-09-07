package banking;

import banking.entities.*;
import no.hvl.dat250.jpa.basicexample.Todo;

import javax.persistence.*;
import java.util.List;

public class Banking {
    private static EntityManagerFactory factory;
    private static final String PERSISTENCE_NAME = "Banking";

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from Person t");
        List<Person> list = q.getResultList();
        for (Person p : list) {
            System.out.println(p);
        }
        System.out.println("Size: " + list.size());


        em.getTransaction().begin();
        Person person = new Person();
        person.setName("Andrè");
        em.persist(person);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Bank bank = new Bank();
        bank.setName("Sparebank 1");
        em.persist(bank);
        em.getTransaction().commit();

        em.getTransaction().begin();
        PinCode pin = new PinCode();
        pin.setPincode(1234);
        em.persist(pin);
        em.getTransaction().commit();

        em.getTransaction().begin();
        CreditCard card = new CreditCard();
        card.setBalance(250000);
        card.setBank(bank);
        card.setPinCode(pin);
        em.persist(card);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Address address = new Address();
        address.setStreet("Lille Damsgårdsveien");
        address.setNumber(10);
        em.persist(address);
        person.setAddress(address);
        person.setCreditCard(card);
        em.getTransaction().commit();

        em.close();

    }
}
