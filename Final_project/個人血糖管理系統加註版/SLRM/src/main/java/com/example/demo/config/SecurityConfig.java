package com.example.demo.config;

// 引入必要的包和類
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 表明這是一個配置類
public class SecurityConfig {

    @Autowired // 自動注入CustomUserDetailsService
    private CustomUserDetailsService userDetailsService;

    @Bean // 定義一個PasswordEncoder Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 使用BCryptPasswordEncoder進行密碼編碼
    }

    @Bean // 定義一個DaoAuthenticationProvider Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // 設置自定義的UserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder()); // 設置密碼編碼器
        return authProvider;
    }

    @Bean // 定義一個SecurityFilterChain Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // 禁用CSRF保護
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/resources/**").permitAll() // 允許訪問特定路徑
                .anyRequest().authenticated() // 其他任何請求都需要認證
            )
            .formLogin(form -> form
                .loginPage("/login") // 設置自定義登錄頁面
                .defaultSuccessUrl("/", true) // 設置登錄成功後的默認跳轉頁面
                .permitAll() // 允許所有人訪問登錄頁面
            )
            .logout(logout -> logout.permitAll()); // 允許所有人進行登出操作

        return http.build(); // 構建SecurityFilterChain並返回
    }
}
