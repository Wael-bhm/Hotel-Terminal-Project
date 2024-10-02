import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private Hotel hotel;
    private int numeroReservation ;
    int static nb = 0 ;  
    



        
    
    private LocalDateTime dateReserve;
    private LocalDateTime timeReserve;
    private int periodReserve;
    ClientResponsable ClientReservee;
    private ArrayList<Chambre> ChambreReserve;

    @Override
    public String toString() {
        return "{" +
            " hotel='" + getHotel() + "'" +
            ", numeroReservation='" + getNumeroReservation() + "'" +
            ", dateReserve='" + getDateReserve() + "'" +
            ", timeReserve='" + getTimeReserve() + "'" +
            ", periodReserve='" + getPeriodReserve() + "'" +
            ", ClientReservee='" + getClientReservee() + "'" +
            ", ChambreReserve='" + getChambreReserve() + "'" +
            "}";
    }

    
    /**
     * Constructor for objects of class Reservation
     */
    public Reservation(Hotel hotel, LocalDateTime dateReserve, LocalDateTime timeReserve, ClientResponsable ClientReservee, int periodReserve) {
        try {
            if (periodReserve < 1) {
                throw new IllegalArgumentException("Period reserve must be greater than or equal to 1");
            }
            this.periodReserve = periodReserve;
            this.numeroReservation = nb++;
            this.dateReserve = dateReserve;
            this.timeReserve = timeReserve;
            this.numeroReservation = numeroReservation;
            this.ClientReservee = ClientReservee;
            this.ChambreReserve = new ArrayList<Chambre>();
            this.hotel = hotel;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
        }
    }

    // Getters and setters
    public int getNumeroReservation() {
        return this.numeroReservation;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public LocalDateTime getDateReserve() {
        return this.dateReserve;
    }

    public void setDateReserve(LocalDateTime dateReserve) {
        this.dateReserve = dateReserve;
    }
    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public LocalDateTime getTimeReserve() {
        return this.timeReserve;
    }

    public void setTimeReserve(LocalDateTime timeReserve) {
        this.timeReserve = timeReserve;
    }

    public int getPeriodReserve() {
        return this.periodReserve;
    }

    public void setPeriodReserve(int periodReserve) {
        try {
            if (periodReserve < 1) {
                throw new IllegalArgumentException("Period reserve must be greater than or equal to 1");
            }
            this.periodReserve = periodReserve;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
        }
        
    }

    public ClientResponsable getClientReservee() {
        return this.ClientReservee;
    }

    public void setClientReservee(ClientResponsable ClientReservee) {
        this.ClientReservee = ClientReservee;
    }

    public ArrayList<Chambre> getChambreReserve() {
        return this.ChambreReserve;
    }

    public void setChambreReserve(ArrayList<Chambre> ChambreReserve) {
        this.ChambreReserve = ChambreReserve;
    }

    
    public void reserveCategory (ClientResponsable ClientReservee,Category CategoryReserve,int periodReserve){
        for (Chambre Chambre :CategoryReserve.getChambres()){
            if(Chambre.isReserved()==false && Chambre.isOccupied()==false){
                Chambre.setReserved(true);
                ClientReservee.getChambreRes().add(Chambre);
            }
            else{
                System.err.println("pas de chambre de cette category");
            }
        }}

        
    public void reserveChambre(ClientResponsable ClientReserve, Chambre ChambreReserve, int periodPourReserve) {
            try {
                if (!ChambreReserve.isOccupied() && !ChambreReserve.isReserved() && hotel.gettoutChambre().contains(ChambreReserve)) {
                    ChambreReserve.setReserved(true);
                    ClientReserve.getChambreRes().add(ChambreReserve);
                } else {
                    throw new Anomalie("La chambre est réservée ou n'existe pas.");
                }
            } catch (Anomalie e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        


    public void supprimeReserve(ClientResponsable ClientReservee,Chambre ChambreReserve){
        try {if(!ChambreReserve.isOccupied() && ChambreReserve.isReserved() && hotel.gettoutChambre().contains(ChambreReserve)){
            ChambreReserve.setReserved(false);}
        else{
            throw new Anomalie("La chambre n'est pas réservée ou n'existe pas.");
}}      catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }
    



    

    /**
     * Add a room to the reservation based on a specified category.
     */
    // Other methods...
}
