package vn.edu.iuh.fit.subjectservice.enums;

public enum TrangThaiDangKyEnum {
    DK_MOI("Đăng ký mới"),
    DK_LAI("Đăng ký lại"),
    HUY("Hủy");

    private final String value;

    TrangThaiDangKyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TrangThaiDangKyEnum fromValue(String value) {
        for (TrangThaiDangKyEnum trangThai : TrangThaiDangKyEnum.values()) {
            if (trangThai.value.equals(value)) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
    public static String toValue(TrangThaiDangKyEnum trangThai) {
        return trangThai.value;
    }
}
