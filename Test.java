/* 
import java.time.LocalDate;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Organisme organisme = new Organisme("Sousse Hotels");
        Category category1 = new Category("Category1", 100.0, true, false, true, new ArrayList<>(), null);
        Category category2 = new Category("Category2", 150.0, false, true, true, new ArrayList<>(), null);
        ArrayList<Category> categoryList = new ArrayList<>();
        Hotel hotel1 ; 
        
        hotel1 = new Hotel("adamHotel", organisme, new ArrayList<>(), "hotel1 Address",
                LocalDate.now(), LocalDate.now().plusDays(7), categoryList, 3);
        

        categoryList.add(category1);
        categoryList.add(category2);
        ArrayList<Chambre> chambreList = new ArrayList<>();
        Chambre chambre1 = new Chambre(hotel1, category1, 2, 1, 1, 101);
        Chambre chambre2 = new Chambre(hotel1, category2, 1, 2, 2, 202);
        chambreList.add(chambre1);
        chambreList.add(chambre2);

        // Set the Chambres for the categories
        category1.setChambres(chambreList);
        category2.setChambres(chambreList);
       // Adresse adresseMovapic = new Adresse("ibnKholdoun", 0, "babBhar", 4000, "sousse", "tunise", 26145555, "mohad@gmail.com", "moampic@gmail.com"); 
        
;


        // Set the hotel1 for the categories
      //  category1.setHotel(hotel1);
       // category2.setHotel(hotel1);

        // Create some rooms


        // Create an ArrayList of rooms


        // Print the hotel1 details using the toString method
        System.out.println(hotel1);

        // Test the addCategory method
        Category newCategory = new Category("NewCategory", 120.0, true, true, false, new ArrayList<>(), null);
        hotel1.addCategory(newCategory);
        System.out.println("Categories after adding a new one: " + hotel1.getCategories());

        // Test the deleteCategory method
        hotel1.deleteCategory(newCategory);
        System.out.println("Categories after deleting the new one: " + hotel1.getCategories());
    }
}
*/
import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Organisme organisme = new Organisme("Sousse Hotels");
        ArrayList<Category> categoryList = new ArrayList<>();
        ArrayList<Chambre> chambreList = new ArrayList<>();
         
        
        Hotel hotel1 = new Hotel("adamHotel", organisme,  chambreList, "hotel1 Address",
                LocalDate.now(), LocalDate.now().plusDays(7), categoryList, 3);
                
        Category category1 = new Category("Category1", 100.0, true, false, true, new ArrayList<>(), hotel1);
        Category category2 = new Category("Category2", 150.0, false, true, true, new ArrayList<>(), hotel1);
        //make Chambre for category1 and category2

        Chambre chambre1 = new Chambre(hotel1, category1, 2, 1, 1, 101);
        Chambre chambre2 = new Chambre(hotel1, category2, 1, 2, 2, 201);
        //make another chambre for category1 and category2
        Chambre chambre3 = new Chambre(hotel1, category1, 2, 1, 1, 102);
        Chambre chambre4 = new Chambre(hotel1, category2, 1, 2, 2, 202);
        //make another chambre for category1  and category2
        
        Chambre chambre5 = new Chambre(hotel1, category1, 2, 1, 1, 103);
        //make another chambre for category1
        Chambre chambre6 = new Chambre(hotel1, category2, 1, 2, 2, 203);
        //make another chambre for category2
        Chambre chambre7 = new Chambre(hotel1, category2, 1, 2, 2, 204);
        //make another chambre for category2 and category1  
        Chambre chambre8 = new Chambre(hotel1, category1, 2, 1, 1, 104);
        Chambre chambre9 = new Chambre(hotel1, category2, 1, 2, 2, 205);
        //make another chambre for category2 and category1
        Chambre chambre10 = new Chambre(hotel1, category1, 2, 1, 1, 105);
        Chambre chambre11 = new Chambre(hotel1, category2, 1, 2, 2, 206);
        


        //make another chambre for category2
        Chambre chambre12 = new Chambre(hotel1, category2, 1, 2, 2, 207);
        //add chambre1 and chambre2 to chambreList in one line
        //add chambre3 and chambre4 to chambreList in one line

        chambreList.add(chambre1); chambreList.add(chambre2);
        chambreList.add(chambre3); chambreList.add(chambre4);
        chambreList.add(chambre5); chambreList.add(chambre6);
        chambreList.add(chambre7); chambreList.add(chambre8);
        chambreList.add(chambre9); chambreList.add(chambre10);
        // chambreList.add(chambre11); chambreList.add(chambre12);
        
        //make client for chambre1 and chambre2
        Client client1 = new Client(1, "Chamakhi", "Islem", null, chambre1, null, null);
        Client client2 = new Client(2, "Dabbebi", "Skander", null, chambre2, null, null);
        //make an instance of Facture for client1 and client2
        Facture facture1 = new Facture( client1, 100.0, "espece", LocalDate.now().plusDays(7), false);
        System.err.println(facture1);

        // Add categories to the categoryList
        //categoryList.add(category1);
        //categoryList.add(category2);
        //categoryList.add(category1);
        //categoryList.add(category2);
        System.out.print(client1);
        System.out.print(hotel1);
        System.out.print("\n║"+category1);
        System.out.print("\n║"+category2);
        System.out.print(" "+chambre1);
        // Rest of your Test class...
        
    }
    }

