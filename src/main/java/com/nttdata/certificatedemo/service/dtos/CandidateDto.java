package com.nttdata.certificatedemo.service.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CandidateDto {
    private Long id;
    private String name;
    private int score;
    private Date dateNaissance;
}
