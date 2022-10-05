package ai205.svetashov;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Clauses_Representation {

    private int rowsSize = 0;
    private int columnsSize = 0;
    private int[][] twoDimensionalArray;

    private int amountOfLines;

    ArrayList<Clauses> clauses = new ArrayList<Clauses>();
    ArrayList<Variables> variables = new ArrayList<Variables>();

    public Clauses_Representation() {
        read();
        twoDimensionalArray = new int[rowsSize][columnsSize];
        fullTwoDimensionalArray();
    }

    private void fullTwoDimensionalArray() {
        for (int i = 0; i < rowsSize - 1; i++) {
            for (int j = 0; j < columnsSize - 1; j++) {
                twoDimensionalArray[i][j] = 0;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rowsSize - 1; i++) {
            for (int j = 0; j < columnsSize - 1; j++) {
                System.out.printf("%d ", twoDimensionalArray[i][j]);
            }
            System.out.println();
        }
    }


    private void read() {
        try {
            File devFile = new File("src/ai205/svetashov/input/input-graph-representation.txt");
            Scanner devScanner = new Scanner(devFile);

            if (devScanner.hasNext()) {
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(" ");
                setRowsSize(Integer.valueOf(Integer.parseInt(devData[3])));//535//91
                setColumnsSize(Integer.valueOf(Integer.parseInt(devData[2])));//125//20
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void createIncidenceMatrix() {
        int j = 0;
        int i = 0;
        int counter = 0;
        int temp;


        try {

            File devFile = new File("src/ai205/svetashov/input/input-graph-representation.txt");
            Scanner devScanner = new Scanner(devFile);

            while (devScanner.hasNext()) {
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(" ");

                if (counter != 0 && counter <= getRowsSize()) {

                    amountOfLines = getRowsSize() * (devData.length - 1);
                    if (counter == 1) {
                        System.out.println("p" + " tw " + ((getRowsSize() * (devData.length-1))+(2*getColumnsSize()))+ " " + (((((getRowsSize() * (devData.length-1))+getColumnsSize())+(getRowsSize()*(devData.length-1))))));
                    }

                    int result = 1;
                    for (int k = 0; result != 0; k++) {
                        result = Integer.valueOf(Integer.parseInt(devData[k]));
                        if (result != 0) {
                            char symbol = '+';
                            if (result < 0) {
                                symbol = '-';
                            }
                            temp = Integer.valueOf(Integer.parseInt(devData[k]));
                            //System.out.println(counter + " " + temp);
                            Clauses clauseInstance = new Clauses(counter, Math.abs(temp), symbol);
                            clauses.add(clauseInstance);
                        }
                    }
                    i++;
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void getClauses() {
        for (int i = 0; i < clauses.size(); i++) {
            System.out.println(clauses.get(i).index + " " + clauses.get(i).variable + " " + clauses.get(i).symbol);
        }
    }


    public void createVariables() {
        for (int i = 1, j = 1; i <= columnsSize * 2; i++, j++) {
            Variables variablesInstancePlus = new Variables(amountOfLines + i, j, '+');
            i++;
            Variables variablesInstanceMinus = new Variables(amountOfLines + i, j, '-');
            variables.add(variablesInstancePlus);
            variables.add(variablesInstanceMinus);
        }
    }

    public void getVariables() {
        for (int i = 0; i < variables.size(); i++) {
            System.out.println(variables.get(i).index + " " + variables.get(i).number + " " + variables.get(i).symbol);
        }
    }


    public int getRowsSize() {
        return rowsSize;
    }

    public void setRowsSize(int rowsSize) {
        this.rowsSize = rowsSize;
    }

    public int getColumnsSize() {
        return columnsSize;
    }

    public void setColumnsSize(int columnsSize) {
        this.columnsSize = columnsSize;
    }

    public void getDBResult() {
        for (int i = 0; i < clauses.size(); i++) {
            int a = clauses.get(i).variable;
            int b = clauses.get(i).symbol;

            for (int j = 0; j < variables.size(); j++) {
                if (a == variables.get(j).number && b == variables.get(j).symbol) {
                    System.out.println(i + 1 + " " + variables.get(j).index);
                }
            }
        }
    }

    public void triangles() {
        for (int k = 0; k < clauses.size(); k = k + 3) {
            System.out.println(k + 1 + " " + (k + 2));
            System.out.println(k + 1 + " " + (k + 3));
            System.out.println((k + 2) + " " + (k + 3));
        }
    }

    public void connectVariables()
    {
        for(int j=0;j< variables.size();j=j+2)
        {
            System.out.println(variables.get(j).index+" "+ variables.get(j+1).index);
        }
    }


}
