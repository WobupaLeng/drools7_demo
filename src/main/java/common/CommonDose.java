package common;

import constant.FrequencyUnit;
import lombok.Data;

@Data
public class CommonDose {
    private int eachDose;                   //每次剂量
    private int dailyDose;                  //每日剂量
    private int frequency;                  //频率次数
    private FrequencyUnit frequencyUnit;    //频率单位
    private int medicationDays;             //用药天数
}
