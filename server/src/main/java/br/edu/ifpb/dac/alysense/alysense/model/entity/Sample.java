package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.Random;

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
public class Sample {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private Long code = (long) Math.floor(Math.random() * 1001);

    private String detailsSample;

	public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized Long getCode() {
		return code;
	}

	public synchronized void setCode(Long code) {
		this.code = code;
	}

	public synchronized String getDetailsSample() {
		return detailsSample;
	}

	public synchronized void setDetailsSample(String detailsSample) {
		this.detailsSample = detailsSample;
	}
    
}
