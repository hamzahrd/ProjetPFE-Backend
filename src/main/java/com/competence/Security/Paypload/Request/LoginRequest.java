package com.competence.Security.Paypload.Request;


import javax.validation.constraints.NotBlank;
import java.util.Set;

public class LoginRequest {

  @NotBlank
 private String username;

  @NotBlank
  private String password;
    private Set<String> role;

    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}

