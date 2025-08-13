import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;

    @Before
    public void setup() {
        person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(Person.ofYear(2000)); // idade > 18 nos anos atuais
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
        person.setSalary(0f);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary(), 0.0001f);
    }

    @Test
    public void person_is_MEI() {
        // Ajusta dados para satisfazer as regras do MEI
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(5000f); // 5000 * 12 = 60000 < 130000

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Deixa alguma regra inválida (ex.: possui outra empresa)
        person.setAnotherCompanyOwner(true);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(1000f); // salário anual baixo, mas falha pela empresa

        assertFalse(person.isMEI());
    }
}
