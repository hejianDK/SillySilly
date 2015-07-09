package com.marlabs.trainee.utils.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

/**
 * Created by Rico on 7/7/15.
 */
@Converter
public class YearPersistenceConverter implements AttributeConverter<Year, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Year year) {
        return year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer integer) {
        return Year.of(integer);
    }
}
