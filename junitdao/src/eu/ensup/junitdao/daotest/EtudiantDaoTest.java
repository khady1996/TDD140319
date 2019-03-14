package eu.ensup.junitdao.daotest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ensup.junitdao.dao.EtudiantDao;
import eu.ensup.junitdao.domaine.Etudiant;
import junit.framework.TestCase;

public class EtudiantDaoTest extends TestCase{
	
	EtudiantDao etud = null;

	@Before
	public void setUp() throws Exception {
		
		etud = new EtudiantDao();
	}
	

	@After
	public void tearDown() throws Exception {
		
		etud = null;
	}
	
	@Test
	public void testscenarioCreationEtudiant() {
		
		int result = etud.createEtudiant(new Etudiant(2, "FALL", "Yacine", "yfall@gmail.com"));
		
		assertNotEquals(0,result);
	}

	@Test
	public void testscenarioLectureEtudiantbyId() {
		assertNotNull("Cet étudiant existe dans votre base", etud.readEtudiantbyId(1));
	}
	
	@Test
	public void testscenarioModificationEtudiant() {
		assertSame("OK", etud.updateEtudiant(new Etudiant(1, "FALL", "Khady", "kfall@gmail.com")));
	}
	
	@Test
	public void testscenarioSuppressionEtudiant() {
		int result = etud.deleteEtudiantbyId(2);
		assertNotEquals(0,result);
	}
	
	@Test
	public void testscenarioLectureListeEtudiants() {
		int result = etud.getAll().size();
		assertEquals(5,result);
	}

}
