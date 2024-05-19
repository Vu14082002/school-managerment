package vn.edu.iuh.fit.lecturerservice.enums;

public enum TrangThai {
    DANG_DAY("DANG_DAY"),
    NGHI_HUU("NGHI_HUU"),
    NGHI_SINH("NGHI_SINH"),
    NGHI_KHAC("NGHI_KHAC");
     String value;
     TrangThai(String value) {
         this.value = value;
     }
     public static TrangThai fromValue(String value) {
         for (TrangThai trangThai : TrangThai.values()) {
             if (trangThai.value.equalsIgnoreCase(value)) {
                 return trangThai;
             }
         }
         return NGHI_KHAC;
     }
}
