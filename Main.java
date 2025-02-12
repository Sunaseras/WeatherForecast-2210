Ось простий приклад програми на Java, яка обробляє дані. Цей код читає файл, обробляє дані (видаляє дублікати) та зберігає результат у новий файл.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataProcessor {
    private String inputFilePath;
    private String outputFilePath;

    public DataProcessor(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void process() {
        Set<String> uniqueLines = new HashSet<>();

        // Читання файлу
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                uniqueLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Збереження результату
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (String uniqueLine : uniqueLines) {
                writer.write(uniqueLine);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DataProcessor <inputFilePath> <outputFilePath>");
            return;
        }

        DataProcessor processor = new DataProcessor(args[0], args[1]);
        processor.process();
    }
}
```
Ця програма має менше 150 рядків коду, але це повноцінний приклад обробки даних. Для більш складних завдань ви могли б додати більше функцій, таких як вилучення непотрібних даних, перетворення даних у визначений формат та інше.