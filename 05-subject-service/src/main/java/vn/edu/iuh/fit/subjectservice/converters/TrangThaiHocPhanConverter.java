package vn.edu.iuh.fit.subjectservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiHocPhanEnum;

@Converter(autoApply = true)
public class TrangThaiHocPhanConverter implements AttributeConverter<TrangThaiHocPhanEnum, String> {

    @Override
    public String convertToDatabaseColumn(TrangThaiHocPhanEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public TrangThaiHocPhanEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TrangThaiHocPhanEnum.fromValue(dbData);
    }
}
