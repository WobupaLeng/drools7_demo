package model.dose;

import common.CommonDose;
import constant.FrequencyUnit;

public class LiverDamageDose extends CommonDose {
    public static LiverDamageDose create(FrequencyUnit unit, int eachDose, int frequency) {
        LiverDamageDose dose = new LiverDamageDose();
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
