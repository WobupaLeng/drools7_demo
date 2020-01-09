package model.dose;

import common.CommonDose;
import constant.FrequencyUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConcentrationDose extends CommonDose {
    private int drugAmount;         //药量
    private String solventName;     //溶媒
    private int solventAmount;      //溶媒量
    private int speed;              //补液速度

    public static ConcentrationDose create(FrequencyUnit unit, int eachDose, int frequency) {
        ConcentrationDose dose = new ConcentrationDose();
        if (eachDose <= 0) {
            dose.setDailyDose(-1);
        }

        if (unit.canEveryMinute()) {
            dose.setDailyDose(eachDose * 3600 * 24 * frequency);
        }
        if (unit.canPerHour()) {
            dose.setDailyDose(eachDose * 24 * frequency);
        }
        if (unit.canEveryDay()) {
            dose.setDailyDose(eachDose * frequency);
        }
        if (unit.canPerMonth()) {
            dose.setDailyDose(eachDose / 30 * frequency);
        }
        if (unit.canPerYear()) {
            dose.setDailyDose(eachDose / 12 / 30 * frequency);
        }
        dose.setEachDose(eachDose);
        dose.setFrequency(frequency);
        dose.setFrequencyUnit(unit);
        return dose;
    }
}
