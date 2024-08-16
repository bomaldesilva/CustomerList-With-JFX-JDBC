package org.example.customerlistjfxjdbc;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    String id;
    String name;
    String address;
    String salary;
    String contactNo;
}
