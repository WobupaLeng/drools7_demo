package model;

import lombok.Data;
import model.dose.*;

import java.util.Collection;

@Data
public class Drug {
    private String drugName;
    private Collection<String> indications;         //适应症
    private Collection<String> interactions;        //药物不良相互作用
    private DrugTaboo drugTaboo;                    //禁忌

    private GeneralDose generalDose;                //一般用剂量
    private Collection<ConcentrationDose> concentrationDose;    //注射用剂量
    private KidneyDamageDose kidneyDamageDose;      //肾脏损害剂量
    private LiverDamageDose liverDamageDose;        //肝损害剂量

    private boolean medicationAuthority;            //用药权限

    public static Drug create(String name, Collection<String> indications, Collection<String> interactions,
                              DrugTaboo drugTaboo, GeneralDose generalDose, Collection<ConcentrationDose> concentrationDose,
                              KidneyDamageDose kidneyDamageDose, LiverDamageDose liverDamageDose, boolean medicationAuthority) {
        Drug drug = new Drug();
        drug.drugName = name;
        drug.indications = indications;
        drug.interactions = interactions;
        drug.drugTaboo = drugTaboo;
        drug.generalDose = generalDose;
        drug.concentrationDose = concentrationDose;
        drug.kidneyDamageDose = kidneyDamageDose;
        drug.liverDamageDose = liverDamageDose;
        drug.medicationAuthority = medicationAuthority;
        return drug;
    }
}
