package reader;

import com.google.gson.Gson;
import data.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public DataModel readJsonFile() throws FileNotFoundException {

        FileReader fileReader = new FileReader("data/testData.json");

        return new Gson().fromJson(fileReader, DataModel.class);

    }

    public static DataModel dataModel() throws FileNotFoundException {
        return new ReadDataFromJson().readJsonFile();
    }
}
