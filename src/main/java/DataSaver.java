import com.google.gson.Gson;
import com.google.gson.JsonArray;
import lombok.NoArgsConstructor;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class DataSaver {
    public void saveData(List<Person> data) throws IOException {

        String jsonStr = new Gson().toJson(data);

        String pwd = "dataSaved/savedData_" + new Timestamp(new Date().getTime()).getTime() + ".txt";
        File file = new File(pwd);
        FileWriter writer = new FileWriter(pwd);
        writer.write(jsonStr);
        writer.close();
    }
}
