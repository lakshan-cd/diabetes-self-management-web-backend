package com.technocrats.knowladgesharing.backend.dto;

import com.technocrats.knowladgesharing.backend.model.DoctorCalling;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorCallingDto {

    private String name;
    private String image;
    private String description;
    private String type;
    private String mobile;

    public DoctorCallingDto(DoctorCalling doctorCalling){
        this.name = doctorCalling.getName();
        this.type = doctorCalling.getType();
        this.image = doctorCalling.getImage();
        this.description = doctorCalling.getDescription();
    }

}
