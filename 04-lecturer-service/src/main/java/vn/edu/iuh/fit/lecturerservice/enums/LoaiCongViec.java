package vn.edu.iuh.fit.lecturerservice.enums;

public enum LoaiCongViec {
    GIANG_DAY("GIANG_DAY"),
    HUONG_DAN("HUONG_DAN"),
    THUC_TAP("THUC_TAP"),
    KHAC("KHAC");

    private String value;

    LoaiCongViec(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public  static LoaiCongViec fromValue(String value){
        for (LoaiCongViec loaiCongViec: LoaiCongViec.values()){
            if (loaiCongViec.value.equalsIgnoreCase(value)){
                return loaiCongViec;
            }
        }
        return KHAC;
    }
}

