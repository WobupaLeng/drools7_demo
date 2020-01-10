package service;

import model.Drug;

import java.util.Collection;

public class JudgeService {
    public static boolean judgeInteraction(Collection<Drug> drugs) {
        drugs.forEach(s-> System.out.println(s.getDrugName()));
        return false;
    }
}
