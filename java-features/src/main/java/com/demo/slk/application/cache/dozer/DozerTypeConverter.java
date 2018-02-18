package com.demo.slk.application.cache.dozer;

import org.apache.camel.Exchange;
import org.apache.camel.NoTypeConversionAvailableException;
import org.dozer.DozerBeanMapper;

public class DozerTypeConverter {
	private DozerBeanMapper mapper;

    public DozerTypeConverter(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T convertTo(Class<T> type, Object value) {
        return mapper.map(value, type);
    }

    public <T> T convertTo(Class<T> type, Exchange exchange, Object value) {
        return convertTo(type, value);
    }

    public <T> T mandatoryConvertTo(Class<T> type, Object value) throws NoTypeConversionAvailableException {
        return convertTo(type, value);
    }

    public <T> T mandatoryConvertTo(Class<T> type, Exchange exchange, Object value) throws NoTypeConversionAvailableException {
        return convertTo(type, value);
    }

    public <T> T tryConvertTo(Class<T> type, Object value) {
        try {
            return convertTo(type, value);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T tryConvertTo(Class<T> type, Exchange exchange, Object value) {
        try {
            return convertTo(type, value);
        } catch (Exception e) {
            return null;
        }
    }
}
