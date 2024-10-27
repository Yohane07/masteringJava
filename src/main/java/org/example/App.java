package org.example;

import static java.lang.System.*;

import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        gererCalcul();

    }

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

    /* Exercie 4: Verification du mot passe*/

    /*
    * String motDePasseUser;
    * String tailleMinimum;
    * boolean contientMajuscule = false;
    * boolean contientMiniscule = false;
    * boolean contientUnNombre = false;
    *
    * Si motDePasseUser > tailleMinimum
    *   Si les trois booleans sont vrais
    *       => votre mot de passe respectes les critères
    *   Sinon si un des trois est faux
    *       => renvoyés mdp incorrecte, il doit contenir au moins une Maj, Min , un caractère spécial et un nombre
    * Sinon
    *   => Votre mdp doit contenir au moins 8 caractères
    *
    *
    * */

    Scanner scanner = new Scanner(System.in);
    String motDePasseUser;
    boolean contientMajuscule = false;
    boolean contientUnNombre = false;
    boolean contientCaractereSpecial = false;

   // String mdpAccepte = "";


    public String verificationMotDePasse(String motDePasseUser){
        if (motDePasseUser.length()<8){
            return (motDePasseUser + "n'est pas assez long, votre mot de passe doit contenir au moins 8 caractères");
        }else {
            isContientLesBonsCaracteres(motDePasseUser);
        }
        return motDePasseUser;
    }

    public String isContientLesBonsCaracteres(String motDePasseUser) {
        for (char lettre :
             motDePasseUser.toCharArray()) {
             if (Character.isUpperCase(lettre))
             {
                contientMajuscule = true;
             }
             else if (Character.isDigit(lettre)){
                 contientCaractereSpecial = true;
             }
             else if (contientMajuscule && contientCaractereSpecial) {
                 return ("Mot de passe accepté");
             }
             else {
                 return ("Mot de passe incorrect : le mot de passe doit contenir au moins une lettre majuscule et un caractère spécial");
             }
        }

        return null;
    }
}
