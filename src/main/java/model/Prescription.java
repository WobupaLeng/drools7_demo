package model;

import constant.*;
import lombok.Data;

@Data
public class Prescription {
    private int drugCount;                      //药品数量
    private CommonDose commonDose;              //一般剂量
    private Concentration concentration;        //配伍浓度
    private TotalDose totalDose;                //总剂量
    private LiverDamageDose liverDamageDose;    //肝损害剂量
    private KidneyDamageDose kidneyDamageDose;  //肾损害剂量
    private boolean repeatMedication;           //重复用药
    private boolean unauthorizedMedication;     //越权用药

}
