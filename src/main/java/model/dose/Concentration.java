package model.dose;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Concentration extends CommonDose {
    private int drugAmount;         //药量
    private String solventName;     //溶媒
    private int solventAmount;      //溶媒量
    private int speed;              //补液速度
}
