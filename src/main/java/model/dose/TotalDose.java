package model.dose;

public class TotalDose extends CommonDose {
    private int multiDayDose;      //多日剂量
    private int dailyLimitDose;    //日限制剂量
    private int cumulativeDose;    //积累剂量

    public int getMultiDayDose() {
        return getDailyDose() * getMedicationDays();
    }

    public int getDailyLimitDose() {
        return getDailyDose();
    }

    public int getCumulativeDose() {
        return getDailyDose() * getMedicationDays();
    }
}
