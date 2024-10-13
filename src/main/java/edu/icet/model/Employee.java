package edu.icet.model;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String name;
    private String mobile;
    private String NIC;
    private String email;
    private String Password;
}
