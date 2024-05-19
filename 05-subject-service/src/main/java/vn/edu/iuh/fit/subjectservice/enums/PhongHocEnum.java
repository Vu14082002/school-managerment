package vn.edu.iuh.fit.subjectservice.enums;

public enum PhongHocEnum {
    PHONG_LY_THUYET("Phòng lý thuyết"),
    PHONG_THUC_HANH("Phòng thực hành"),
    PHONG_GIAO_VU("Phòng giáo vụ"),
    PHONG_HOI_THAO("Phòng hội thảo"),
    PHONG_SU_KIEN("Phòng sự kiện"),
    PHONG_HOP("Phòng họp"),
    PHONG_LAM_VIEC("Phòng làm việc"),
    PHONG_BAO_VE("Phòng bảo vệ"),
    PHONG_KHOA_HOC("Phòng khoa học"),
    PHONG_TIN_HOC("Phòng tin học"),
    PHONG_THI_NGHIEM("Phòng thí nghiệm"),
    PHONG_TAP_THE("Phòng tập thể"),
    PHONG_KHAC("Phòng khác");

    private final String value;

    PhongHocEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PhongHocEnum fromValue(String value) {
        for (PhongHocEnum phong : PhongHocEnum.values()) {
            if (phong.value.equals(value)) {
                return phong;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
