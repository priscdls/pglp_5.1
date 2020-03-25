package priscille.pglp_5_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

public class AfficheParGroupe
implements Iterable<InterfacePersonnel>, Serializable {
    /**
     * Attribut de sérialisation.
     */
    private static final long serialVersionUID = 1L;
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
    /**
     * Fonction de sérialisation.
     * @param path Adresse du fichier
     */
    public void serialization(final String path) {
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
                if (oos != null) {
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
     * @param path Adresse du fichier
     * @return Le personnel deserialisé
     */
    public static AfficheParGroupe deSerialization(final String path) {
        ObjectInputStream ois = null;
        AfficheParGroupe apg = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            apg = (AfficheParGroupe) ois.readObject();
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
        return apg;
    }
}
