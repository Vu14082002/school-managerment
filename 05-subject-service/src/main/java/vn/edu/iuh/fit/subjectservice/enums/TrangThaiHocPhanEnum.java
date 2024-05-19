package vn.edu.iuh.fit.subjectservice.enums;


public enum TrangThaiHocPhanEnum {
    LEN_KE_HOACH("LEN_KE_HOACH"),
    CHO_SINH_VIEN_DANG_KY("CHO_SINH_VIEN_DANG_KY"),
    CHAP_NHAN_MO_LOP("CHAP_NHAN_MO_LOP"),
    DA_KHOA("DA_KHOA");

    private final String value;

    TrangThaiHocPhanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TrangThaiHocPhanEnum fromValue(String value) {

        for (TrangThaiHocPhanEnum tingTrangHocPhanEnum : TrangThaiHocPhanEnum.values()) {
            if (tingTrangHocPhanEnum.value.equals(value)) {
                return tingTrangHocPhanEnum;
            }
        }
        return CHO_SINH_VIEN_DANG_KY;
    }
}
