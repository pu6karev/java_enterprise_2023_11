package com.hillel.multi.service.mapper;

import com.hillel.model.AccountDTO;
import com.hillel.multi.persistent.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    AccountEntity toEntity(AccountDTO accountDTO);
    AccountDTO toDTO(AccountEntity accountEntity);

    List<AccountDTO> toDTOList(List<AccountEntity> accountEntityList);
}
