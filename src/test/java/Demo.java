import common.Message;
import constant.FrequencyUnit;
import constant.Gender;
import constant.PatientId;
import model.Drug;
import model.DrugTaboo;
import model.Patient;
import model.Prescription;
import model.dose.ConcentrationDose;
import model.dose.GeneralDose;
import model.dose.KidneyDamageDose;
import model.dose.LiverDamageDose;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        Patient patient = Patient.create(PatientId.OTHER, Gender.MALE, 20);
        patient.setDiseases(Arrays.asList("发烧", "多器官功能失常综合症"));
        patient.setAllergies(Arrays.asList("咖啡因", "过敏体质"));

        //药品信息
        List<Drug> drugs = new ArrayList<>();
        //溶媒
        ConcentrationDose concentrationDose = ConcentrationDose.create(FrequencyUnit.EVERY_DAY, 50, 2, -1);
        concentrationDose.setSolventAmount(100);
        concentrationDose.setSolventName("0.9%氯化钠注射液");
        drugs.add(Drug.create("血必净注射液",
                Arrays.asList("多器官功能失常综合症", "全身炎症反应综合症"),
                Collections.emptyList(),
                DrugTaboo.create(false, true, true, false, false, Arrays.asList("过敏体质")),
                GeneralDose.create(FrequencyUnit.UNKNOWN, 0, 0, 0),
                Arrays.asList(concentrationDose),
                KidneyDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                LiverDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                true
        ));

        GeneralDose generalDose = GeneralDose.create(FrequencyUnit.EVERY_DAY, 1, 2, -1);
        drugs.add(Drug.create("去痛片",
                Arrays.asList("发热", "疼痛"),
                Arrays.asList("氨基比林", "非那西丁", "咖啡因", "苯巴比妥"),
                DrugTaboo.create(false, false, false, true, false, Collections.emptyList()),
                generalDose,
                Arrays.asList(ConcentrationDose.create(FrequencyUnit.UNKNOWN, 0, 0, 0)),
                KidneyDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                LiverDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                true
        ));

        drugs.add(Drug.create("维生素BT片",
                Arrays.asList("腹胀", "嗳气", "恶心", "胃灼热"),
                Collections.emptyList(),
                DrugTaboo.create(false, false, false, false, false, Collections.emptyList()),
                generalDose,
                Arrays.asList(ConcentrationDose.create(FrequencyUnit.UNKNOWN, 0, 0, -1)),
                KidneyDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                LiverDamageDose.create(FrequencyUnit.UNKNOWN, 0, 0),
                true
        ));

        Prescription prescription = Prescription.create(drugs,patient);
        doseReview(prescription);
        drugAndPatientReview(prescription);
        drugReview(prescription);
        allergyReview(prescription);

        if (Message.messages.size() <= 0) System.out.println("审核通过");
        Message.messages.forEach((k, v) -> System.out.println(k + "     " + v));
    }

    private void doseReview(Prescription prescription) {
        KieSession kieSession = getSession("dose");
        kieSession.insert(prescription);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    private void drugAndPatientReview(Prescription prescription) {
        KieSession kieSession = getSession("drugAndPatient");
        kieSession.insert(prescription);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    private void drugReview(Prescription prescription) {
        KieSession kieSession = getSession("drug");
        kieSession.insert(prescription);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    private void allergyReview(Prescription prescription) {
        KieSession kieSession = getSession("patient");
        kieSession.insert(prescription);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
