package com.furkanyesilyurt.springbootex.service.entityService;

import com.furkanyesilyurt.springbootex.converter.AddressConverter;
import com.furkanyesilyurt.springbootex.dao.IAddressDao;
import com.furkanyesilyurt.springbootex.dto.Adress.AddressDto;
import com.furkanyesilyurt.springbootex.dto.Adress.AddressRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional // for deleteByPostalCode
@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final IAddressDao addressDao;

    public List<AddressDto> findAll(){
        List<Address> addressList = addressDao.findAll();
        return AddressConverter.INSTANCE.convertAllAdressesToAddressDtos(addressList);
    }

    public AddressDto findById(Long id){
        Optional<Address> optionalAddress = addressDao.findById(id);
        Address address = null;
        if(optionalAddress.isPresent()){
            address = optionalAddress.get();
        }
        return AddressConverter.INSTANCE.convertAddressToAddressDto(address);
    }

    public AddressDto findByPostalCode(String postalCode){
        var address = addressDao.findByPostalCode(postalCode);
        return AddressConverter.INSTANCE.convertAddressToAddressDto(address);
    }

    public AddressRegisterDto save(AddressRegisterDto addressRegisterDto){
        var address = AddressConverter.INSTANCE.convertAddressRegisterDtoToAddress(addressRegisterDto);
        address = addressDao.save(address);
        addressRegisterDto = AddressConverter.INSTANCE.INSTANCE.convertAddressToAddressRegisterDto(address);
        return addressRegisterDto;
    }

    public void deleteById(Long id){
        addressDao.deleteById(id);
    }

    @Transactional
    public void deleteByPostalCode(String postalCode){
        addressDao.deleteByPostalCode(postalCode);
    }

    public AddressDto updateAddress(AddressRegisterDto addressRegisterDto,Long id){
        var address = addressDao.findById(id).orElse(null);

        address.setAddress(addressRegisterDto.getAddress());
        address.setDistrict(addressRegisterDto.getDistrict());
        address.setPhoneNumber(addressRegisterDto.getPhoneNumber());
        address.setPostalCode(addressRegisterDto.getPostalCode());
        address = addressDao.save(address);

        var respaddressDto = AddressConverter.INSTANCE.convertAddressToAddressDto(address);
        return respaddressDto;
    }
}
