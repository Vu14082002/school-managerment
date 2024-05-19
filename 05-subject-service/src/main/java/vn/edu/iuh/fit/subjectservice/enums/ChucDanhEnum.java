package vn.edu.iuh.fit.subjectservice.enums;

public enum ChucDanhEnum {
    NCS("Nghiên cứu sinh"),
    THAC_SI("Thạc sĩ"),
    TIEN_SI("Tiến sĩ"),
    GIAO_SU("Giáo sư");

    private final String value;

    ChucDanhEnum(String value) {
        this.value = value;
    }

    public static String toValue(ChucDanhEnum chucDanh) {
        return chucDanh.value;
    }

    public static ChucDanhEnum fromValue(String value) {
        for (ChucDanhEnum chucDanh : ChucDanhEnum.values()) {
            if (chucDanh.value.equals(value)) {
                return chucDanh;
            }
        }
        return NCS;
    }
}
