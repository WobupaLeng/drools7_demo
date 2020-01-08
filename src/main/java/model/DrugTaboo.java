package model;

import lombok.Data;

@Data
public class DrugTaboo {
    private boolean perioperative;      //围术期用药
    private boolean pregnantWoman;      //孕妇用药
    private boolean child;              //儿童用药
    private boolean elderly;            //老年人用药
    private boolean adult;              //成人用药
}
