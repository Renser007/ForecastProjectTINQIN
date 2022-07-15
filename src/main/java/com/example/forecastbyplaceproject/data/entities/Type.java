package com.example.forecastbyplaceproject.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String typeName;

    @OneToMany(mappedBy = "type")
    private Set<Place> places;

    public Type(String typeName) {
        this.typeName = typeName;
    }
}
