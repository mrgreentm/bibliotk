package com.jjsoftwares.bibliotk.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDataDTO {
    private Long userId;
    private String userName;
    private String email;
    private List<LoanBookDTO> loans;
}
