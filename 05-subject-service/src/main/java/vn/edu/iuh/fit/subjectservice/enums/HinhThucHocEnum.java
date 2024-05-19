package vn.edu.iuh.fit.subjectservice.enums;

public enum HinhThucHocEnum {
    LT("Lý thuyết"),
    TH("Thực hành"),
    ONLINE("Online"),
    THI("Thi");

    private final String value;

    HinhThucHocEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HinhThucHocEnum fromValue(String value) {
        for (HinhThucHocEnum hinhThucHoc : HinhThucHocEnum.values()) {
            if (hinhThucHoc.value.equals(value)) {
                return hinhThucHoc;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }

    public static String toValue(HinhThucHocEnum hinhThucHoc) {
        return hinhThucHoc.getValue();
    }
}
