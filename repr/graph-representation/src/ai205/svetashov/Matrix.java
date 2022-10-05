package ai205.svetashov;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Matrix {

    private int rowsSize = 0; // 538
    private int columnsSize = 0; // 125
    private int[][] twoDimensionalArray; // our matrix

    public Matrix() {
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
        // find the file with the developer date
        try {
            File devFile = new File("src/ai205/svetashov/input/input-graph-representation.txt");
            Scanner devScanner = new Scanner(devFile);

            if (devScanner.hasNext()) {
                String nextLine = devScanner.nextLine();
                String[] devData = nextLine.split(" ");
                setRowsSize(Integer.valueOf(Integer.parseInt(devData[3])));//535//91
                setColumnsSize(Integer.valueOf(Integer.parseInt(devData[2])));//125//20
                // TODO:  getRowsSize()*3
                //return;
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

                    // TODO: кол-во столбцов в данных

                    /*temp1 = Math.abs(Integer.valueOf(Integer.parseInt(devData[0])));
                    temp2 = Math.abs(Integer.valueOf(Integer.parseInt(devData[1])));
                    temp3 = Math.abs(Integer.valueOf(Integer.parseInt(devData[2])));*/

/*                    for(int k=0; k<devData.length;k++)
                    {
                        temp = Math.abs(Integer.valueOf(Integer.parseInt(devData[k])));
                        System.out.println(counter +" "+ temp);
                    }*/

                    if(counter==1)
                    {
                        System.out.println("p" + " tw " + getRowsSize() + " " + getRowsSize() * (devData.length-1));
                    }

                    int result=1;
                    for (int k = 0; result!= 0; k++) {
                        result=Math.abs(Integer.valueOf(Integer.parseInt(devData[k])));
                        if (result!=0)
                        {
                            temp = Math.abs(Integer.valueOf(Integer.parseInt(devData[k])));
                            System.out.println(counter + " " + temp);
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
}
