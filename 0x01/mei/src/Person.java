import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    // Atributos privados
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;

    // Atributo salary (float) + getters/setters requisitados
    private float salary;
    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    // Construtor padrão
    public Person() {}

    // Métodos utilitários para configuração (facilitam os testes)
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) { this.anotherCompanyOwner = anotherCompanyOwner; }
    public void setPensioner(boolean pensioner) { this.pensioner = pensioner; }
    public void setPublicServer(boolean publicServer) { this.publicServer = publicServer; }

    // fullName = "name surname"
    public String fullName() {
        String n = (name == null ? "" : name);
        String s = (surname == null ? "" : surname);
        return (n + " " + s).trim();
    }

    // Salário anual = salary * 12
    public float calculateYearlySalary() {
        return salary * 12.0f;
    }

    // Cálculo de idade (em anos) a partir da birthDate
    private int calculateAge() {
        if (birthDate == null) return 0;
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // Ajuste se ainda não fez aniversário no ano corrente
        int currMonth = today.get(Calendar.MONTH);
        int birthMonth = dob.get(Calendar.MONTH);
        int currDay = today.get(Calendar.DAY_OF_MONTH);
        int birthDay = dob.get(Calendar.DAY_OF_MONTH);
        if (currMonth < birthMonth || (currMonth == birthMonth && currDay < birthDay)) {
            age--;
        }
        return age;
    }

    // isMEI: regras do enunciado
    // (salary * 12) < 130000
    // age > 18
    // anotherCompanyOwner == false
    // pensioner == false
    // publicServer == false
    public boolean isMEI() {
        float yearly = calculateYearlySalary();
        int age = calculateAge();
        return yearly < 130000.0f
                && age > 18
                && !anotherCompanyOwner
                && !pensioner
                && !publicServer;
    }

    // Factory/helper para facilitar data de ano inteiro (usa 1º de janeiro daquele ano)
    public static Date ofYear(int year) {
        return new GregorianCalendar(year, Calendar.JANUARY, 1).getTime();
    }
}
