package vn.edu.iuh.fit.subjectservice.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.LoaiMonHocEnum;

@Converter(autoApply = true)
public class LoaiMonHocConverter implements AttributeConverter<LoaiMonHocEnum, String> {

    @Override
    public String convertToDatabaseColumn(LoaiMonHocEnum hocPhanEnum) {
        if (hocPhanEnum == null) {
            return null;
        }
        return LoaiMonHocEnum.toValue(hocPhanEnum);
    }

    @Override
    public LoaiMonHocEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return LoaiMonHocEnum.fromValue(dbData);
    }
}
