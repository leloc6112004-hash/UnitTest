package com.basicproject.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "bp_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 150)
  private String username;

  @Column(length = 254)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(name = "first_name", length = 150)
  private String firstName;

  @Column(name = "last_name", length = 150)
  private String lastName;

  @Column(nullable = false)
  @Builder.Default
  private boolean active = true;

  @Column(nullable = false)
  @Builder.Default
  private boolean staff = false;

  @Column(nullable = false)
  @Builder.Default
  private boolean superuser = false;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private Profile profile;

  public void setProfile(Profile p) {
    this.profile = p;
    if (p != null) {
      p.setUser(this);
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> auths = new ArrayList<>();
    if (superuser) {
      auths.add(new SimpleGrantedAuthority("ROLE_SUPERUSER"));
    }
    if (staff) {
      auths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
    }
    if (profile != null && profile.getRole() != null) {
      auths.add(
          new SimpleGrantedAuthority("ROLE_" + profile.getRole().name().toUpperCase()));
    }
    return auths;
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
    return active;
  }
}
