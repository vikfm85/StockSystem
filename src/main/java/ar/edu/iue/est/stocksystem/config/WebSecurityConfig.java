package ar.edu.iue.est.stocksystem.config;

import ar.edu.iue.est.stocksystem.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Clase donde se configura la seguridad del sistema, forma de ingresar y salir
 * del sistema por medio de un login y su logout. Manejo de los distintos roles
 * del sistema y las tareas que estos pueden realizar
 * 
 * @author vikfm1985
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyDBAuthenticationService myDBAauthenticationService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Usuarios en la BD.
		auth.userDetailsService(myDBAauthenticationService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Las paginas que necesitan estar conectados como Empleado o Manager.
		// Si no nos encontraramos logueados, nos redirecciona a la pag del
		// Login.
		http.authorizeRequests().antMatchers("/orderList", "/order", "/accountInfo")//
				.access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");

		// Uso exclusivo del Manager.
		http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");

		// Metodo por el cual si no se esta autorizado para ingresar a una pag
		// muestro la pag del error de Acceso Denegado.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config para el Form de Login
		http.authorizeRequests().and().formLogin()//
				// URL del envio de la pagina de Login.
				.loginProcessingUrl("/j_spring_security_check") // URL de envio
				.loginPage("/login")// URL del login
				.defaultSuccessUrl("/accountInfo")// URL de la redireccion del
													// logueo exitoso
				.failureUrl("/login?error=true")// URL de error
				.usernameParameter("userName")// Parametro
				.passwordParameter("password")// Parametro
				// Config de la pag de Logout
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}
}