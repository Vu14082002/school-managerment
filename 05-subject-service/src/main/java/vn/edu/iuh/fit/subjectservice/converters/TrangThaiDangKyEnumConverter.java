package vn.edu.iuh.fit.subjectservice.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.subjectservice.enums.TrangThaiDangKyEnum;

@Converter(autoApply = true)
public class TrangThaiDangKyEnumConverter implements AttributeConverter<TrangThaiDangKyEnum, String> {

    @Override
    public String convertToDatabaseColumn(TrangThaiDangKyEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public TrangThaiDangKyEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TrangThaiDangKyEnum.fromValue(dbData);
    }
}
