package org.example;

import org.json.simple.JSONArray;

import java.util.HashSet;

/**
 * Utility class for converting data types.
 */
public class Converter {

    /**
     * Converts an Iterable of strings to a HashSet.
     *
     * @param data The Iterable of strings to be converted.
     * @return A HashSet containing the elements from the Iterable.
     */
    public static HashSet<String> convertToHashSet(Iterable<String> data) {
        HashSet<String> resultSet = new HashSet<>();
        for (String element : data) {
            resultSet.add(element);
        }
        return resultSet;
    }

    /**
     * Converts an Iterable of strings to a JSONArray.
     *
     * @param data The Iterable of strings to be converted.
     * @return A JSONArray containing the elements from the Iterable.
     */
    public static JSONArray convertToJSONArray(Iterable<String> data) {
        JSONArray array = new JSONArray();
        for (String element : data) {
            array.add(element);
        }
        return array;
    }
}
