package edu.icet.model;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private String id;
    private String name;
    private String email;
    private String mobile;
    private String company;
}
