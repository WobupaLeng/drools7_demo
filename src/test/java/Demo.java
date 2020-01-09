import common.CommonDose;
import common.Message;
import constant.FrequencyUnit;
import constant.Gender;
import constant.PatientId;
import model.*;
import model.dose.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    private KieSession getSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newKieSession("all-rules");
    }

    private KieSession getSession(String agendaGroupName) {
        KieSession session = this.getSession();
        if (StringUtils.isNoneBlank(agendaGroupName)) {
            session.getAgenda().getAgendaGroup(agendaGroupName).setFocus();
        }
        return session;
    }

    @Test
    public void test() {
        Patient patient = new Patient();
        patient.setAge(20);
        patient.setGender(Gender.FEMALE);
        patient.setPatientId(PatientId.OTHER);
        //set 过敏药物

        List<String> indications = Arrays.asList("aa", "bb", "cc");
        List<String> interactions = Arrays.asList("a", "b", "c");
        DrugTaboo drugTaboo = new DrugTaboo();
        drugTaboo.setChild(false);
        drugTaboo.setPregnantWoman(false);

        List<Drug> drugs = new ArrayList<>();
        drugs.add(Drug.create(indications,
                interactions,
                drugTaboo,
                GeneralDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                ConcentrationDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                KidneyDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                LiverDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                TotalDose.create(ConcentrationDose.create(FrequencyUnit.UNKNOWN, 0, 0)),
                false
        ));
        //drugs.add(Drug.create());
        //drugs.add(Drug.create());
        //drugs.add(Drug.create());
        //drugs.add(Drug.create());
        //drugs.add(Drug.create());


        Prescription prescription = Prescription.create(drugs);
        prescription.setPatient(patient);

        //剂量
        doseReview(prescription);
        //禁忌
        drugTabooReview(prescription);
        //适应症
        indicationReview(prescription);
        //相互作用
        interactionReview(prescription);
        //用药权限
        medicationAuthorityReview(prescription);
        //患者身份
        patientReview(prescription);

        if (Message.messages.size() > 0) System.out.println("审核通过");
        Message.messages.forEach((k, v) -> System.out.println(k + "==" + v));
    }

    private void doseReview(Prescription prescription) {
        KieSession kieSession = getSession("dose");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

    private void drugTabooReview(Prescription prescription) {
        KieSession kieSession = getSession("drugTaboo");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

    private void indicationReview(Prescription prescription) {
        KieSession kieSession = getSession("indication");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

    private void interactionReview(Prescription prescription) {
        KieSession kieSession = getSession("interaction");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

    private void medicationAuthorityReview(Prescription prescription) {
        KieSession kieSession = getSession("medicationAuthority");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

    private void patientReview(Prescription prescription) {
        KieSession kieSession = getSession("patient");
        kieSession.insert(prescription);
        kieSession.dispose();
    }

}
