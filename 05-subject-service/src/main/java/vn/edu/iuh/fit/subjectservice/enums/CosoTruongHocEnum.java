package vn.edu.iuh.fit.subjectservice.enums;

public enum CosoTruongHocEnum {
    CS1("CS1"),
    CS2("CS2"),
    CS3("CS3");

    private String value;

    CosoTruongHocEnum(String value) {
        this.value = value;
    }
   public static CosoTruongHocEnum fromValue(String value) {
        for (CosoTruongHocEnum cosoTruongHocEnum : CosoTruongHocEnum.values()) {
            if (cosoTruongHocEnum.value.equals(value)) {
                return cosoTruongHocEnum;
            }
        }
        return CS1;
    }

   public static String toValue(CosoTruongHocEnum cosoTruongHocEnum) {
        return cosoTruongHocEnum.value;
    }
}
