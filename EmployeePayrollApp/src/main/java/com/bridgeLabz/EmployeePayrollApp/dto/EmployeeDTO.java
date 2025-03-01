package com.bridgeLabz.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    @NotBlank(message = "Name is required and cannot be empty.")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name must contain only letters and spaces (3-50 characters).")
    private String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    private double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should Not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    private String note;

    @NotBlank(message = "profilePic cannot be Empty")
    private String profilePic;

    @NotNull(message = "department should not be Empty")
    private List<String> departments;
}
