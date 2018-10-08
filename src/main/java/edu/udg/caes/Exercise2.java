package edu.udg.caes;

import com.sun.corba.se.impl.io.TypeMismatchException;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;
import java.util.Vector;

public class Exercise2 {

    /**
     * Vector union operation
     *
     *  @param a first vector
     *  @param b second vector
     *  @return objects that are in either one of the two argument vectors
     *
     *  @precondition: a!= null && b!= null
     *                  a->components.type = b->components.type
     *  @postcondition: no repeated objects
     *                  if the components' type is int, return union ordered ascending
     */
    public static Vector union (Vector a, Vector b) throws Exception
    {
        if(a==null || b==null)
            throw new IllegalArgumentException("Input parameters can't be null");

        if(!a.isEmpty() && !b.isEmpty() && a.get(0).getClass()!=b.get(0).getClass())
            throw new TypeMismatchException("Input parameters' components must have equal type");

        Vector answer = new Vector();

        for(Object o : a)
        {
            if(!answer.contains(o))
                answer.add(o);
        }
        for(Object o : b)
        {
            if(!answer.contains(o))
                answer.add(o);
        }

        if(!answer.isEmpty() && answer.get(0).getClass()==Integer.class)
        {
            answer.sort(Comparator.naturalOrder());
        }

        return answer;
    }
}
