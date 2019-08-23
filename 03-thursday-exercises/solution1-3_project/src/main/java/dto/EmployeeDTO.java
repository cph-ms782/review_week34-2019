package dto;

import entities.Employee;

/**
 *
 */
public class EmployeeDTO {
    private int id;
    private String name;
    private String address;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.address = e.getAddress();
    }
    
    
}
