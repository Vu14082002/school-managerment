package vn.edu.iuh.fit.subjectservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.HocKyEnum;

@Converter(autoApply = true)
public class HocKyEnumConverter implements AttributeConverter<HocKyEnum, String> {

    @Override
    public String convertToDatabaseColumn(HocKyEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public HocKyEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return HocKyEnum.fromValue(dbData);
    }
}
