package com.StartSpringBoot.Spring.Boot.models.dto.dto;
import com.StartSpringBoot.Spring.Boot.models.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public   class EmployeeDTO {
//    Data Transfer Object

    private Integer id;
    private String firstName;
    private String lastName;
    private double salary;
    public static EmployeeDTO fromEntityToDto(Employee entity){
        return EmployeeDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
//                .salary(entity.getSalary())
                .build();
    }

}
