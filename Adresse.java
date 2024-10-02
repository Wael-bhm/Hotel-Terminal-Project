
public class Adresse {
    private String nomRue;
    private int numeroImmeuble;
    private String nomCommune;
    private int codePostal;
    private String departementOuEtat;
    private String pays;
    private long numeroTelephone;
    private String adresseCourriel;
    private String adresseWeb;


    public void setNumeroTelephone(long numeroTelephone) throws Anomalie {
        try {
            String phoneNumber = Long.toString(numeroTelephone);
            if (!phoneNumber.matches("\\d{8}")) {
                throw new Anomalie("Le numéro de téléphone doit être composé de 8 chiffres.");
            }
            this.numeroTelephone = numeroTelephone;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void setAdresseWeb(String adresseWeb) throws Anomalie {
        try {
            // You can customize the regular expression based on the format you expect
            String webPattern = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}+)+.*$";
            if (!adresseWeb.matches(webPattern)) {
                throw new Anomalie("L'adresse web doit être dans un format pertinent.");
            }
            this.adresseWeb = adresseWeb;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void setAdresseCourriel(String adresseCourriel) throws Anomalie {
        try {
            // You can customize the regular expression based on the format you expect
            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!adresseCourriel.matches(emailPattern)) {
                throw new Anomalie("L'adresse courriel doit être dans un format pertinent.");
            }
            this.adresseCourriel = adresseCourriel;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }


    public String getNomRue() {
        return this.nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getNumeroImmeuble() {
        return this.numeroImmeuble;
    }

    public void setNumeroImmeuble(int numeroImmeuble) {
        this.numeroImmeuble = numeroImmeuble;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public int getCodePostal() {
        return this.codePostal;
    }


    public void setCodePostal(int codePostal) {
        try {
            if (codePostal < 1000 || codePostal > 9999) {
                throw new Anomalie("Le code postal doit être composé de 4 chiffres.");
            }
            this.codePostal = codePostal;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public String getDepartementOuEtat() {
        return this.departementOuEtat;
    }

    public void setDepartementOuEtat(String departementOuEtat) {
        this.departementOuEtat = departementOuEtat;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public long getNumeroTelephone() {
        return this.numeroTelephone;
    }


    public String getAdresseCourriel() {
        return this.adresseCourriel;
    }

    public String getAdresseWeb() {
        return this.adresseWeb;
    }


    // Constructeur
    public Adresse(String nomRue, int numeroImmeuble, String nomCommune, int codePostal,
                   String departementOuEtat, String pays, long numeroTelephone, String adresseCourriel,
                   String adresseWeb) {
        this.nomRue = nomRue;
        this.numeroImmeuble = numeroImmeuble;
        this.nomCommune = nomCommune;

        // MAKE THE Anormalie EXCPETION IF THE NUMBER IS NOT BETWENN 1000 AND 9999 USING
        // TRY AND CATCH , this is the class Anormalie :
        /*public class Anomalie extends Exception {
    public Anomalie(String message) {
        super(message);
    }}*/
        try {
            if (codePostal < 1000 || codePostal > 9999) {
                throw new Anomalie("Le code postal doit être composé de 4 chiffres.");
            }
            this.codePostal = codePostal;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        this.departementOuEtat = departementOuEtat;
        this.pays = pays;
          try {
            String phoneNumber = Long.toString(numeroTelephone);
            if (!phoneNumber.matches("\\d{8}")) {
                throw new Anomalie("Le numéro de téléphone doit être composé de 8 chiffres.");
            }
            this.numeroTelephone = numeroTelephone;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            // You can customize the regular expression based on the format you expect
            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!adresseCourriel.matches(emailPattern)) {
                throw new Anomalie("L'adresse courriel doit être dans un format pertinent.");
            }
            this.adresseCourriel = adresseCourriel;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
          try {
            // You can customize the regular expression based on the format you expect
            String webPattern = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}+)+.*$";
            if (!adresseWeb.matches(webPattern)) {
                throw new Anomalie("L'adresse web doit être dans un format pertinent.");
            }
            this.adresseWeb = adresseWeb;
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        // Format each attribute in the desired way
        result.append("Nom de la rue: ").append(nomRue);
        result.append("Numéro d'immeuble: ").append(numeroImmeuble);
        result.append("Nom de la commune: ").append(nomCommune);
        result.append("Code postal: ").append(codePostal);
        result.append("Pays: ").append(pays).append("\n");
        result.append("Web: ").append(adresseWeb);   
        result.append("Email: ").append(adresseCourriel).append("\n");
 
        result.append("Tél: ").append(numeroTelephone)
        return result.toString();
    }
}
// faire un bon affichage pour la classe adresse comme j'ai fait pour la classe hotel
// faire un bon affichage pour la classe chambre comme j'ai fait pour la classe hotel   


