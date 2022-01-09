package com.furkanyesilyurt.springbootex.controller;

import com.furkanyesilyurt.springbootex.dto.AddressDto;
import com.furkanyesilyurt.springbootex.service.entityService.AddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
