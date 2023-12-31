package chinchulin.varano.Security.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@NoArgsConstructor
public class JwtDTO {

        private String token;
        private String username;
        private Collection<? extends GrantedAuthority> authorities;

        public JwtDTO(String token, String username, Collection<? extends GrantedAuthority> authorities) {
                this.token = token;
                this.username = username;
                this.authorities = authorities;
        }
}
