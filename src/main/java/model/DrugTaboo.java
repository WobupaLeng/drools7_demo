package model;

import lombok.Data;

import java.util.Collection;

@Data
public class DrugTaboo {
    private boolean perioperative;      //围术期用药
    private boolean pregnantWoman;      //孕妇用药
    private boolean child;              //儿童用药
    private boolean elderly;            //老年人用药
    private boolean adult;              //成人用药
    private Collection<String> extendTaboo;

    public static DrugTaboo create(boolean perioperative, boolean pregnantWoman, boolean child,
                                   boolean elderly, boolean adult, Collection<String> extendTaboo) {
        DrugTaboo drugTaboo = new DrugTaboo();
        drugTaboo.perioperative = perioperative;
        drugTaboo.pregnantWoman = pregnantWoman;
        drugTaboo.child = child;
        drugTaboo.elderly = elderly;
        drugTaboo.adult = adult;
        drugTaboo.extendTaboo = extendTaboo;
        return drugTaboo;
    }
}
