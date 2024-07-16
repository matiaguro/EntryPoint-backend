package com.techar.EntryPointBackend.core.models;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.util.JsonUtils;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user", nullable = false)
    private Long idUser;

    @Column(name="user_id", nullable = false)
    private String userId;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ToString.Exclude
    private Rol role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_state", referencedColumnName = "id_user_state")
    @ToString.Exclude
    private UserState userState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_titles", referencedColumnName = "id_user_titles")
    @ToString.Exclude
    private UserTitles userTitles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<AttendanceRecords> records;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getNameRol()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserJson () throws ErrorExpected {
        var newUser = this;
        newUser.setPassword(null);
        return JsonUtils.objectToJson(newUser);
    }
}




