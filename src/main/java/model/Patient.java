package model;

import constant.Gender;
import constant.PatientId;
import lombok.Data;

@Data
public class Patient {
    private PatientId patientId;         //患者标识
    private String allergy;              //过敏
    private Gender gender;               //性别
    private int age;                     //年龄
}
