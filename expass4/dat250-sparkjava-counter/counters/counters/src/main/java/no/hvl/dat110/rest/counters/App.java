package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;
import entities.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
	
	static Counters counters = null;
	static Todo todo = null;

	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager manager = entityManagerFactory.createEntityManager();

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		counters = new Counters();
		manager.getTransaction().begin();
		todo = new Todo();
		todo.setSummary("Dette er en test");
		todo.setDescription("Test");
		manager.persist(todo);
		manager.getTransaction().commit();
		
		after((req, res) -> {
  		  res.type("application/json");
  		});
		
		get("/hello", (req, res) -> "Hello World!");
		
        get("/counters", (req, res) -> counters.toJson());
               
        put("/counters", (req,res) -> {
        
        	Gson gson = new Gson();
        	
        	counters = gson.fromJson(req.body(), Counters.class);
        
            return counters.toJson();
        	
        });

		/**
		 * CRUD-OPERATIONS
		 */

		// READ
		get("/todos/:id", (req, res) -> {
			manager.getTransaction().begin();
			todo = manager.find(Todo.class, new Long(req.params(":id")));
			manager.getTransaction().commit();
			return todo.toJson();
		});

		// UPDATE
		put("/todos", (req, res) -> {
			Todo t = new Gson().fromJson(req.body(), Todo.class);
			manager.getTransaction().begin();
			manager.merge(t);
			manager.getTransaction().commit();
			return t.toJson();
		});

		// ADD
		post("/todos", (req, res) -> {
			Todo add = new Gson().fromJson(req.body(), Todo.class);
			manager.getTransaction().begin();
			manager.persist(add);
			manager.getTransaction().commit();

			return add.toJson();
		});

		// DELETE
		delete("/todos", (req, res) -> {
			Todo del = new Gson().fromJson(req.body(), Todo.class);
			del = manager.find(Todo.class, del.getId());
			manager.getTransaction().begin();
			manager.remove(del);
			manager.getTransaction().commit();

			return del.toJson();
		});
    }
    
}
