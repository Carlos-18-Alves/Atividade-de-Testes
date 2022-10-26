package br.edu.ifpb.dac.alysense.alysense.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	@Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return "UserRole [id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "]";
    }
    
}
