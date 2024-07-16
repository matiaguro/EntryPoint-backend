package com.techar.EntryPointBackend.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "config_parameters")
public class ConfigParameters {

    @Id
    @Column(name="token", nullable = false)
    private String token;

    @Column(name="value", nullable = false)
    private String value;

    @Column(name="update_date", nullable = false)
    private LocalDateTime updateDate;
}
