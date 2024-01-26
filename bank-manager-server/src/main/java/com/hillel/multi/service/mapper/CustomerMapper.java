package com.hillel.multi.service.mapper;

import com.hillel.model.CustomerDTO;
import com.hillel.multi.persistent.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerEntity toEntity(CustomerDTO customerDTO);
    CustomerDTO toDTO(CustomerEntity customerEntity);

    List<CustomerDTO> toDTOList(List<CustomerEntity> customerEntityList);

}