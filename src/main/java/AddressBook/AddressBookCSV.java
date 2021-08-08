package AddressBook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookCSV {
    public static void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        try (Writer writer = Files.newBufferedWriter(Paths.get("Contacts.csv"));) {
            StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Contacts> beanWriter = builder.build();
            beanWriter.write(AddressBook.contactList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDataFromCSV() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get("Contacts.csv"));
             CSVReader csvReader = new CSVReaderBuilder(reader).build();){
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}