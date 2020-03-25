package priscille.pglp_5_1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pattern Composite CompositePersonnel
 * implémentant l'interface InterfacePersonnel.
 */
public class CompositePersonnel
implements InterfacePersonnel, Iterable<InterfacePersonnel> {
    /**
     * Liste de membres du personnels d'un même composite.
     */
    private ArrayList<InterfacePersonnel> list =
            new ArrayList<InterfacePersonnel>();
    /**
     * Identifiant d'un composite.
     */
    private final int id;
    /**
     * Identifiant du composite suivant.
     */
    private static int idFin = 1;
    /**
     * Constructeur.
     */
    public CompositePersonnel() {
        id = idFin++;
        list = new ArrayList<InterfacePersonnel>();
    }
    /**
     * Fonction d'écriture des informations du composite.
     */
    public void print() {
        System.out.println("Id : " + id);
        for (InterfacePersonnel intP : list) {
            intP.print();
        }
    }
    /**
     * Fonction qui ajoute une personne a la liste du personnel.
     * @param intP La personne a ajouter
     */
    public void add(final InterfacePersonnel intP) {
        list.add(intP);
    }
    /**
     * Fonction qui enlève une personne a la liste du personnel.
     * @param intP La personne a enlever
     */
    public void remove(final InterfacePersonnel intP) {
        list.remove(intP);
    }
    /**
     * Getter de l'identifiant du Composite.
     * @return L'identifiant
     */
    public final int getId() {
        return id;
    }
    /**
     * Fonction qui crée un Itérateur
     * de la liste des personnes du Composite.
     * @return L'iterateur
     */
    public Iterator<InterfacePersonnel> iterator() {
        return list.iterator();
    }
}
