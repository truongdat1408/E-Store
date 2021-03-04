package com.truongdat.estore.service.serviceImpl;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MapperEntityAndDTO {
    static private ModelMapper modelMapper = new ModelMapper();

    static public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    static public <S, T> T map(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }
}
