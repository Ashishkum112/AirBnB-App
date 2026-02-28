package com.project.airBnbApp.dto;


import com.project.airBnbApp.entity.Booking;
import com.project.airBnbApp.entity.User;
import com.project.airBnbApp.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
