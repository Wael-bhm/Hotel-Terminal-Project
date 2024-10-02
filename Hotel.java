import java.time.LocalDate;

import java.util.ArrayList;


public class Hotel {
    
    private String name;
    private Organisme organisme;
    private String address;
    private LocalDate openingPeriodStart;
    private LocalDate openingPeriodEnd;
    private ArrayList<Chambre> toutChambre;

    

    private ArrayList<Category> categories;
    private int nombre_etage;
    // ...

    // Constructeur
    public Hotel(String name, Organisme organisme,ArrayList<Chambre> toutChambre , String address,LocalDate openingPeriodEnd,
            LocalDate openingPeriodStart, ArrayList<Category> categories, int nombre_etage) {

        try {
            // Vérifie si le nom de l'hôtel est déjà présent dans la liste
            for (Hotel existingHotel : organisme.getHotels()) {
                if (existingHotel.getName().equals(name)) {
                    throw new Anomalie("Un hôtel avec le même nom existe déjà dans l'organisme.");
                }
            }

            // Si le nom est unique, initialise les autres attributs
            this. toutChambre = toutChambre ;
            this.name = name;
            this.organisme = organisme;
            this.address = address;
            this.openingPeriodStart = openingPeriodStart;
            this.openingPeriodEnd = openingPeriodEnd;
            this.categories = categories;
            this.nombre_etage = nombre_etage;

            // Ajoute l'hôtel à la liste d'hôtels de l'organisme
            organisme.addHotel(this);
        } catch ( Anomalie e) {
            // Gérez l'exception ici (affichez le message d'erreur)
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ...

    // Méthodes Getter et Setter pour name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Méthodes Getter et Setter pour organisme
    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    // Méthodes Getter et Setter pour address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Méthodes Getter et Setter pour openingPeriodStart
    public LocalDate getOpeningPeriodStart() {
        return openingPeriodStart;
    }

    public void setOpeningPeriodStart(LocalDate openingPeriodStart) {
        this.openingPeriodStart = openingPeriodStart;
    }

    // Méthodes Getter et Setter pour openingPeriodEnd
    public LocalDate getOpeningPeriodEnd() {
        return openingPeriodEnd;
    }

    public void setOpeningPeriodEnd(LocalDate openingPeriodEnd) {
        this.openingPeriodEnd = openingPeriodEnd;
    }

    // Méthodes Getter et Setter pour categories
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    // Méthodes Getter et Setter pour nombre_etage
    public int getNombre_etage() {
        return nombre_etage;
    }

    public void setNombre_etage(int nombre_etage) {
        this.nombre_etage = nombre_etage;
    }
    public ArrayList<Chambre> gettoutChambre()
    {
		return toutChambre ; 
	}

    public void settoutChambre(ArrayList<Chambre> toutChambre)
    {
		this.toutChambre = toutChambre;
	}
    public String toString() {
        int frameWidth = calculateFrameWidth(this.getName());
        StringBuilder result = new StringBuilder();

        result.append(horizontalLineup(frameWidth));
        result.append(infoLine("name", this.getName(), frameWidth));
        result.append(infoLine("organisme", this.getOrganisme().getNomOrganisme(), frameWidth));
        result.append(infoLinech("toutChambre", toutChambre, frameWidth));
        
        result.append("\n");
        result.append(infoLine("address", this.getAddress(), frameWidth));
        result.append(infoLine("openingPeriodStart", this.getOpeningPeriodStart().toString(), frameWidth));
        result.append(infoLine("openingPeriodEnd", this.getOpeningPeriodEnd().toString(), frameWidth));
        result.append("");
        for (Category category : categories) {
            result.append("║").append(category.toString());
        } 

        result.append(infoLine("nombre_etage", Integer.toString(this.getNombre_etage()), frameWidth));
        result.append(horizontalLinedown(frameWidth));

        return result.toString();
    }

    private String horizontalLineup(int width) {
        StringBuilder line = new StringBuilder();
        line.append("╔");
        for (int i = 0; i < width - 2; i++) {
            line.append("═");
        }
        line.append("╗\n");
        return line.toString();
    }
    private String horizontalLinedown(int width) {
        StringBuilder line = new StringBuilder();
        line.append("╚");
        for (int i = 0; i < width - 2; i++) {
            line.append("═");
        }
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

    private String infoLinech(String label, ArrayList<Chambre> Chambres, int width) {
        StringBuilder line = new StringBuilder();
        line.append("║   ");
        line.append(label);
        line.append(": ");
        line.append(Chambres.get(0).getNumeroChambre());
        for (int i = 1; i < 6; i++) {
            if(i%4==0){
                line.append(","+Chambres.get(i).getNumeroChambre());
                line.append("   ║");
                
            }
            if((i==5) || (i%8==0)){
                line.append("\n║   ");
                line.append(Chambres.get(i).getNumeroChambre());
            }
            else if(i%4!=0 && i%5!=0){
                line.append(","+Chambres.get(i).getNumeroChambre());}
            
        }

        for (int i = 6; i < Chambres.size(); i++) {
            
            if(((i-6)%8==0)){
                line.append(",");
                line.append(Chambres.get(i).getNumeroChambre());
            }
            else {
                line.append(","+Chambres.get(i).getNumeroChambre());}
            
        }

        if(Chambres.size()>5){
            for (int j = width+1; j < ((Chambres.size()/5)*(width+1))+(width+1); j=j+width-1) {
                if (j % (width ) == 0) {
                    appendCharAt(line, j, '║');
            }
        }}
        
        
        return line.toString();
    }
    public static StringBuilder appendCharAt(StringBuilder sb, int index, char ch) {
        while (sb.length() < index) {
            sb.append(" ");
        }
        sb.append(ch);
        return sb;
    }
    
public static String repeat(String str, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(str);
    }
    return sb.toString();
}

    private int calculateFrameWidth(String hotelName) {
        // Assuming a minimum width of 40 for the frame
        int minWidth = 40;
        int nameLength = hotelName.length();
        return Math.max(minWidth, nameLength + 14);
    }
    
    
    public void addCategory(Category category) {
        try {
            // Vérifie si la catégorie n'existe pas déjà
            if (!categories.contains(category)) {
                categories.add(category);
            } else {
                throw new Anomalie("La catégorie existe déjà dans la liste.");
            }
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Méthode pour supprimer une catégorie
    public void deleteCategory(Category category) {
        try {
            // Vérifie si la catégorie existe avant de la supprimer
            if (categories.contains(category)) {
                categories.remove(category);
            } else {
                throw new Anomalie("La catégorie n'existe pas dans la liste.");
            }
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

}
