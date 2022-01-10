package com.furkanyesilyurt.springbootex.service.entityService;

import com.furkanyesilyurt.springbootex.converter.StaffConverter;
import com.furkanyesilyurt.springbootex.dao.IStaffDao;
import com.furkanyesilyurt.springbootex.dto.Staff.StaffDto;
import com.furkanyesilyurt.springbootex.dto.Staff.StaffRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Staff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffEntityService {

    private final IStaffDao staffDao;

    public List<StaffDto> findAll(){
        List<Staff> staff = staffDao.findAll();
        return StaffConverter.INSTANCE.convertAllStaffToStaffDtos(staff);
    }

    public StaffDto findById(Long id){
        Optional<Staff> optionalStaff = staffDao.findById(id);
        Staff staff = null;
        if(optionalStaff.isPresent()){
            staff = optionalStaff.get();
        }
        return StaffConverter.INSTANCE.convertStaffToStaffDto(staff);
    }

    public StaffRegisterDto save(StaffRegisterDto staffRegisterDto){
        Staff staff = StaffConverter.INSTANCE.convertStaffRegisterDtoToStaff(staffRegisterDto);
        staff = staffDao.save(staff);
        staffRegisterDto = StaffConverter.INSTANCE.convertStaffToStaffRegisterDto(staff);
        return staffRegisterDto;
    }

    public void deleteById(Long id){
        staffDao.deleteById(id);
    }
}
