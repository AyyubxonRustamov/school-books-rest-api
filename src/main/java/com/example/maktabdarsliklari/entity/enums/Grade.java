package com.example.maktabdarsliklari.entity.enums;

public enum Grade {

    BIRINCHI(1), IKKINCHI(2), UCHINCHI(3), TORTINCHI(4),
    BESHINCHI(5), OLTINCHI(6), YETTINCHI(7), SAKKIZINCHI(8),
    TOQQIZINCHI(9), ONINCHI(10), ONBIRINCHI(11);

    private int number;

    Grade(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Grade getByNumber(int number){
        for (Grade grade : Grade.values()) {
            if (grade.getNumber() == number)
                return grade;
        }
        return null;
    }


}
