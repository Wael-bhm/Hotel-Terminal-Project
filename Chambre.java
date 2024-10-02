import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class Chambre {
    private Hotel hotel;
    private Category category;
    private ArrayList<Client> clients;
    private boolean reserve;
    private boolean occupe;
    private int nbrLitOnePlace;
    private int nbrLitTwoPlace;
    private int nbrEtage;
    private int numeroChambre;
    private int periodEffective;
    private ClientResponsable responsableChambre;

    public boolean isReserve() {
        return this.reserve;
    }

    public boolean getReserve() {
        return this.reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public boolean isOccupe() {
        return this.occupe;
    }

    public boolean getOccupe() {
        return this.occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public ClientResponsable getResponsableChambre() {
        return this.responsableChambre;
    }

    public void setResponsableChambre(ClientResponsable responsableChambre) {
        this.responsableChambre = responsableChambre;
    }


    public Chambre(Hotel hotel, Category category, int nbrLitOnePlace, int nbrLitTwoPlace, int nbrEtage, int numeroChambre) {
        this.hotel = hotel;
        this.category = category;
        this.clients = new ArrayList<>();
        this.reserve = false;
        this.occupe = false;
        // BEGIN: ed8c6549bwf9
        try {
            if (nbrLitOnePlace + nbrLitTwoPlace > 3) {
                throw new IllegalArgumentException("The sum of nbrLitOnePlace and nbrLitTwoPlace cannot be greater than 3.");
            }
            this.nbrLitOnePlace = nbrLitOnePlace;
            this.nbrLitTwoPlace = nbrLitTwoPlace;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
        // END: ed8c6549bwf9
        try {
            if (nbrEtage < 0 || nbrEtage > 10) {
                throw new IllegalArgumentException("The value of nbrEtage must be between 0 and 10.");
            }
            this.nbrEtage = nbrEtage;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
        try {
            
            if (hotel.getToutChambre().stream().anyMatch(chambre -> chambre.getNumeroChambre() == numeroChambre)) {
                throw new IllegalArgumentException("The entered number already exists in the 'toutChambre' ArrayList.");
            }
            this.numeroChambre = numeroChambre;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
        periodEffective=1 ; //douma maya5e4ha saye ytfactarlou nhar 
        category.addChambre(this);
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        int  daysDifference ; 
        if (reserve == true) {
            
            daysDifference = (int) ChronoUnit.DAYS.between(currentDate, responsableChambre.getDateResev()); 
            if (daysDifference > 0 ) {
                periodEffective = daysDifference +1;

            } 
            if (occupe == true){
            LocalDate dateResev = clients.get(0).getDateResev();
            LocalTime timeResev = clients.get(0).getTimeResev();
            daysDifference = (int) ChronoUnit.DAYS.between(currentDate, dateResev);
            int timeDifference = currentTime.getHour() - timeResev.getHour();
            periodEffective = (24 * daysDifference) + timeDifference;
        }
            else {
                periodEffective = 0 ; 
            }
        }
        
        
    }
    
    public int getPeriodEffective() {
        return periodEffective;
    }

    // Setter for periodEffective
    public void setPeriodEffective(int periodEffective) {
        this.periodEffective = periodEffective;
    }
    
    public Hotel getHotel() {
        return hotel;
    }
}
        this.nbrLitOnePlace = nbrLitOnePlace;
        this.nbrLitTwoPlace = nbrLitTwoPlace;
        
        this.nbrEtage = nbrEtage;
        this.numeroChambre = numeroChambre;
        periodEffective=1 ; //douma maya5e4ha saye ytfactarlou nhar 
        category.addChambre(this);
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        int  daysDifference ; 
        if (reserve == true) {
            
            daysDifference = (int) ChronoUnit.DAYS.between(currentDate, responsableChambre.getDateResev()); 
            if (daysDifference > 0 ) {
                periodEffective = daysDifference +1;

            } 
            if (occupe == true){
            LocalDate dateResev = clients.get(0).getDateResev();
            LocalTime timeResev = clients.get(0).getTimeResev();
            daysDifference = (int) ChronoUnit.DAYS.between(currentDate, dateResev);
            int timeDifference = currentTime.getHour() - timeResev.getHour();
            periodEffective = (24 * daysDifference) + timeDifference;
        }
            else {
                periodEffective = 0 ; 
            }
        }
        
        
    
    
    public int getPeriodEffective() {
        return periodEffective;
    }

    // Setter for periodEffective
    public void setPeriodEffective(int periodEffective) {
        this.periodEffective = periodEffective;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    // Setter for hotel
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // Getter for category
    public Category getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter for clients
    public ArrayList<Client> getClients() {
        return clients;
    }

    // Setter for clients
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    // Getter for reserve
    public String isReserved() {
        if(reserve == true){
            return "reserved";
        }
        else{
            return "";
        }
    }

    // Setter for reserve
    public void setReserved(boolean reserve) {
        this.reserve = reserve;
    }

    // Getter for occupe
    public String isOccupied() {
        if(occupe == true){
            return "occupied";
        }
        else{
            return "";
        }   
    }

    // Setter for occupe
    public void setOccupied(boolean occupe) {
        this.occupe = occupe;
    }

    // Getter for nbrLitOnePlace
    public int getNbrLitOnePlace() {
        return nbrLitOnePlace;
    }

    // Setter for nbrLitOnePlace
    public void setNbrLitOnePlace(int nbrLitOnePlace2) {
        try {
            if (nbrLitOnePlace2 + nbrLitTwoPlace > 3) {
                throw new IllegalArgumentException("The sum of nbrLitOnePlace and nbrLitTwoPlace cannot be greater than 3.");
            }
            this.nbrLitOnePlace = nbrLitOnePlace2;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
    }

    // Getter for nbrLitTwoPlace
    public int getNbrLitTwoPlace() {
        return nbrLitTwoPlace;
    }

    // Setter for nbrLitTwoPlace
    public void setNbrLitTwoPlace(int nbrLitTwoPlace2) {
        try {
            if (nbrLitOnePlace + nbrLitTwoPlace2 > 3) {
                throw new IllegalArgumentException("The sum of nbrLitOnePlace and nbrLitTwoPlace cannot be greater than 3.");
            }
            
            this.nbrLitTwoPlace = nbrLitTwoPlace2;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
    }

    // Getter for nbrEtage
    public int getNbrEtage() {
        return nbrEtage;
    }

    // Setter for nbrEtage
    public void setNbrEtage(int nbrEtage) {
        try {
            if (nbrEtage < 0 || nbrEtage > 10) {
                throw new IllegalArgumentException("The value of nbrEtage must be between 0 and 10.");
            }
            this.nbrEtage = nbrEtage;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
    }

    // Getter for numeroChambre
    public int getNumeroChambre() {
        return numeroChambre;
    }

    // Setter for numeroChambre
    public void setNumeroChambre(int numeroChambre) {
        try {
            
            if (hotel.getToutChambre().stream().anyMatch(chambre -> chambre.getNumeroChambre() == numeroChambre)) {
                throw new IllegalArgumentException("The entered number already exists in the 'toutChambre' ArrayList.");
            }
            this.numeroChambre = numeroChambre;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception as per your requirement
        }
    }

    private String horizontalLineup(int width) {
        StringBuilder line = new StringBuilder();
        line.append(" ╔");
        for (int i = 0; i < width -4; i++) {
            line.append("═");
        }
        line.append("╗  \n");
        return line.toString();
    }
    private String horizontalLinedown(int width) {
        StringBuilder line = new StringBuilder();
        line.append("  ╚");
        for (int i = 0; i < width -4; i++) {
            line.append("═");
        }
        line.append("╝ \n");
        return line.toString();
    }

    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private int calculateFrameWidth(ArrayList<Client> clients) {
        // Assuming a minimum width of 40 for the frame
        int minWidth = 40;
        int nameLength = 0;
        for (int i = 0; i < clients.size(); i++) {
            nameLength += clients.get(i).getNom().length();
        }
        int nameLength2 = "    nombre de lits à deux personne: ".length();

        return Math.max(minWidth, Math.max(nameLength + 15, Math.max(nameLength, nameLength2)));
    }


    private String infoLine(String label, String value, int width) {
        StringBuilder line = new StringBuilder();
        line.append("  ║ ");
        line.append(label);
        line.append(": ");
        line.append(value);
        for (int i = 0; i < width - label.length() - value.length() - 7; i++) {
            line.append(" ");
        }
        line.append("║\n");
        return line.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre Chambre = (Chambre) o;
        return numeroChambre == Chambre.numeroChambre &&
                Objects.equals(hotel, Chambre.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroChambre, hotel);
    }

    @Override
    public String toString() {
        int frameWidth = calculateFrameWidth(this.getClients());
        StringBuilder result = new StringBuilder();

        result.append(horizontalLineup(frameWidth));
        result.append(infoLine("nom hotel", hotel.getName(), frameWidth));
        result.append(infoLine("organisme", this.getCategory().getName(), frameWidth));
        result.append(infoLine("numero chambre", Integer.toString(this.getNumeroChambre()), frameWidth));
        for(int i=0;i<clients.size();i++){
            result.append(infoLine("nom client", clients.get(i).getNom(), frameWidth));
        }
        result.append(infoLine("", this.isReserved(), frameWidth));
        result.append(infoLine("", this.isOccupied(), frameWidth));
        result.append(infoLine("nombre de litss à une personne",Integer.toString (this.getNbrLitOnePlace()), frameWidth));
        result.append(infoLine("nombre de litss à deux personne",Integer.toString (this.getNbrLitTwoPlace()), frameWidth));
        

        result.append(infoLine("nombre_etage", Integer.toString(this.getNbrEtage()), frameWidth));
        result.append(infoLine("période effettive", Integer.toString(this.getPeriodEffective()), frameWidth));
        result.append(horizontalLinedown(frameWidth));

        return result.toString();
    }
}
