package priscille.pglp_5_1;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
/**
 * Tests unitaires de la classe Personnel.
 *
 */
public class PersonnelTest {
	/**
	 * Test du constructeur.
	 */
	@Test
	public void test() {
		ArrayList<String> numTel = new ArrayList<String>();
    	numTel.add("0123456789");
    	numTel.add("0987654321");
        Personnel p = new Personnel.Builder("Daoulas", "Priscille", LocalDate.of(1996, 05, 23), numTel).build();
        p.print();
	}
}
