package model.dose;

import common.CommonDose;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TotalDose extends CommonDose {
    private int multiDayDose;      //多日剂量
    private int dailyLimitDose;    //日限制剂量
    private int cumulativeDose;    //积累剂量

    public static TotalDose create(GeneralDose data) {
        TotalDose totalDose = new TotalDose();
        totalDose.multiDayDose = data.getDailyDose() * data.getMedicationDays();
        totalDose.dailyLimitDose = data.getDailyDose();
        totalDose.cumulativeDose = data.getDailyDose() * data.getMedicationDays();
        return totalDose;
    }

    public static TotalDose create(ConcentrationDose data) {
        TotalDose totalDose = new TotalDose();
        totalDose.multiDayDose = data.getDailyDose() * data.getMedicationDays();
        totalDose.dailyLimitDose = data.getDailyDose();
        totalDose.cumulativeDose = data.getDailyDose() * data.getMedicationDays();
        return totalDose;
    }
}
