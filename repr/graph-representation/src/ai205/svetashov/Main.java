package ai205.svetashov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream file = new FileOutputStream("src/ai205/svetashov/input/input-blackbox.gr");
        TeePrintStream tee = new TeePrintStream(file, System.out);
        System.setOut(tee);

        //Part 1

        Matrix matrix = new Matrix();
        matrix.createIncidenceMatrix();



        //Part 2
        /*
        Clauses_Representation clauses_representation = new Clauses_Representation();
        clauses_representation.createIncidenceMatrix();
        clauses_representation.createVariables();
        clauses_representation.getDBResult();
        clauses_representation.triangles();
        clauses_representation.connectVariables();
        */
    }
}
