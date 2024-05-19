package vn.edu.iuh.fit.subjectservice.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.PhongHocEnum;

@Converter(autoApply = true)
public class PhongHocEnumConverter implements AttributeConverter<PhongHocEnum, String> {

    @Override
    public String convertToDatabaseColumn(PhongHocEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public PhongHocEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return PhongHocEnum.fromValue(dbData);
    }
}
