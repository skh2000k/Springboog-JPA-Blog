package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class PrincipalDetail implements UserDetails
{
    private User user;

    public PrincipalDetail(User user){
        this.user = user;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    //계정 만료여부(true 활성화)
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    //계정 잠금 여부(true 활성화)
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    //비밀번호 만료 여부(true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    //계정이 갖고 있는 권한 목록을 리턴한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });
        return collectors;
    }
}
