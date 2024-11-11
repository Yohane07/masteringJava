package org.example;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        gestionEtVerificationMdp();
    }

    public static void ajouterutilisateur(){
        HashMap<String, String> utilisateurInfos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        out.println("Entrez le nom utilisateur:");
        String nomUtilisateur = scanner.nextLine();
        out.println("Entrez le mdp:");
        String motDePasse = scanner.nextLine();
        utilisateurInfos.put(nomUtilisateur, motDePasse);
        out.println("L'utilisateur" + nomUtilisateur + "a bien été ajouté");
    }

    public static void connexion(HashMap<String, String> infosLoginEntrees){
        Scanner scanner = new Scanner(System.in);
        out.println("Nom d'utilisateur:");
        String nomUtilisateur = scanner.nextLine();
        out.println("Entrez le mdp:");
        String motDePasse = scanner.nextLine();
        if (infosLoginEntrees.containsKey(nomUtilisateur)
                && infosLoginEntrees.containsValue(motDePasse))
        {
            out.println("Connexion réussie");
        } else if (!infosLoginEntrees.containsKey(nomUtilisateur)) {
            out.println("Utilisateur non trouvé");
        }else if (infosLoginEntrees.containsKey(nomUtilisateur)
                && !infosLoginEntrees.containsValue(motDePasse)){
            out.println("mot de passe incorrect");
            out.println("Entrez le mdp:");
            scanner.nextLine();
        }
    }

    public static void gestionEtVerificationMdp(){
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        while(choix != 3){
            out.println("1. Ajouter un utilisateur\n" + "2. Se connecter\n" + "3. Quitter\n" + "Choisissez une option :");
            choix = scanner.nextInt();
            if(choix == 1){
                ajouterutilisateur();
            } else if (choix == 2) {
                HashMap<String, String> utilisateurInfos = new HashMap<>();
                connexion(utilisateurInfos);
            }else {
                out.println("Au revoir !");
            }
        }
    }

    public static void verificationMotDePasse(){
        Scanner scanner = new Scanner(System.in);
        out.println("Entrez votre mot de passe :");
        String motDePasseUser = scanner.nextLine();
        String nouveauMdp;

        while (motDePasseUser.length()<8){
            out.println (motDePasseUser + "n'est pas assez long, votre mot de passe doit contenir au moins 8 caractères");
            out.println("Entrez votre mot de passe :");
            nouveauMdp = scanner.nextLine();
            motDePasseUser = nouveauMdp;
        }
        if(isContientCaractereSpecial(motDePasseUser) && isContientLesBonsCaracteres(motDePasseUser)){
            out.println( "mot de passe accepté");
        }else {
            out.println("Mot de passe incorrect : le mot de passe doit contenir au moins un chiffre, " +
                    "une lettre majuscule et un caractère spécial");
        }
    }

    public static boolean isContientCaractereSpecial (String motDePasseUser){
        Pattern p = Pattern.compile("[@#$%!]");
        Matcher matcher = p.matcher(motDePasseUser);

        return matcher.find(); // Find() pour vérifier si au moins un des caracttère indiqué est présent
    }

    public static boolean isContientLesBonsCaracteres(String motDePasseUser) {
        boolean contientMajuscule = false;
        boolean contientUnNombre = false;

        for (char lettre :
             motDePasseUser.toCharArray()) {
             if (Character.isUpperCase(lettre))
             {
                contientMajuscule = true;
             }
             else if (Character.isDigit(lettre)){
                 contientUnNombre= true;
             }
            if (contientMajuscule && contientUnNombre) {  // Interrompt la boucle si les deux critères sont remplis
                break;
            }
        }
        return contientMajuscule && contientUnNombre;
    }
    /*
    public static void addition(Integer nb1, Integer nb2){
        out.println(nb1 - nb2);
    }

    public static void soustraction(Integer nb1, Integer nb2){
        out.println(nb1 - nb2);
    }

    public static void multiplication(Integer nb1, Integer nb2){
        out.println(nb1 * nb2);
    }

    public static void division(Integer nb1, Integer nb2){
        if (nb2 != 0){
            out.println(nb1 / nb2);
        }else {
            out.println("La division par 0 n'est pas possible");
        }
    }

    public static void gererCalcul(){
        int nb1;
        int nb2;
        Scanner scanner = new Scanner(in);
        String opreration = "";
        String continuer;
        boolean play = true;

        while (play) {
            out.println( "Choisis deux nombres, entre le nombre 1" );
            nb1 = scanner.nextInt();
            out.println( "Choisis deux nombres, entre le nombre 2" );
            nb2 = scanner.nextInt();

            scanner.nextLine();

            out.print( "Ensuite Choisis entre addition, soustraction, multiplication ou division " );
            opreration= scanner.nextLine();

            out.print("Ok, vous avez choisi " + opreration + " Votre résultat est: ");


            switch (opreration){
                case "addition":
                    addition(nb1, nb2);
                    break;

                case "soustraction":
                    soustraction(nb1, nb2);
                    break;

                case "multiplication":
                    multiplication(nb1, nb2);
                    break;

                case "division":
                    division(nb1, nb2);
                    break;

                default:
                    out.println("Vous n'avez pas choisi une des opérations cité");
            }

            out.println("Veux-tu continuer ? réponds par oui ou non ");
            continuer= scanner.nextLine();
            if (Objects.equals(continuer, "non")){
                play = false;
            } else {
                out.println("Continuons");
            }
        }
        scanner.close();
    }

     */

}
