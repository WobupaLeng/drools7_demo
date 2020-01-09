package model;

import lombok.Data;
import model.dose.*;

import java.util.Collection;

@Data
public class Prescription {
    private Collection<Drug> drugs;             //药品
    private Patient patient;                    //患者
    private boolean authorizedMedication;       //越权用药
    private int drugCount;                      //药品数量

    public static Prescription create(Collection<Drug> drugs) {
        Prescription prescription = new Prescription();
        prescription.authorizedMedication = drugs.stream().allMatch(Drug::isMedicationAuthority);
        prescription.drugCount = drugs.size();
        return prescription;
    }
}
