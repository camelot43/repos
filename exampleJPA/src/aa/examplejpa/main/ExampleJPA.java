/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



https://www.caelum.com.br/apostila-java-web/uma-introducao-pratica-ao-jpa-com-hibernate/#14-12-buscando-com-uma-clausula-where


 */
package aa.examplejpa.main;

import aa.examplejpa.model.Task;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aanciaes
 */
public class ExampleJPA {

    private static void generateTables() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");

        factory.close();
    }

    private static void insertTask() {

        Task tarefa = new Task();
        tarefa.setDescDesc("Estudar JPA");
        tarefa.setDone(false);
        tarefa.setDoneDate(Calendar.getInstance());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(tarefa);
        manager.getTransaction().commit();

        System.out.println("ID da tarefa: " + tarefa.getId());

        manager.close();
        factory.close();

    }

    private static void searchTask() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");
        EntityManager manager = factory.createEntityManager();

        Task encontrada = manager.find(Task.class, 1);

        System.out.println(encontrada.getDescDesc());

        //manager.close();
        factory.close();

    }

    private static void removeTask() {

        Task tarefa = new Task();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");
        EntityManager manager = factory.createEntityManager();

        tarefa = manager.find(Task.class, 1);

        System.out.println("Task found: " + tarefa.getDescDesc());
        System.out.println("Removing Task: " + tarefa.getId());

        manager.getTransaction().begin();
        manager.remove(tarefa);
        manager.getTransaction().commit();

        System.out.println("Removed");

        manager.close();
        factory.close();

    }

    private static void updateTask() {

        insertTask();

        Task tarefa = new Task();
        tarefa.setId(2); //esse id já existe no banco
        tarefa.setDescDesc("Estudar JPA e Hibernate");
        tarefa.setDone(true);
        tarefa.setDoneDate(Calendar.getInstance());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(tarefa);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

    private static void queryTask_1() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasksPU");
        EntityManager manager = factory.createEntityManager();

        List<Task> lista = manager
                .createQuery("select t from Task as t where t.done = false")
                .getResultList();

        for (Task tarefa : lista) {
            System.out.println(tarefa.getDescDesc());
        }

        manager.close();
        factory.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //generateTables();
        //insertTask();
        //searchTask();
        //removeTask();
        //updateTask();
        queryTask_1();

        System.out.println("aa.examplejpa.main.ExampleJPA.main()" + "Existing...");
    }

}
