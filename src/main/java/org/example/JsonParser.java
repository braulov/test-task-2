package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for reading and writing JSON data.
 */
public class JsonParser {
    private final String filepath;

    /**
     * Constructs a JsonParser with the given file path.
     *
     * @param path The path to the JSON file to be parsed.
     */
    JsonParser(String path) {
        this.filepath = path;
    }

    /**
     * Reads JSON data from the file specified in the constructor and converts it into a Data object.
     *
     * @return A Data object containing the parsed JSON data.
     * @throws IOException    If an I/O error occurs while reading the file.
     * @throws ParseException If there is an error while parsing the JSON data.
     */
    Data readData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject problems = (JSONObject) parser.parse(new FileReader(filepath));
        JSONArray array = (JSONArray) problems.get("problems");
        Data data = new Data();
        for (Object object : array) {
            JSONObject currentProblem = (JSONObject) object;
            String hash = currentProblem.get("hash").toString();
            JSONArray problem_properties = (JSONArray) currentProblem.get("data");
            Problem problem = new Problem(hash, problem_properties);
            data.addProblem(problem);
        }
        return data;
    }

    /**
     * Writes the given Data object into a JSON file specified in the constructor.
     *
     * @param data The Data object to be written into the JSON file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    void writeData(Data data) throws IOException {

        JSONArray problemsArray = new JSONArray();
        for (Problem problem : data.getProblems()) {
            JSONObject currentProblem = new JSONObject();
            currentProblem.put("hash", problem.getHash());
            JSONArray currentData = Converter.convertToJSONArray(problem.getData());
            currentProblem.put("data", currentData);
            problemsArray.add(currentProblem);
        }
        JSONObject object = new JSONObject();
        object.put("problems", problemsArray);
        FileWriter file = new FileWriter(filepath);
        file.write(object.toJSONString());
        file.close();

    }
}
