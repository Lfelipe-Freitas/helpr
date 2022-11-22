package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioSecurity implements UserDetails {
    private String email;
    private String senha;

    //dados de autorização
    private Perfil perfil;
    private ArrayList<SimpleGrantedAuthority> authorities= new ArrayList<>();

    public UsuarioSecurity(String email, String senha, Perfil perfil) {
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //indica se a conta é válida
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //indica se a conta está desbloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //indica se as credenciais estão válidas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // indica se o usuário está habilitado
        return true;
    }
}
