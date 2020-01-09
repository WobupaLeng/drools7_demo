import model.Car;
import model.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Demo {
    public KieSession getSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newKieSession("all-rules");
    }

    public KieSession getSession(String agendaGroupName) {
        KieSession session = this.getSession();
        if (StringUtils.isNoneBlank(agendaGroupName)) {
            session.getAgenda().getAgendaGroup(agendaGroupName).setFocus();
        }
        return session;
    }

    @Test
    public void test() {
        KieSession kieSession = getSession("demo");

        Person p1 = new Person();
        p1.setAge(20);
        Car car = new Car();
        car.setPerson(p1);

        kieSession.insert(car);

        int count = kieSession.fireAllRules();

        System.out.println(count);
        System.out.println(car.getDiscount());

        kieSession.dispose();
    }

    public void doseReview() {
        KieSession kieSession = getSession("dose");

    }

    public void drugTabooReview() {
        KieSession kieSession = getSession("drugTaboo");

    }

    public void indicationReview() {
        KieSession kieSession = getSession("indication");

    }

    public void interactionReview() {
        KieSession kieSession = getSession("interaction");

    }

    public void medicationAuthorityReview() {
        KieSession kieSession = getSession("medicationAuthority");

    }

    public void patientReview() {
        KieSession kieSession = getSession("patient");

    }

}
