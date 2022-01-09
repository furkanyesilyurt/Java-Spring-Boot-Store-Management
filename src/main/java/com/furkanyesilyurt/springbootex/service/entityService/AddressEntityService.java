package com.furkanyesilyurt.springbootex.service.entityService;

import com.furkanyesilyurt.springbootex.converter.AddressConverter;
import com.furkanyesilyurt.springbootex.dao.IAddressDao;
import com.furkanyesilyurt.springbootex.dto.AddressDto;
import com.furkanyesilyurt.springbootex.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final IAddressDao addressDao;

    public List<AddressDto> findAll(){
        List<Address> addressList = addressDao.findAll();
        return AddressConverter.INSTANCE.convertAllAdressesToAddressDtos(addressList);
        //AddressConverter.INSTANCE.convertAdressListToAddressDtoList(addressList);
    }
}
