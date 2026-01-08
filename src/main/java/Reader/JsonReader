package Reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

    private JsonNode jsonArray;

    public JsonReader(String filename, String arrayName) throws IOException {

        File file = new File(
            System.getProperty("user.dir")
            + "\\src\\test\\resources\\Testdata\\"
            + filename
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(file);

        this.jsonArray = rootNode.get(arrayName);
    }

    // 🔹 Similar to getSpecificCellData(row, column)
    public Object getSpecificData(int row, String key) {

        JsonNode value = jsonArray.get(row).get(key);

        if (value.isTextual()) {
            return value.asText();
        } else if (value.isInt()) {
            return value.asInt();
        } else if (value.isDouble()) {
            return value.asDouble();
        } else if (value.isBoolean()) {
            return value.asBoolean();
        } else if (value.isNull()) {
            return "";
        } else {
            return value.toString();
        }
    }

    // 🔹 Similar to getAllData()
    public Object[][] getAllData() {

        int totalRows = jsonArray.size();
        int totalColumns = jsonArray.get(0).size();

        Object[][] data = new Object[totalRows][totalColumns];

        int colIndex;
        for (int i = 0; i < totalRows; i++) {
            colIndex = 0;
            for (String key : jsonArray.get(i).fieldNames()) {
                data[i][colIndex++] = getSpecificData(i, key);
            }
        }
        return data;
    }
}
