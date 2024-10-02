import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class ClientResponsable extends Client {
    private ArrayList<Chambre> ChambreRes;
    private Reservation Reservation; 

    public Reservation getReservation() {
        return this.Reservation;
    }

    public void setReservation(Reservation Reservation) {
        this.Reservation = Reservation;
    }
    public ClientResponsable(int numeroClient, String nomClient, String prenomClient, Adresse adresse,Chambre Chambre,LocalTime timeResev,
    LocalDate dateResev) {
        super(numeroClient, nomClient, prenomClient, adresse, Chambre,timeResev,dateResev);
        this.ChambreRes= new ArrayList<Chambre>();
        }
    public ArrayList<Chambre> getChambreRes() {
        return this.ChambreRes;
    }

    public void setChambreRes(ArrayList<Chambre> ChambreRes) {
        this.ChambreRes = ChambreRes;
    }
    public void  depart(){
        LocalDate currentDate = LocalDate.now();
        Scanner s = new Scanner(System.in);
        s.close();
        
        
        Facture facture= new Facture(this, getNumero(), getNom(),currentDate ,s.nextInt());
        for (Chambre chambre : ChambreRes) {
            chambre.setReserved(false);
            chambre.setResponsableChambre(null);
            chambre.setOccupied(false);

        
        
    }
       System.out.println(facture);}




    public void ajouterReservation(Reservation nouvelleReservation) {
        if (this.Reservation == null) {
            this.Reservation = nouvelleReservation;
        } else {
            System.out.println("Le client a déjà une réservation en cours.");
            // Vous pouvez également choisir de gérer ce cas d'une autre manière, selon vos besoins.
        }
    }
}