package fr.entites;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	private int id;
	@Column(name="DATE_DEBUT", nullable = false)
	private LocalDate dateDebut;
	@Column(name="DATE_fin", nullable = false)
	private LocalDate dateFin;
    @Column(name="DELAI", nullable = false)
    private int delai;	 
    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;
     
    @ManyToMany
    @JoinTable(name="compo",
    	joinColumns= @JoinColumn(name="ID_EMP",referencedColumnName="ID"),
     	inverseJoinColumns=@JoinColumn(name="ID_LIV",referencedColumnName="ID"))
    private List<Livre> livres; 
     
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	//code baclé a refaire
	public int getDelai() {
		return this.delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}
	public Client getClient() {
		return this.client;
	}
	//Horrible
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Livre> getLivres() {
		return this.livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
}
