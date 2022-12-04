package com.isa.lotto;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LottoApp {



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Drawing drawing = new Drawing();

        drawing.getData();
        drawing.getDraw();
    }



}

