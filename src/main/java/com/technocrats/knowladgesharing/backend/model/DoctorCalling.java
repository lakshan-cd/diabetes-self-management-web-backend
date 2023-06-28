package com.technocrats.knowladgesharing.backend.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DoctorCalling")
public class DoctorCalling {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DoctorCallingGenerator")
//    @Column(name = "ID", nullable = false, unique = true)

    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Column(name = "Image")
    private String image;

    @Column(name = "Description")
    private String description;

    @Column(name = "mobile")
    private String mobile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DoctorCalling doctorCalling = (DoctorCalling) o;
        return getId() != null && Objects.equals(getId(), doctorCalling.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
