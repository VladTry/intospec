package discount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Discount {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/discount/discnt.in"));
        String line = reader.readLine();
        
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < line.split(" ").length; i++) {
            list.add(Double.parseDouble(line.split(" ")[i]));
        }
        
        int discount = Integer.parseInt(reader.readLine());
        reader.close();
        
        list = findSale(list, discount);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/discount/discnt.out"));
        writer.write(sum + "");
        writer.close();
        
    }
    
    public static List<Double> findSale(List<Double> list, int discount) {
        Collections.sort(list,  Collections.reverseOrder());
        for (int i = 0; i < list.size() / 3; i++) {
            double count = list.get(i) * (100 - discount) / 100.0;
            list.set(i, count);
        }
        
        return list;
    }
}