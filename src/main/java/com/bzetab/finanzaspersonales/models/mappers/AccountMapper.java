package com.bzetab.finanzaspersonales.models.mappers;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;
import com.bzetab.finanzaspersonales.models.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toAccountDto(Account account);

    @Mapping(target = "isActive", defaultValue = "true")
    Account toAccountEntity(AccountDto accountDto);
}
