package com.mysql;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws SQLException, ClassNotFoundException {
        MyConnection con = new MyConnection();
        con.getConnection();
        con.closeConnection();
    }
}

class Demo {

    public static void main(String args[]) {

        byte a = 127;

        System.out.println(a);

        a++;

        System.out.println(a);

        a++;

        System.out.println(a);

        a++;

        System.out.println(a);

    }

}
