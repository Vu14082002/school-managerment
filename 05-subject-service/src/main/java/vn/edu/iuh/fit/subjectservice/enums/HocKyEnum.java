package vn.edu.iuh.fit.subjectservice.enums;

public enum HocKyEnum {
    HOC_KY1("HK1"),
    HOC_KY2("HK2"),
    HOC_KY3("HK3");

    private final String value;

    HocKyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HocKyEnum fromValue(String hocKy) {
        for (HocKyEnum hk : HocKyEnum.values()) {
            if (hk.value.equals(hocKy)) {
                return hk;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + hocKy);
    }

    public static String toValue(HocKyEnum hocKy) {
        return hocKy.getValue();
    }
}
