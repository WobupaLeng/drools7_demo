package model;

import lombok.Data;

@Data
public class Drug {
    private String indication;          //适应症
    private String taboo;               //禁忌
    private boolean pregnantWoman;      //孕妇用药
    private boolean child;              //儿童用药
    private boolean elderly;            //老年人用药
    private String interaction;         //药物相互作用

}
