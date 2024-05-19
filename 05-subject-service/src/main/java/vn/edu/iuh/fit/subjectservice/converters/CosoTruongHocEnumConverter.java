package vn.edu.iuh.fit.subjectservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.CosoTruongHocEnum;

@Converter(autoApply = true)
public class CosoTruongHocEnumConverter implements AttributeConverter<CosoTruongHocEnum, String> {

    @Override
    public String convertToDatabaseColumn(CosoTruongHocEnum attribute) {
        if (attribute == null) {
            return CosoTruongHocEnum.toValue(CosoTruongHocEnum.CS1);
        }
        return  CosoTruongHocEnum.toValue(attribute);
    }

    @Override
    public CosoTruongHocEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return CosoTruongHocEnum.fromValue(dbData);
    }
}
