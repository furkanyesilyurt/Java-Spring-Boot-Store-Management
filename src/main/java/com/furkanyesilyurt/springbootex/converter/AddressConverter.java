package com.furkanyesilyurt.springbootex.converter;

import com.furkanyesilyurt.springbootex.dto.AddressDto;
import com.furkanyesilyurt.springbootex.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressConverter {

    AddressConverter INSTANCE = Mappers.getMapper(AddressConverter.class);

//   @Mapping(source = "address_id", target = "address_id")
    List<AddressDto> convertAllAdressesToAddressDtos(List<Address> address);
}
