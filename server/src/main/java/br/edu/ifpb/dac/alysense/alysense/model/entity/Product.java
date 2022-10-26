package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private String owner;
    private String ingredients;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Characteristic> characteristics;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sample> samples;

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

	public synchronized LocalDate getExpirationDate() {
		return expirationDate;
	}

	public synchronized void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public synchronized String getOwner() {
		return owner;
	}

	public synchronized void setOwner(String owner) {
		this.owner = owner;
	}

	public synchronized String getIngredients() {
		return ingredients;
	}

	public synchronized void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public synchronized Long getUserId() {
		return userId;
	}

	public synchronized void setUserId(Long userId) {
		this.userId = userId;
	}

	public synchronized List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public synchronized void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public synchronized List<Sample> getSamples() {
		return samples;
	}

	public synchronized void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
	
}
