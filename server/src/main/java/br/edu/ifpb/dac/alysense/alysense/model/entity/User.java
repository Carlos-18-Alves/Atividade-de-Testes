package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name="UserPerson")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String email;
	
	private String password;

	@ManyToMany(fetch= FetchType.EAGER)
	private List<Role> roles;

	public List<Role> getRoles(){
		return roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	public boolean validateEmail() {
		boolean validate = email.matches("\\w+@\\w+\\.\\w{2,3}\\.\\w{2,3}");
		if (validate) {
			return true;
		} else {
	    	setEmail(null);
	    	return false;
	    }
	}
	
	public boolean validateName() {
        String regex = "^[A-Za-z]\\w{4,29}$";
        Pattern p = Pattern.compile(regex);
  
        if (name == null) {
            return false;
        }
        String nameConcat = name.strip();
        Matcher m = p.matcher(nameConcat);
        return m.matches();
    }
	
	public boolean validatePassword () {
		boolean validate = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		if (validate) {
			return true;
		} else {
			setPassword(password);
			return false;
		}
	}
	
	public boolean validateBirthDate() {
		LocalDate validDate = LocalDate.now().minusYears(10);
	    
	    if(birthDate.isBefore(validDate))
			return true;
	    else {
	    	setBirthDate(null);
	    	return false;
	    }
	}
	
}
