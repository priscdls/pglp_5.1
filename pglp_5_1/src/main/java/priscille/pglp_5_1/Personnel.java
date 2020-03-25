package priscille.pglp_5_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe Personnel représente un membre du personnel.
 * Cette classe implémente l'interface InterfacePersonnel.
 */
public final class Personnel implements InterfacePersonnel, Serializable {
    /**
     * Nom du membre du personnel.
     */
    private final String nom;
    /**
     * Prénom du membre du personnel.
     */
    private final String prenom;
    /**
     * Date de naissance du membre du personnel.
     */
    private final java.time.LocalDate dateNaissance;
    /**
     * Liste des numéro de téléphone du membre du personnel.
     */
    private final ArrayList<String> numTel;
    /**
     * Pattern Builder.
     *
     */
    public static class Builder {
    /**
     * Nom du membre du personnel.
     */
        private final String nom;
        /**
         * Prénom du membre du personnel.
         */
        private final String prenom;
        /**
         * Date de naissance du membre du personnel.
         */
        private final java.time.LocalDate dateNaissance;
        /**
         * Liste des numéros de téléphone du membre du personnel.
         */
        private final ArrayList<String> numTel;
        /**
         * Constructeur.
         * @param n Nom du membre du personnel.
         * @param p Prénom du membre du personnel.
         * @param date Date de naissance du membre du personnel.
         * @param num Liste des numéro de téléphone.
         * du membre du personnel.
         */
        public Builder(final String n, final String p,
                final java.time.LocalDate date,
                final ArrayList<String> num) {
            this.nom = n;
            this.prenom = p;
            this.dateNaissance = date;
            this.numTel = num;
        }
        /**
         * Fonction qui construit une variable
         * de type Personnel a l'aide du Builder.
         * @return La variable Personnel
         */
        public Personnel build() {
            return new Personnel(this);
        }
    }
    /**
     * Constructeur.
     * @param builder
     */
    public Personnel(final Builder builder) {
        nom = builder.nom;
        prenom = builder.prenom;
        dateNaissance = builder.dateNaissance;
        numTel = builder.numTel;
    }
    /**
     * Fonction qui écrit les informations d'un membre du Personnel.
     */
    public void print() {
        System.out.println("Nom : " + nom + ", Prenom : " + prenom
                + ", Date de Naissance : " + dateNaissance
                + ", Numero(s) de telephone : " + numTel);
    }
    /**
     * Fonction de sérialisation.
     * @param path
     */
    public void serialization(String path) {
    	ObjectOutputStream oos = null;
    	try {
    		final FileOutputStream fichierOut = new FileOutputStream(path);
    		oos = new ObjectOutputStream(fichierOut);
    		oos.writeObject(this);
    		oos.flush();
    		oos.close();	
    	} catch (final java.io.IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(oos != null) {
    				oos.flush();
    				oos.close();
    			}
    		} catch (final java.io.IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    /**
     * Fonction de désérialisation.
     * @param path
     */
    public static void deSerialization(String path) {
    	ObjectInputStream ois = null;
    	try {
    		final FileInputStream fichierIn = new FileInputStream(path);
    		ois = new ObjectInputStream(fichierIn);
    		final Personnel p = (Personnel) ois.readObject();
    	} catch (final java.io.IOException e) {
    		e.printStackTrace();
    	} catch (final ClassNotFoundException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if (ois != null) {
    				ois.close();
    			}
    		} catch (final java.io.IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    }
}
