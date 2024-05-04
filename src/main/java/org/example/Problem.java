package org.example;

import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a problem with its unique hash and associated data.
 */
public class Problem {
    private final String hash;
    private final HashSet<String> data;

    /**
     * Constructs a Problem object with the given hash and data.
     *
     * @param hash The unique hash identifier for the problem.
     * @param data The data associated with the problem, provided as an Iterable.
     */
    Problem(String hash, Iterable<String> data) {
        this.hash = hash;
        this.data = Converter.convertToHashSet(data);
    }

    /**
     * Retrieves the hash of the problem.
     *
     * @return The hash identifier of the problem.
     */
    public String getHash() {
        return this.hash;
    }

    /**
     * Retrieves the data associated with the problem.
     *
     * @return The data associated with the problem as a HashSet of strings.
     */
    public HashSet<String> getData() {
        return this.data;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare for equality.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(hash, problem.hash) && Objects.equals(data, problem.data);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(hash, data);
    }
}
