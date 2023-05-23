package com.jj.creative.domain.occupationArea;

import java.util.UUID;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class OccupationArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotBlank
    @Column(name = "business_unit_local_id")
    private UUID businessUnitLocalId;

}
