import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.Year;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<LocalDate, Year> {

    @Override
    public Year convertToDatabaseColumn(LocalDate attribute) {
        return Year.from(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Year dbData) {
        return dbData.atDay(1);
    }
}
