package com.furkanyesilyurt.springbootex.converter;

import com.furkanyesilyurt.springbootex.dto.Staff.StaffDto;
import com.furkanyesilyurt.springbootex.dto.Staff.StaffRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StaffConverter {

    StaffConverter INSTANCE = Mappers.getMapper(StaffConverter.class);

    List<StaffDto> convertAllStaffToStaffDtos(List<Staff> staff);
    StaffDto convertStaffToStaffDto(Staff staff);
    Staff convertStaffRegisterDtoToStaff(StaffRegisterDto staffRegisterDto);
    StaffRegisterDto convertStaffToStaffRegisterDto(Staff staff);
}
