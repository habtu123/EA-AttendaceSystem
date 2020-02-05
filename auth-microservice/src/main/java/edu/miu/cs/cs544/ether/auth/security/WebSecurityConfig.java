package edu.miu.cs.cs544.ether.auth.security;//package edu.miu.cs.cs544.ether.security;
//
//import java.util.Arrays;
//
//import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationEntryPoint;
//import edu.miu.cs.cs544.ether.security.jwt.JwtAuthenticationTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter
//{
//
// // @formatter:off
// private static final String[] AUTH_WHITELIST = {
//   // -- swagger ui
//   "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security",
//   "/swagger-ui.html", "/webjars/**"
//   // other public endpoints of your API may be appended to this array
// };
//
// @Autowired
// private MyUserDetailService myUserDetailService;
////
//// @Autowired
//// private JwtAuthenticationEntryPoint unauthorizedHandler;
////
//// @Bean
//// public JwtAuthenticationTokenFilter authenticationTokenFilterBean()
//// {
////  return new JwtAuthenticationTokenFilter();
//// }
////
////@Bean
////public DaoAuthenticationProvider daoAuthenticationProvider(){
////  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////  authProvider.setUserDetailsService(myUserDetailService());
////  authProvider.setPasswordEncoder(passwordEncoder());
////  return authProvider;
////}
////
//// @Bean
//// public BCryptPasswordEncoder passwordEncoder() {
////  return new BCryptPasswordEncoder();
//// }
////
////@Bean
////public  MyUserDetailService myUserDetailService(){
////  return new MyUserDetailService();
////}
//// @Bean
//// @Override
//// public AuthenticationManager authenticationManagerBean() throws Exception
//// {
////  return super.authenticationManagerBean();
//// }
////
////
//// // Cors Configuration for ajax requests
//// @Bean
//// CorsConfigurationSource corsConfigurationSource()
//// {
////  final CorsConfiguration configuration = new CorsConfiguration();
////  configuration.addAllowedOrigin("*");
////  configuration.setAllowedMethods(Arrays.asList("POST, PUT, GET, OPTIONS, DELETE"));
////  configuration.addAllowedHeader("*");
////  configuration.addAllowedMethod("*");
////  final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////  source.registerCorsConfiguration("/**", configuration);
////  return source;
//// }
////
// @Override
// protected void configure(HttpSecurity httpSecurity) throws Exception
// {
////  httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
////    // We don't need any session
////    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and().authorizeRequests()
////    .antMatchers(
////      // HttpMethod.GET,
////      "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.png", "/**/*.js")
////    .permitAll().antMatchers(AUTH_WHITELIST).permitAll() // whitelist Swagger UI resources
////    .antMatchers("/csrf").permitAll() // Disable protection for "../csrf" path called by swagger -->
////                                      // we'll retrieve a 404 instead a 401/403
////    .anyRequest().authenticated();
////
////  // Custom JWT Filter
////  httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
////
////  httpSecurity.headers().cacheControl();
//
//  httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and()
//          .authorizeRequests().antMatchers(HttpMethod.GET, "/", "fevicon.ico", "/**/*.html", "/**/*.css", "/**/*.png", "/**/*.js")
//          .permitAll().antMatchers(AUTH_WHITELIST).permitAll()
//          .antMatchers("/csrf").permitAll()
//          .anyRequest().authenticated();
// }
//
// // @formatter:on
//
// public AuthenticationManager customAuthenticationManager() throws Exception {
//  return authenticationManager();
// }
//
//
//
//}