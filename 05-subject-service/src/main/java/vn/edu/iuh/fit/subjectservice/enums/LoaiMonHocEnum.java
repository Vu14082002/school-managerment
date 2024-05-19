package vn.edu.iuh.fit.subjectservice.enums;

public enum LoaiMonHocEnum {
    TU_CHON("Tự chọn"),
    BAT_BUOC("Bắt buộc");

    private String hocPhan;

    LoaiMonHocEnum(String hocPhan) {
        this.hocPhan = hocPhan;
    }

    public static LoaiMonHocEnum fromValue(String hocPhan) {
        for (LoaiMonHocEnum hp : LoaiMonHocEnum.values()) {
            if (hp.hocPhan.equals(hocPhan)) {
                return hp;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + hocPhan);
    }

    public static String toValue(LoaiMonHocEnum hocPhan) {
        return hocPhan.hocPhan;
    }
}
