package main;

import java.util.Objects;
import static java.lang.Math.max;

public class TicTacToe {
    private final String[][] field;
    int size;
    int x;
    int y;

    public TicTacToe(int size) {       //создаёт пустое поле заданного размера
        this.size = size;
        field = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                field[i][j] = "-";
        }
    }

    public void addTic(int x, int y) {
        this.x = x;
        this.y = y;
        if (Objects.equals(field[x][y], "-")) field[x][y] = "x";
    }

    public void addTac(int x, int y) {
        this.x = x;
        this.y = y;
        if (Objects.equals(field[x][y], "-")) field[x][y] = "o";
    }

    public void removeCell(int x, int y) {
        this.x = x;
        this.y = y;
        field[x][y] = "-";
    }

    public String getState(int x, int y) {   //получение статуса клетки
        this.x = x;
        this.y = y;
        return field[x][y];
    }

    public int longestSequenceTic() {
        int maximum = 0;

        //по вертикали
        for (int j = 0; j < size; j++) {
            int i = 0;
            int count = 0;
            while (i < size) {
                if (Objects.equals(field[i][j], "x")) {
                    count++;
                    maximum = max(maximum, count);
                }
                i++;
            }
        }

        //по горизонтали
        for (int i = 0; i < size; i++) {
            int j = 0;
            int count = 0;
            while (j < size) {
                if (Objects.equals(field[i][j], "x")) {
                    count++;
                    maximum = max(maximum, count);
                }
                j++;
            }
        }

        //по диагонали слева направо
        int i = 0, j = 0;
        int count = 0;
        while(i < size) {
            if (Objects.equals(field[i][j], "x")) {
                count++;
                maximum = max(maximum, count);
            }
            i++;
            j++;
        }

        //по диагонали справа налево
        i = 0;
        j = size - 1;
        count = 0;
        while (i < size) {
            if (Objects.equals(field[i][j], "x")) {
                count++;
                maximum = max(maximum, count);
            }
            i++;
            j--;
        }
        return maximum;
    }

    public int longestSequenceTac() {
        int maximum = 0;

        for (int j = 0; j < size; j++) {
            int i = 0;
            int count = 0;
            while (i < size) {
                if (Objects.equals(field[i][j], "o")) {
                    count++;
                    maximum = max(maximum, count);
                }
                i++;
            }
        }

        for (int i = 0; i < size; i++) {
            int j = 0;
            int count = 0;
            while (j < size) {
                if (Objects.equals(field[i][j], "o")) {
                    count++;
                    maximum = max(maximum, count);
                }
                j++;
            }
        }

        int i = 0, j = 0;
        int count = 0;
        while(i < size) {
            if (Objects.equals(field[i][j], "o")) {
                count++;
                maximum = max(maximum, count);
            }
            i++;
            j++;
        }

        i = 0;
        j = size - 1;
        count = 0;
        while (i < size) {
            if (Objects.equals(field[i][j], "o")) {
                count++;
                maximum = max(maximum, count);
            }
            i++;
            j--;
        }
        return maximum;
    }
}
