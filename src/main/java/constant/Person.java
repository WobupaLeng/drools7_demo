package constant;

public enum Person implements SingleIntEnum {
    PREGNANT_WOMAN(1, "孕妇")
    ,CHILD(2, "儿童")
    ,ELDERLY(3, "老年人")
    ,ORDINARY(4,"普通人")
    ;

    private final String name;
    private final int value;

    public boolean isPregnantWoman(int value) {
        return PREGNANT_WOMAN.value == value;
    }

    public boolean isChild(int value) {
        return CHILD.value == value;
    }

    public boolean isElderly(int value) {
        return ELDERLY.value == value;
    }

    public Person judgeIdentity(int age) {
        if (age <= 14)
            return Person.CHILD;
        if (age >= 65)
            return Person.ELDERLY;
        return ORDINARY;
    }

    Person(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
