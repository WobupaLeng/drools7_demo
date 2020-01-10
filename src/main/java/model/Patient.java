package model;

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
    private int age;                           //年龄
}
