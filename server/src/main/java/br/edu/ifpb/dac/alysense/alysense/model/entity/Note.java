package br.edu.ifpb.dac.alysense.alysense.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Note {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private float scale;

	public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized float getScale() {
		return scale;
	}

	public synchronized void setScale(float scale) {
		this.scale = scale;
	}
	
}
