package com.example.food.services;

import com.example.food.services.helpers.DbFieldsParser;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface ModelMapperService {
    default void map(Object src, Object dest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(src, dest);
    }

    default void map(List src, List dest) {
        dest.addAll(src);
    }

    default void mapListMapToDto(List<Map<String, Object>> src, List dest, Class dtoClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < src.size(); i++) {
            Map<String, Object> map = src.get(i);
            Object objectDto = dtoClass.getConstructor().newInstance();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String parsedField = DbFieldsParser.getDtoFieldFromDb(entry.getKey());
                String dtoField = parsedField == null ? entry.getKey() : parsedField;
                Field field = null;
                try {
                    field = dtoClass.getDeclaredField(dtoField);
                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                field.set(objectDto, entry.getValue());
            }
            dest.add(objectDto);
        }
    }
}
