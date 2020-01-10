package model;

import constant.AgeStandard;
import constant.Gender;
import constant.PatientId;
import lombok.Data;

import java.util.Collection;

@Data
public class Patient {
    private PatientId patientId;               //患者标识
    private Collection<String> diseases;       //疾病
    private Collection<String> allergies;      //过敏
    private Gender gender;                     //性别
    private AgeStandard ageStandard;
    private int age;                           //年龄

    public static Patient create(PatientId patientId, Gender gender, int age) {
        Patient patient = new Patient();
        if (patientId.isPregnantWoman()) {
            patient.gender = Gender.FEMALE;
        } else {
            patient.gender = gender;
        }
        patient.ageStandard = AgeStandard.ageJudge(age);
        patient.patientId = patientId;
        return patient;
    }
}
