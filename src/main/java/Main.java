import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try (Document document = new Document(new PdfDocument(new PdfWriter("./hello-pdf.pdf")))) {
            float [] pointColumnWidths = {200F, 200F, 200F}; // Define column widths
            Table table = new Table(UnitValue.createPercentArray(pointColumnWidths));

            table.addCell("FAKTURA FV 7/08/2023");
            table.addCell("DUPLIKAT Z DNIA 31-08-2023");
            table.addCell("Data wystawienia: 31-08-2023");

            table.addCell("Sprzedawca:");
            table.addCell("PHU Jan Kowalski\nNIP: 4211132842\nRaczyńska 1\n60-135 Poznań");
            table.addCell("Nabywca:\nNowicka Janina\nAdama Logi 47/82\n61-134 Poznań");

            table.addCell("Lp.");
            table.addCell("Nazwa towaru lub usługi");
            table.addCell("Jm.");
            table.addCell("Ilość");
            table.addCell("Cena netto");
            table.addCell("VAT");
            table.addCell("Wartość netto");
            table.addCell("Wartość VAT");
            table.addCell("Wartość brutto");

            // Sample data row
            table.addCell("1");
            table.addCell("Towar 1");
            table.addCell("szt.");
            table.addCell("1");
            table.addCell("500.00");
            table.addCell("23%");
            table.addCell("500.00");
            table.addCell("115.00");
            table.addCell("615.00");

            document.add(table);

            // Close the document
            document.close();
            System.out.println("Invoice created successfully!");
        }
        catch (FileNotFoundException e) {
        }
    }
}
