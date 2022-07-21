package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    //스프링이 로그인 요청을 가로챌때 username,password 변수 2개를 가로채서 password부분처리는 알아서함
    //username이 DB에 있는지 확인해주면됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당사용자를 찾을수 없습니다." + username);
                });
        return new PrincipalDetail(principal);
    }
}
