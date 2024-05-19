package vn.edu.iuh.fit.subjectservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.HinhThucHocEnum;

@Converter(autoApply = true)
public class HinhThucHocEnumConverter implements AttributeConverter<HinhThucHocEnum, String> {

    @Override
    public String convertToDatabaseColumn(HinhThucHocEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public HinhThucHocEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return HinhThucHocEnum.fromValue(dbData);
    }
}
