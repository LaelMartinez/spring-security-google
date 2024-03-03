package br.laelmartinez.springsecuritygoogle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringSecurityGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityGoogleApplication.class, args);
	}

	@RestController
	public static class HttpController {
		@GetMapping("/public")
		private String publicRoute() {
			return "<h1>Public route, Welcome! </h1>";
		}

		@GetMapping("/private")
		private String privateRoute(@AuthenticationPrincipal OidcUser userPrincipal) {

			return String.format("""
					<h1>Private route, Welcome %s! </h1>
					<h3>Estes são os dados do seu perfil: </h3>
					<p><b>Principal: </b>%s</p>
					<p><b>E-mail: </b>%s</p>
					<p><b>Authorities: </b>%s</p>
					<p><b>TokenJWT: </b>%s</p>
					""",
					userPrincipal.getAttribute("name"),
					userPrincipal.toString(),
					userPrincipal.getAttribute("email"),
					userPrincipal.getAuthorities(),
					userPrincipal.getIdToken().getTokenValue());

		}

		@GetMapping("/jwt")
		private String jwt(@AuthenticationPrincipal Jwt jwt) {

	
			if (jwt != null) {
				return String.format("""
						<h3>Estes são os dados do seu JWT: </h3>
						<p><b>Principal: </b>%s</p>
						<p><b>E-mail: </b>%s</p>
						<p><b>JWT: </b>%s</p>
						""",
						jwt.getClaims(),
						jwt.getClaim("email"),
						jwt.getTokenValue());
			} else {

				return "JWT not found";

			}

		}

	}

}
