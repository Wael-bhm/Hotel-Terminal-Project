import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Client
{
    // instance variables - replace the example below with your own
    static private int nbClient=0 ; 
    private int numeroClient; // numéro du client
    private String nomClient; // nomClient du client
    private String prenomClient; // prénom du client
    private Adresse adresse;
    private Chambre Chambre;
    private ArrayList<String> Consommation;
    LocalTime timeResev;
    LocalDate dateResev;



    public LocalTime getTimeResev() {
        return this.timeResev;
    }

    public void setTimeResev(LocalTime timeResev2) {
        try {
            // Check if the reservation time and date is in the past
            if (dateResev.isBefore(LocalDate.now()) || (dateResev.isEqual(LocalDate.now()) && timeResev2.isBefore(LocalTime.now()))) {
                throw new IllegalArgumentException("Reservation time and date cannot be in the past");
            }

            
            timeResev = timeResev2;
        } catch (Anomalie e) {
            System.out.println("Exception: " + e.getMessage());
            // Handle the exception accordingly
        }
    }

    public LocalDate getDateResev() {
        return this.dateResev;
    }

    public void setDateResev(LocalDate dateResev2) {
        try {
            // Check if the reservation time and date is in the past
            if (dateResev2.isBefore(LocalDate.now()) || (dateResev2.isEqual(LocalDate.now()) && timeResev.isBefore(LocalTime.now()))) {
                throw new IllegalArgumentException("Reservation time and date cannot be in the past");
            }

            this.dateResev = dateResev2;
        } catch (Anomalie e) {
            System.out.println("Exception: " + e.getMessage());
            // Handle the exception accordingly
        }
    }

    /**
     * Constructor for objects of class Client
     */
    public Client( String nomClient, String prenomClient, Adresse adresse,Chambre Chambre,LocalTime timeResev,
    LocalDate dateResev)
    {
        this.numeroClient = nbClient++;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresse = adresse;
        this.Chambre=Chambre;
        this.Consommation= new ArrayList<String>();
        this.dateResev=dateResev;
        this.timeResev=timeResev;
    }
    public Client(String nomClient, String prenomClient, Adresse adresse, Chambre Chambre, LocalTime timeResev, LocalDate dateResev) {
        this.numeroClient = nbClient++;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresse = adresse;
        this.Chambre = Chambre;
        this.Consommation = new ArrayList<String>();

        try {
            // Check if the reservation time and date is in the past
            if (dateResev.isBefore(LocalDate.now()) || (dateResev.isEqual(LocalDate.now()) && timeResev.isBefore(LocalTime.now()))) {
                throw new IllegalArgumentException("Reservation time and date cannot be in the past");
            }

            this.dateResev = dateResev;
            this.timeResev = timeResev;
        } catch (Anomalie e) {
            System.out.println("Exception: " + e.getMessage());
            // Handle the exception accordingly
        }
    }
    public int getNumero() {
        return numeroClient;
    }

    public void setNumero(int numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nomClient;
    }

    public void setNom(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenom() {
        return prenomClient;
    }

    public void setPrenom(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Chambre getChambre() {
        return Chambre;
    }

    public void setChambre(Chambre Chambre) {
        this.Chambre = Chambre;
    }
    public ArrayList<String> getConsommation() {
        return Consommation;
    }

    public void setConsommation(ArrayList<String> Consommation) {
        this.Consommation = Consommation;
    }




public String toString() {
    int frameWidth = calculateFrameWidth("Client numéro : " + this.numeroClient);
    StringBuilder result = new StringBuilder();

    result.append(horizontalLineup(frameWidth));
    result.append(infoLine("Client numéro", Integer.toString(this.numeroClient), frameWidth));
    result.append(infoLine("nom", this.nomClient, frameWidth));
    result.append(infoLine("prénom", this.prenomClient, frameWidth));
    if (adresse!=null)  
        result.append(infoLine("adresse", this.adresse.toString(), frameWidth));
    result.append(infoLine("chambre", this.Chambre.toString(), frameWidth));
    if (dateResev!=null)        
        result.append(infoLine("date de reservation", this.dateResev.toString(), frameWidth));
    if (timeResev!=null)
        result.append(infoLine("temps de reservation", this.timeResev.toString(), frameWidth));
    result.append(horizontalLinedown(frameWidth));

    return result.toString();
}

private String horizontalLineup(int width) {
    return "╔" + repeat("═", width - 2) + "╗\n";
}

private String horizontalLinedown(int width) {
    return "╚" + repeat("═", width - 2) + "╝\n";
}

private String infoLine(String label, String value, int width) {
    StringBuilder line = new StringBuilder();
    line.append("║   ");
    line.append(label);
    line.append(": ");
    line.append(value);
    for (int i = 0; i < width - label.length() - value.length() - 7; i++) {
        line.append(" ");
    }
    line.append("║\n");
    return line.toString();
}

public static String repeat(String str, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(str);
    }
    return sb.toString();
}

private int calculateFrameWidth(String label) {
    // Assuming a minimum width of 40 for the frame
    int minWidth = 40;
    int labelLength = label.length();
    return Math.max(minWidth, labelLength + 14);
}

public void Consommer(String nomService, int prixService, int quantiteService){
    
    Consommation.add(quantiteService+ "x "+nomService+" prix= "+(prixService*quantiteService));
}

public void Consommer(String nomService, int prixService, int quantiteService,int remiseService){
    Consommation.add(quantiteService+ "x "+nomService+" prix= "+((prixService-prixService*remiseService)*quantiteService));
}


public static int convertirEnSecondes(String temps) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
    LocalTime localTime = LocalTime.parse(temps, formatter);
    return localTime.getMinute() * 60 + localTime.getSecond();
}

public void appeler(String tempsAppel,String destination){
    int tempsEnSecondes = convertirEnSecondes(tempsAppel);
    double prixAppel;
    switch (destination) {
        case "europe":
            prixAppel=tempsEnSecondes*16.66;
            Consommation.add("appel vers "+destination+" pour "+tempsEnSecondes+" prix "+prixAppel);
            break;
        case "amerique":
            prixAppel=tempsEnSecondes*20;
            Consommation.add("appel vers "+destination+" pour "+tempsEnSecondes+" prix "+prixAppel);
            break;
        case "asie":
            prixAppel=tempsEnSecondes*14.66;
            Consommation.add("appel vers "+destination+" pour "+tempsEnSecondes+" prix "+prixAppel);
            break;
        case "local":
            prixAppel=tempsEnSecondes*4.16;
            Consommation.add("appel vers "+destination+" pour "+tempsEnSecondes+" prix "+prixAppel);
            break;
        default:
            System.err.println("destination invalide!");
            break;
    }
    
}
}



    
