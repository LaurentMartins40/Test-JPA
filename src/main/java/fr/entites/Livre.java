package fr.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
  @Entity
  @Table(name="livre")
public class Livre {
    @Id
    private int id;
    @Column(name = "TITRE", nullable = false, unique = true)
    private String titre;
    @Column(name = "AUTEUR", length = 30, nullable = false, unique = true)
    private String auteur;
    
    
    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunts;
    
    
    public Livre(){
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Emprunt> getEmprunts() {
		return this.emprunts;
	}
	
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}

