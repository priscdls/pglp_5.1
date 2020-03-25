package priscille.pglp_5_1;

import java.util.ArrayDeque;
import java.util.Iterator;

public class AfficheParGroupe implements Iterable<InterfacePersonnel> {
    /**
     * Liste de membres du personnels d'un même composite.
     */
    private ArrayDeque<InterfacePersonnel> file =
            new ArrayDeque<InterfacePersonnel>();
    /**
     * Fonction qui crée un Itérateur
     * de la liste des personnes du Composite.
     * @return L'iterateur
     */
    public Iterator<InterfacePersonnel> iterator() {
        return file.iterator();
    }
    /**
     * Fonction qui fait un parcours en largeur.
     * @param ip InterfacePersonnel à afficher
     */
    public void parcoursLargeur(final InterfacePersonnel ip) {
        file = new ArrayDeque<InterfacePersonnel>();
        ArrayDeque<InterfacePersonnel> file2 =
                new ArrayDeque<InterfacePersonnel>();
        InterfacePersonnel i;
        file2.add(ip);
        while (!file2.isEmpty()) {
            i = file2.pollFirst();
            file.add(i);
            if (i.getClass() == CompositePersonnel.class) {
                CompositePersonnel cp = (CompositePersonnel) i;
                Iterator<InterfacePersonnel> it =
                        cp.iterator();
                while (it.hasNext()) {
                    i = it.next();
                    if (!file2.contains(i)
                            && !file.contains(i)) {
                        file2.add(i);
                    }
                }
            }
        }
    }
    /**
     * Affichage du parcours en largeur.
     */
    public void print() {
        for (InterfacePersonnel ip2 : file) {
            if (ip2.getClass() == CompositePersonnel.class) {
                CompositePersonnel cp2 =
                        (CompositePersonnel) ip2;
                System.out.println("Id : " + cp2.getId());
            } else {
                ip2.print();
            }
        }
    }
}
