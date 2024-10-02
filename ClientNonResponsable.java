import java.time.LocalDate;
import java.time.LocalTime;

class ClientNonResponsable extends Client{
    private Client ClientResponsable;

    public Client getClientResponsable() {
        return this.ClientResponsable;
    }

    public void setClientResponsable(Client ClientResponsable) {
        this.ClientResponsable = ClientResponsable;
    }
    public ClientNonResponsable(int numeroClient, String nomClient, String prenomClient, Adresse adresse,Chambre Chambre, Client ClientResponsable, LocalTime timeResev,
    LocalDate dateResev) {
        super(numeroClient, nomClient, prenomClient, adresse, Chambre,timeResev,dateResev);
        this.ClientResponsable=ClientResponsable;
    }}