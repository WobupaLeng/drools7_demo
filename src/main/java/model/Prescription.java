package model;

import lombok.Data;
import model.dose.ConcentrationDose;
import model.dose.GeneralDose;
import model.dose.KidneyDamageDose;
import model.dose.LiverDamageDose;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Prescription {
    private Collection<Drug> drugs;
    private Patient patient;

    private int drugCount;
    private boolean authorizedMedication;
    private boolean doseReasonable;
    private boolean drugTabooReasonable;
    private boolean indicationReasonable;
    private boolean interactionReasonable;
    private boolean allergyReasonable;

    public static Prescription create(Collection<Drug> drugs, Patient patient) {
        Prescription prescription = new Prescription();
        prescription.drugs = drugs;
        prescription.patient = patient;
        prescription.drugCount = drugs.size();
        prescription.authorizedMedication = drugs.stream().allMatch(Drug::isMedicationAuthority);
        prescription.doseReasonable = doseReasonable(drugs);
        prescription.drugTabooReasonable = drugTabooReasonable(drugs, patient);
        prescription.indicationReasonable = indicationReasonable(drugs, patient);
        prescription.interactionReasonable = interactionReasonable(drugs);
        prescription.allergyReasonable = allergyReasonable(drugs, patient);
        return prescription;
    }

    private static boolean doseReasonable(Collection<Drug> drugs) {
        for (Drug drug : drugs) {
            GeneralDose generalDose = drug.getGeneralDose();
            Collection<ConcentrationDose> concentrationDose = drug.getConcentrationDose();
            KidneyDamageDose kidneyDamageDose = drug.getKidneyDamageDose();
            LiverDamageDose liverDamageDose = drug.getLiverDamageDose();
            //TODO 处方中药品剂量与规则设定剂量比较
            //可以返回int类型百分比数值，根据数值不同，返回不同信息
        }
        return true;
    }

    private static boolean drugTabooReasonable(Collection<Drug> drugs, Patient patient) {
        boolean isChild = patient.getAgeStandard().isChild();
        boolean isAdult = patient.getAgeStandard().isAdult();
        boolean isElderly = patient.getAgeStandard().isElderly();
        boolean isPerioperative = patient.getPatientId().isPerioperative();
        boolean isPregnantWoman = patient.getPatientId().isPregnantWoman();

        for (Drug drug : drugs) {
            DrugTaboo taboo = drug.getDrugTaboo();
            if (taboo.isChild() && isChild)
                return false;
            if (taboo.isAdult() && isAdult)
                return false;
            if (taboo.isElderly() && isElderly)
                return false;
            if (taboo.isPerioperative() && isPerioperative)
                return false;
            if (taboo.isPregnantWoman() && isPregnantWoman)
                return false;
        }
        return true;
    }

    private static boolean indicationReasonable(Collection<Drug> drugs, Patient patient) {
        List<String> indicationList = drugs.stream()
                .map(Drug::getIndications)
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<String> diseaseList = new ArrayList<>(patient.getDiseases());
        diseaseList.retainAll(indicationList);
        return diseaseList.size() > 0;
    }

    private static boolean interactionReasonable(Collection<Drug> drugs) {
        List<String> nameList = drugs.stream()
                .map(Drug::getDrugName)
                .collect(Collectors.toList());
        List<String> interactionList = drugs.stream()
                .map(Drug::getInteractions)
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        nameList.retainAll(interactionList);
        return nameList.size() == 0;
    }

    private static boolean allergyReasonable(Collection<Drug> drugs, Patient patient) {
        List<String> allergyList = new ArrayList<>(patient.getAllergies());
        List<String> extendTabooList = drugs.stream()
                .map(s -> s.getDrugTaboo().getExtendTaboo())
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        allergyList.retainAll(extendTabooList);
        return allergyList.size() == 0;
    }
}
