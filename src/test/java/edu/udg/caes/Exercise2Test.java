package edu.udg.caes;

import com.sun.corba.se.impl.io.TypeMismatchException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise2Test {

    @Test
    public void testUnionEqualType(){
        Exercise2 e = new Exercise2();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        v2.add("x");
        v2.add("y");
        v2.add("z");
        v3.add(1);
        v3.add(2);
        v3.add(3);
        v3.add("x");
        v3.add("y");
        v3.add("z");
        final Vector result = e.union(v1,v2);
        assertThrows(TypeMismatchException.class, () -> Exercise2.union(v1,v2),"union parameters must have same type");
    }


    @Test
    public void testUnionRepeatedObjects()
    {
        Exercise2 e = new Exercise2();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        v2.add(2);
        v2.add(3);
        v2.add(4);
        v3.add(1);
        v3.add(2);
        v3.add(3);
        v3.add(4);
        final Vector result = e.union(v1,v2);
        assertEquals(v3, result, "union should not return repeated values");
    }

    @Test
    public void testUnionNotNull()
    {
        Exercise2 e = new Exercise2();
        Vector v1 = null;
        Vector v2 = new Vector();
        v2.add(1);
        assertThrows(IllegalArgumentException.class, () -> Exercise2.union(v1,v2),"union parameters can't be null");
    }

    @Test
    public void testUnionOrder()
    {
        Exercise2 e = new Exercise2();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v1.add(1);
        v1.add(2);
        v2.add(4);
        v2.add(3);
        v3.add(1);
        v3.add(2);
        v3.add(3);
        v3.add(4);
        final Vector result = e.union(v1,v2);
        assertEquals(v3, result, "if output Vector components are integers they should be ordered ascending");
    }

}
