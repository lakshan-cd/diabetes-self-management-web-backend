package com.technocrats.knowladgesharing.backend.dto;
import java.util.List;


// MedicalReportDTO.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalReportDTO {
        private Long rid;
        private String description;
        private String type;
        private List<String> reportlink;
        private int pid;
        private int did;
        private int nid;
}

