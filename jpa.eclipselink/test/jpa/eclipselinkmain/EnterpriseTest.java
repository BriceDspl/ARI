package jpa.eclipselinkmain;

import static org.junit.Assert.assertTrue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jpa.eclipselink.model.Address;
import jpa.eclipselink.model.Employee;
import jpa.eclipselink.model.Enterprise;
import jpa.eclipselink.model.Project;
import jpa.eclipselink.model.Team;

import org.junit.Before;
import org.junit.Test;


public class EnterpriseTest {

	private static final String PERSISTENCE_UNIT_NAME = "people";
	private EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();

		// read the existing entries
		Query q = em.createQuery("select en FROM Enterprise en");
		// Enterprise should be empty

		// do we have entries?
		boolean createNewEnterprise = (q.getResultList().size() == 0);

		// No, so lets create new entries
		if (createNewEnterprise) {
			assertTrue(q.getResultList().size() == 0);
			Enterprise en= new Enterprise();
			en.setName("SNCF");
			//We add a employee on it
			Address lille = new Address("Lille");
			
			Employee billy = new Employee("Billy", "LeFort", "24", lille , en);
			en.addEmployee(billy);
			lille.setEmployee(billy);
			em.persist(en);
			em.persist(billy);
			em.persist(lille);

		}

		// Commit the transaction, which will cause the entity to
		// be stored in the database
		em.getTransaction().commit();

		// It is always good practice to close the EntityManager so that
		// resources are conserved.
		em.close();

	}

	@Test
	public void checkBeforeOk() {
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select en from Enterprise en");
		assertTrue(q.getResultList().size() == 1);
		em.close();
	}

	@Test
	public void checkAddEmployee() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query q1 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		Enterprise en = ((Enterprise) q1.getSingleResult());
		Address paris = new Address("Paris");
		Employee bob = new Employee("bob", "LeRob", "45", paris , en );
		en.addEmployee(bob);
		paris.setEmployee(bob);
		em.persist(bob);
		em.persist(paris);
		em.persist(en);
		em.getTransaction().commit();

		Query q2 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		assertTrue(((Enterprise) q2.getSingleResult()).getEmployees().size() > 1);
		em.close();
	}
	
	@Test
	public void checkAddProjectToBilly() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query q1 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		Enterprise en = ((Enterprise) q1.getSingleResult());
		Address paris = new Address("Paris");
		Employee bob = new Employee("bob", "LeRob", "45", paris , en );
		Project glop = new Project("Glop");
		bob.addProject(glop);
		glop.addEmployee(bob);
		en.addEmployee(bob);
		paris.setEmployee(bob);
		em.persist(glop);
		em.persist(bob);
		em.persist(paris);
		em.persist(en);
		em.getTransaction().commit();
		
		Query q2 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		assertTrue(((Enterprise) q2.getSingleResult()).getEmployees().get(1).getProjects().get(0) == glop);
		em.close();
		
	}
	
	@Test
	public void checkAddTeamAndProjectToBilly() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query q1 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		Enterprise en = ((Enterprise) q1.getSingleResult());
		Address paris = new Address("Paris");
		Employee bob = new Employee("bob", "LeRob", "45", paris , en );
		Project glop = new Project("Glop");
		Team devs = new Team("Devs");
		
		bob.setTeamEmployee(devs);
		bob.addProject(glop);
		glop.addEmployee(bob);
		en.addEmployee(bob);
		paris.setEmployee(bob);
		
		em.persist(glop);
		em.persist(bob);
		em.persist(devs);
		em.persist(paris);
		em.persist(en);
		em.getTransaction().commit();
		
		Query q2 = em.createQuery("select en from Enterprise en where en.name = :name").setParameter("name", "SNCF");
		System.out.println(((Enterprise)q2.getSingleResult()).getEmployees().get(1).getTeam());
		assertTrue(((Enterprise) q2.getSingleResult()).getEmployees().get(1).getTeam() != null);
		em.close();
		
	}

}