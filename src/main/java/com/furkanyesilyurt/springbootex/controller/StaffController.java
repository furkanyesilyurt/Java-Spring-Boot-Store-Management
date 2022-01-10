package com.furkanyesilyurt.springbootex.controller;

import com.furkanyesilyurt.springbootex.dto.Staff.StaffDto;
import com.furkanyesilyurt.springbootex.dto.Staff.StaffRegisterDto;
import com.furkanyesilyurt.springbootex.service.entityService.StaffEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffEntityService staffEntityService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<StaffDto>> findAll(){
        var staffDtos = staffEntityService.findAll();
        return new ResponseEntity<>(staffDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StaffDto> findById(@PathVariable Long id){
        var staffDto = staffEntityService.findById(id);
        return new ResponseEntity<>(staffDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<StaffRegisterDto> save(@RequestBody StaffRegisterDto staffRegisterDto){
        var respstaffRegisterDto = staffEntityService.save(staffRegisterDto);
        return new ResponseEntity<>(respstaffRegisterDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        staffEntityService.deleteById(id);
    }

}
