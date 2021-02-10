package com.ishara.bookingcloud.auth.authserver.cong;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {


    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ishara").password(passwordEncoder.encode("1234567")).roles("USER","ADMIN","MANAGER").authorities("CAN_READ","CAN_WRITE","CAN_DELET").and()
                .withUser("sameera").password(passwordEncoder.encode("123@123")).roles("USER","SUPERVISIOR").authorities("CAN_READ");
        super.init(auth);
    }
}
