import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class FileApparel {
    private String fileName = "apparels_data.txt";

    public FileApparel(String fileName) {
        this.fileName = fileName;
    }

    public LinkedList loadApparel() {
        LinkedList apparels = new LinkedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                    StringTokenizer token = new StringTokenizer(line, ":");
                    if (token.countTokens() == 6) {
                        String itemCode = token.nextToken();
                        String name = token.nextToken();
                        String brand = token.nextToken();
                        int quantity = Integer.parseInt(token.nextToken());
                        double price = Double.parseDouble(token.nextToken());
                        String size = token.nextToken();

                        ApparelItem apparel = new ApparelItem(itemCode, name, brand, quantity, price, size);
                        apparels.insertAtBack(apparel);
                    }
                }
                return apparels;
        }catch (IOException | NumberFormatException e) {
                e.printStackTrace();
        } 
        return apparels;
        }

    public void updateApparel(LinkedList apparels) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            Object data = apparels.getFirst();
            while (data != null) {
                ApparelItem apparel = (ApparelItem) data;
                writer.println(apparel.getItemCode() + ":" + apparel.getName() + ":"
                               + apparel.getBrand() + ":" + apparel.getQuantity() + ":"
                               + apparel.getPrice() + ":" + apparel.getSize());
                data = apparels.getNext();

            }
            System.out.println("Apparel data updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
           
        
    }

}

