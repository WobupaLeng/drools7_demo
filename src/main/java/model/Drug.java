package model;

import lombok.Data;

@Data
public class Drug {
    private String indication;          //适应症
    private String interaction;         //药物相互作用
    private DrugTaboo drugTaboo;        //禁忌
    private boolean medicationAuthority;//用药权限
}
