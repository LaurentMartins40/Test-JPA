package fr.entites;
import java.util.List;

import javax.persistence.*;
  @Entity
  @Table(name="client")
public class Client {
	    @Id
	    private int id;
	    @Column(name = "NOM", nullable = false, unique = true)
	    private String nom;
	    @Column(name = "PRENOM", nullable = false, unique = true)
	    private String prenom;
	    @OneToMany(mappedBy = "client" )
	    private List<Emprunt> emprunts;
	    
		public String getNom() {
			return nom;
		}
		
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<Emprunt> getEmprunts() {
			return this.emprunts;
		}
		public void setEmprunts(List<Emprunt> emprunts) {
			this.emprunts = emprunts;
		}
}
