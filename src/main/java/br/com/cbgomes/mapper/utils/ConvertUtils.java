package br.com.cbgomes.mapper.utils;

import br.com.cbgomes.mapper.ModelMapperConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public record ConvertUtils<T>(ModelMapperConfiguration modelMapperConfiguration) {

    public List<T> convertToListResponse(List<T> response, Class<T> type) {
        return response
                .stream()
                .map(it -> new ModelMapper().map(it, type))
                .collect(Collectors.toList());
    }

    public T convertToRequest(T request, Class<T> target) {
        return modelMapperConfiguration.modelMapper().map(request, target);
    }

    public T convertToResponse(T entity, Class<T> target) {
        return modelMapperConfiguration.modelMapper().map(entity, target);
    }

    public T convertToEntity(T request, Class<T> entity) {
        return modelMapperConfiguration.modelMapper().map(request, entity);
    }
}
