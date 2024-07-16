package com.techar.EntryPointBackend.core.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_titles")
public class UserTitles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user_titles", nullable = false)
    private Long idUserState;

    @Column(name="key_titles", nullable = false)
    private String keyTitles;

    @Column(name="description", nullable = false)
    private String description;

}
