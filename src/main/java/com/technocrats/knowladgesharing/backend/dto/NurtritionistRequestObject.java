package com.technocrats.knowladgesharing.backend.dto;

import com.technocrats.knowladgesharing.backend.model.Nutritionist;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class NurtritionistRequestObject {

    private String email;
    private String fname;
    private String lname;
    private int telephoneno;
    private String hNo;
    private String img_url;

    private String description;
//    private int p_rate;
    private List<String> a_date;
    private List<String> a_time;
    private List<String> p_rate;
}
