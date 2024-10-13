package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employee")
@Table(name = "employee")
public class EmployeeEntity {
    private String id;
    private String name;
    private String mobile;
    private String NIC;
    private String email;
    private String Password;
}
