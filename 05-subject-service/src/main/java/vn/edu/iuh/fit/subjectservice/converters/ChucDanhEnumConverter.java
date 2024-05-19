package vn.edu.iuh.fit.subjectservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.ChucDanhEnum;

@Converter(autoApply = true)
public class ChucDanhEnumConverter implements AttributeConverter<ChucDanhEnum, String> {

    @Override
    public String convertToDatabaseColumn(ChucDanhEnum attribute) {
        if (attribute == null) {
            return ChucDanhEnum.toValue(ChucDanhEnum.NCS);
        }
        return ChucDanhEnum.toValue(attribute);
    }

    @Override
    public ChucDanhEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return ChucDanhEnum.fromValue(dbData);
    }
}
