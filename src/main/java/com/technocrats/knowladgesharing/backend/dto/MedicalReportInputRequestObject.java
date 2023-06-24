package com.technocrats.knowladgesharing.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class MedicalReportInputRequestObject {
    private String description;
    private String type;
    private List<String> reportlink;
    private int pid;
    private int did;
    private int nid;
}
