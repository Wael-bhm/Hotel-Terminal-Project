import java.time.LocalDate;

public class Facture {
    private Client client;
    private int numeroFacture;
    private String modePaiement;
    private LocalDate dateFacture;
    private int remise;

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNumeroFacture() {
        return this.numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public void setModePaiement(String modePaiement) {
        if (!"check".equals(modePaiement) && !"espece".equals(modePaiement)) {
            // Throw Anomalie exception if the value is not "check" or "espece"
            try {
                throw new Anomalie("Le mode de paiement doit être 'check' ou 'espece'.");
            } catch (Anomalie anomalie) {
                // Handle the exception (you can print a message or log it)
                System.out.println("Erreur : " + anomalie.getMessage());
            }
        } else {
            this.modePaiement = modePaiement;
        }
    }



    public LocalDate getDateFacture() {
        return this.dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getRemise() {
        return this.remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }

    // Constructors, getters, setters, and other methods go here...

    // Constructor
    public Facture(Client client, int numeroFacture, String modePaiement, LocalDate dateFacture, int remise) {
        this.client = client;
        this.numeroFacture = numeroFacture;
        if (!"check".equals(modePaiement) && !"espece".equals(modePaiement)) {
            // Throw Anomalie exception if the value is not "check" or "espece"
            try {
                throw new Anomalie("Le mode de paiement doit être 'check' ou 'espece'.");
            } catch (Anomalie anomalie) {
                // Handle the exception (you can print a message or log it)
                System.out.println("Erreur : " + anomalie.getMessage());
            }
        } else {
            this.modePaiement = modePaiement;
        }
        this.dateFacture = dateFacture;
        this.remise = remise;
    }

    @Override
    public String toString() {
        int frameWidth = calculateFrameWidth("Facture");
        StringBuilder result = new StringBuilder();

        result.append(horizontalLineup(frameWidth));
        result.append(infoLine("client", this.getClient().toString(), frameWidth));
        result.append(infoLine("numeroFacture", Integer.toString(this.getNumeroFacture()), frameWidth));
        result.append(infoLine("modePaiement", this.getModePaiement(), frameWidth));
        result.append(infoLine("dateFacture", this.getDateFacture().toString(), frameWidth));
        result.append(infoLine("remise", Integer.toString(this.getRemise()), frameWidth));
        result.append(horizontalLinedown(frameWidth));

        return result.toString();
    }

    private String getModePaiement() {
        return null;
    }

    private String horizontalLineup(int width) {
        StringBuilder line = new StringBuilder();
        line.append("╔");
        line.append(repeat("═", width - 2));
        line.append("╗\n");
        return line.toString();
    }

    private String horizontalLinedown(int width) {
        StringBuilder line = new StringBuilder();
        line.append("╚");
        line.append(repeat("═", width - 2));
        line.append("╝\n");
        return line.toString();
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
    //generate a toString() function like in Hotel.java with infoline and --horizontalLinedown and horizontallineup
    
    

    // Getters and setters...

    // Additional methods...

}

