package com.technocrats.knowladgesharing.backend.service;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class NewsReaserchRequestObject {
    Long id;
    String nr_title;
    String nr_description;
    String nr_imglink;
}
