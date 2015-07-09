package com.marlabs.trainee.utils.converters;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

@Converter
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        return java.sql.Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        return databaseValue.toLocalDate();
    }


}