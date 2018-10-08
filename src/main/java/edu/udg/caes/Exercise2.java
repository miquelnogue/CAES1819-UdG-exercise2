package edu.udg.caes;

import java.util.Vector;

public class Exercise2 {

    /**
     * Vector union operation
     *
     *  @param a first vector
     *  @param b second vector
     *  @return objects that are in either one of the two argument vectors
     */
    public static Vector union (Vector a, Vector b)
    {
        Vector answer = (Vector)a.clone();
        answer.addAll(b);
        return answer;
    }

    /* Ambiguous:
        - can there be repeated objects?
        - do they follow any order?
        - can a & b be NULL?
        - can a & b components be different types?
    */
}
