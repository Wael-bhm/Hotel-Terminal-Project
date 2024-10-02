//import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    //private Hotel hotel;
    private double price;
    private boolean hasShower;
    private boolean hasBath;
    private boolean hasTelevision;
    private List<Chambre> Chambres;

    /**
     * Constructor for objects of class Category
     */
    public Category(String name, double price, boolean hasShower, boolean hasBath, boolean hasTelevision, List<Chambre> Chambres, Hotel hotel) {
        this.name = name;
        try {
            if (price < 10 || price > 1000) {
                throw new IllegalArgumentException("Price must be between 10 and 1000");
            }
            this.price = price;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception accordingly (e.g., log the error, display an error message, etc.)
        }
        this.hasShower = hasShower;
        this.hasBath = hasBath;
        this.hasTelevision = hasTelevision;
        this.Chambres = Chambres;
        // this.hotel =hotel;
        hotel.addCategory(this);
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            if (price < 10 || price > 1000) {
                throw new IllegalArgumentException("Price must be between 10 and 1000");
            }
            this.price = price;
        } catch (Anomalie e) {
            System.out.println(e.getMessage());
            // Handle the exception accordingly (e.g., log the error, display an error message, etc.)
        }
    }

    public String hasShower() {
       if(hasShower) 
            return "Shower ";
        else
            return "";
    }

    public void setHasShower(boolean hasShower) {
        this.hasShower = hasShower;
    }

    public String hasBath() {
        if(hasBath)return "Bath ";
        else return "";
    }

    public void setHasBath(boolean hasBath) {
        this.hasBath = hasBath;
    }

    public String hasTelevision() {
        if(hasTelevision) {return "Television";}
        else return "";
    }

    public void setHasTelevision(boolean hasTelevision) {
        this.hasTelevision = hasTelevision;
    }

    public  List<Chambre>  getChambres() {
        return Chambres;
    }

    public void setChambres(List<Chambre> Chambres) {
        this.Chambres = Chambres;
    }
    
    //generate a new toString method like the one in Hotel.java

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int frameWidth = calculateFrameWidth(name);
        sb.append(horizontalLineup(frameWidth));
        sb.append(infoLine("Category Name", name, frameWidth));
        sb.append(infoLine("Price", String.valueOf(price), frameWidth));
        sb.append(infoLineFt("Features", hasShower(),hasBath(),hasTelevision(), frameWidth));
        sb.append(infoLine("Chambres", String.valueOf(Chambres.size()), frameWidth));
        sb.append(horizontalLinedown(frameWidth));
        return sb.toString();
    }
    //     @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(" ╔═════════════════════════════════╗\n");
    //     sb.append("║ ║ Category Name: ").append(name).append("        ║").append("\n");
    //     sb.append("║ ║ Price: ").append(price).append("                    ║").append("\n");
    //     sb.append("║ ║ Features: ");
    //     if (hasShower && hasBath && hasTelevision) {
    //         sb.append("Shower Bath Television");
    //         sb.append("   ║");
    //     }
    //     if (hasBath&&hasTelevision&&!hasShower) {
    //         sb.append("Bath Televison");
    //         sb.append("        ║");
    //     }
    //     if (hasTelevision&&!hasBath&&!hasShower) {
    //         sb.append("Television ");
    //         sb.append("    ║");
            
    //     } if (hasTelevision&&!hasBath&&hasShower) {
    //         sb.append("Shower Television ");
    //         sb.append("    ║");
            
    //     } 
    //     if(hasBath&&!hasTelevision&&!hasShower){
    //         sb.append("Bath  ");
    //         sb.append("    ║");
    //     }
    //     if (hasBath&&!hasTelevision&&hasShower) {
    //         sb.append("Shower Bath ");
    //         sb.append("    ║");
            
    //     }
    //     if (hasShower&&!hasTelevision&&!hasBath){
    //         sb.append("Shower ");
    //         sb.append("    ║");
            
    //     }
    //     sb.append("\n");
    //     sb.append("║ ║ Chambres: ").append("                      ║").append("\n");
        
    //     for (Chambre chambre : Chambres) {
    //         sb.append("║  ║   ").append(chambre.toString()).append("        ║").append("\n");
    //     }

    //     // Add any other fields as needed

    //     // Add closing separator
    //     sb.append("║ ╚═════════════════════════════════╝\n");

    //     return sb.toString();
    // }

    private String horizontalLineup(int width) {
        StringBuilder line = new StringBuilder();
        line.append(" ╔");
        for (int i = 0; i < width -4; i++) {
            line.append("═");
        }
        line.append("╗  ║\n");
        return line.toString();
    }
    private String horizontalLinedown(int width) {
        StringBuilder line = new StringBuilder();
        line.append("║ ╚");
        for (int i = 0; i < width -4; i++) {
            line.append("═");
        }
        line.append("╝  ║\n");
        return line.toString();
    }


    private String infoLine(String label, String value, int width) {
        StringBuilder line = new StringBuilder();
        line.append("║ ║ ");
        line.append(label);
        line.append(": ");
        line.append(value);
        for (int i = 0; i < width - label.length() - value.length() - 7; i++) {
            line.append(" ");
        }
        line.append("║  ║\n");
        return line.toString();
    }
    private String infoLineFt(String label, String value1,String value2,String value3, int width) {
        StringBuilder line = new StringBuilder();
        line.append("║ ║ ");
        line.append(label);
        line.append(": ");
        line.append(value1);
        line.append(value2);
        line.append(value3);
        for (int i = 0; i < width - label.length() - value1.length() - value2.length()- value3.length()- 7; i++) {
            line.append(" ");
        }
        line.append("║  ║\n");
        return line.toString();
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
        int minWidth = 37;
        int nameLength = name.length();
        return Math.max(minWidth, nameLength + 15);
    }
    
    
    public void addChambre(Chambre Chambre) {
        try {
            // Check if the Chambre already exists
            if (!Chambres.contains(Chambre)) {
                Chambres.add(Chambre);
            } else {
                throw new Anomalie("La chambre existe déjà dans la liste.");
            }
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Method to delete a Chambre from the table
    public void deleteChambre(Chambre Chambre) {
        try {
            // Check if the list is empty before attempting to remove a Chambre
            if (Chambres.isEmpty()) {
                throw new Anomalie("La liste des chambres est vide.");
            }

            // Check if the Chambre exists before removing
            if (Chambres.contains(Chambre)) {
                Chambres.remove(Chambre);
            } else {
                throw new Anomalie("La chambre n'existe pas dans la liste.");
            }
        } catch (Anomalie e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Other methods...
}
