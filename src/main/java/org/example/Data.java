package org.example;

import java.util.HashSet;

/**
 * Represents a collection of problems.
 */
public class Data {

    private final HashSet<Problem> problems;

    /**
     * Constructs an empty Data object.
     */
    Data() {
        this.problems = new HashSet<>();
    }

    /**
     * Constructs a Data object with the specified set of problems.
     *
     * @param problems The set of problems to be included in the Data object.
     */
    Data(HashSet<Problem> problems) {
        this.problems = problems;
    }


    /**
     * Retrieves the problems that exist only in the first Data object and not in the second.
     *
     * @param data1 The first Data object.
     * @param data2 The second Data object.
     * @return A Data object containing problems that exist only in the first Data object.
     */
    public static Data getProblemsOnlyInFirstData(Data data1, Data data2) {
        HashSet<Problem> onlyInFirst = new HashSet<>();
        for (Problem problem : data1.problems) {
            if (!data2.problems.contains(problem)) {
                onlyInFirst.add(problem);
            }
        }
        return new Data(onlyInFirst);
    }

    /**
     * Retrieves the problems that exist in both Data objects.
     *
     * @param data1 The first Data object.
     * @param data2 The second Data object.
     * @return A Data object containing problems that exist in both Data objects.
     */
    public static Data getProblemsInBoth(Data data1, Data data2) {
        HashSet<Problem> inBoth = new HashSet<>();
        for (Problem problem : data1.problems) {
            if (data2.problems.contains(problem)) {
                inBoth.add(problem);
            }
        }
        return new Data(inBoth);
    }

    /**
     * Retrieves the set of problems in this Data object.
     *
     * @return The set of problems.
     */
    public HashSet<Problem> getProblems() {
        return problems;
    }

    /**
     * Adds a problem to this Data object.
     *
     * @param problem The problem to be added.
     */
    public void addProblem(Problem problem) {
        problems.add(problem);
    }

}
