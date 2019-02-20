package fr.TestJpa.console;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.entites.Emprunt;
import fr.entites.Livre;

public class TestJpa {
	public static void main(String args[]){
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
      
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
        entityManager = entityManagerFactory.createEntityManager();
       /* 
        Livre l = entityManager.find(Livre.class, 1);
        if (l == null){
        	System.out.println("Livre non trouvé");
        }else{        	
        	System.out.println("Livre trouvé ! " + l.getId() + " " + l.getTitre()+ " " + l.getAuteur());
        }
       
      Query query = entityManager.createQuery("select l from Livre l where l.titre=:reference");
      String nomATrouver = "Germinal";
      query.setParameter("reference", nomATrouver);
      
      Livre livre = (Livre) query.getSingleResult();
      System.out.println(livre.getAuteur() +"  " +livre.getTitre());
      */
        
      Query select = entityManager.createQuery("select id from Emprunt e ");

      List<Integer> taille = select.getResultList();
      List <Emprunt> emprunts = new ArrayList<Emprunt>();
      for(int j=0;j<taille.size();j++){
    	  Query query = entityManager.createQuery("select e from Emprunt e where e.id=:reference");
    	  query.setParameter("reference", j+1);
    	  
    	  emprunts.add(((Emprunt) query.getSingleResult()));
    	  System.out.println(emprunts.get(j).getId());    	  
    	  for(int i =0;i<emprunts.get(j).getLivres().size();i++){
    		  System.out.println(emprunts.get(j).getLivres().get(i).getTitre());    	  
    	  }
      }


      
      
	}
}		