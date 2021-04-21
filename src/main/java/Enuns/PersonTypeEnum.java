package Enuns;

public enum PersonTypeEnum {
    PHYSICAL(1), JURIDICAL(2);

    private Integer personType;
    private PersonTypeEnum(int personType) {
        this.personType = personType;
    }

    public int getValue() {
        return personType;
    }
}
