package com.furkanyesilyurt.springbootex.converter;

import com.furkanyesilyurt.springbootex.dto.Adress.AddressDto;
import com.furkanyesilyurt.springbootex.dto.Adress.AddressRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressConverter {

    AddressConverter INSTANCE = Mappers.getMapper(AddressConverter.class);

    List<AddressDto> convertAllAdressesToAddressDtos(List<Address> address);
    AddressDto convertAddressToAddressDto(Address address);
    Address convertAddressDtoToAddress(AddressDto addressDto);
    Address convertAddressRegisterDtoToAddress(AddressRegisterDto addressRegisterDto);
    AddressRegisterDto convertAddressToAddressRegisterDto(Address address);
}
