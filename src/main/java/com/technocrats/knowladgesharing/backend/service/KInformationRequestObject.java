package com.technocrats.knowladgesharing.backend.service;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class KInformationRequestObject {
    String title;
    String catergory;
    String img_url;
    String v_url;
    String description;
}
