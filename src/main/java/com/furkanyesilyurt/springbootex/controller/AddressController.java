package com.furkanyesilyurt.springbootex.controller;

import com.furkanyesilyurt.springbootex.dto.Adress.AddressDto;
import com.furkanyesilyurt.springbootex.dto.Adress.AddressRegisterDto;
import com.furkanyesilyurt.springbootex.service.entityService.AddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressEntityService addressEntityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AddressDto>> findAll(){
        var addressDtos = addressEntityService.findAll();
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AddressDto> findById(@PathVariable Long id){
        var addressDto = addressEntityService.findById(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/postalCode/{postalCode}", method = RequestMethod.GET)
    public ResponseEntity<AddressDto> findByPostalCode(@PathVariable String postalCode){
        var addressDto = addressEntityService.findByPostalCode(postalCode);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<AddressRegisterDto> save(@RequestBody AddressRegisterDto addressRegisterDto){
        var respaddressDto = addressEntityService.save(addressRegisterDto);
        return new ResponseEntity<>(respaddressDto,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        addressEntityService.deleteById(id);
    }

    @RequestMapping(value = "/postal/{postalCode}", method = RequestMethod.DELETE)
    public void deleteByPostalCode(@PathVariable String postalCode){
        addressEntityService.deleteByPostalCode(postalCode);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AddressDto> update(@RequestBody AddressRegisterDto addressRegisterDto,@PathVariable Long id){
        var respAddressDto= addressEntityService.updateAddress(addressRegisterDto,id);
        return new ResponseEntity<>(respAddressDto, HttpStatus.OK);
    }
}
