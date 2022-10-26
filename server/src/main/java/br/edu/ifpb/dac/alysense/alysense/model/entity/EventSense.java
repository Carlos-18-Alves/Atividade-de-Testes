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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class EventSense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEvent;
    private String local;
    private Integer peopleLimit;
    private Integer numberSample;
    private Integer minimunAge; 

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_avaliation", joinColumns = @JoinColumn(name= "eventid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    private List<User> evaluators;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Product> items;

    private Long admUser;

	public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized String getTitle() {
		return title;
	}

	public synchronized void setTitle(String title) {
		this.title = title;
	}

	public synchronized LocalDate getDateEvent() {
		return dateEvent;
	}

	public synchronized void setDateEvent(LocalDate dateEvent) {
		this.dateEvent = dateEvent;
	}

	public synchronized String getLocal() {
		return local;
	}

	public synchronized void setLocal(String local) {
		this.local = local;
	}

	public synchronized Integer getPeopleLimit() {
		return peopleLimit;
	}

	public synchronized void setPeopleLimit(Integer peopleLimit) {
		this.peopleLimit = peopleLimit;
	}

	public synchronized Integer getNumberSample() {
		return numberSample;
	}

	public synchronized void setNumberSample(Integer numberSample) {
		this.numberSample = numberSample;
	}

	public synchronized Integer getMinimunAge() {
		return minimunAge;
	}

	public synchronized void setMinimunAge(Integer minimunAge) {
		this.minimunAge = minimunAge;
	}

	public synchronized List<User> getEvaluators() {
		return evaluators;
	}

	public synchronized void setEvaluators(List<User> evaluators) {
		this.evaluators = evaluators;
	}

	public synchronized List<Product> getItems() {
		return items;
	}

	public synchronized void setItems(List<Product> items) {
		this.items = items;
	}

	public synchronized Long getAdmUser() {
		return admUser;
	}

	public synchronized void setAdmUser(Long admUser) {
		this.admUser = admUser;
	}


}
