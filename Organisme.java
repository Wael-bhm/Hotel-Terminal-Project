import java.util.ArrayList;
import java.util.List;

public class Organisme {
    private String nomOrganisme;
    private List<Hotel> hotels;

    // Constructeur
    public Organisme(String nomOrganisme) {
        this.nomOrganisme = nomOrganisme;
        this.hotels = new ArrayList<Hotel>();  // Initialisez une liste vide
    }

    // Méthode pour afficher les informations de l'organisme
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Nom de l'organisme : ").append(nomOrganisme).append("\n");
        result.append("Liste des hôtels : \n");
        for (Hotel hotel : hotels) {
            result.append(hotel).append("\n");
        }
        return result.toString();
    }

    // Méthodes Getter et Setter pour nomOrganisme
    public String getNomOrganisme() {
        return nomOrganisme;
    }

    public void setNomOrganisme(String nomOrganisme) {
        this.nomOrganisme = nomOrganisme;
    }

    // Méthodes Getter et Setter pour hotels
    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
    
    // Méthode pour supprimer un hôtel de l'organisme
    public void removeHotel(Hotel hotel) {
        try {
            if (hotels != null && !hotels.isEmpty()) {
                hotels.remove(hotel);
            } else {
                throw new Anomalie("La liste d'hôtels est vide.");
            }
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    
    // Méthode pour ajouter un hôtel à l'organisme
    public void addHotel(Hotel hotel) {
        if (hotels == null) {
            hotels = new ArrayList<>();
        }
        hotels.add(hotel);
    }

}
