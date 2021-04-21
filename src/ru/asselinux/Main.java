package ru.asselinux;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
    }
    public static void ex1(){
        System.out.println("Ex1:____________________");
//
        int array1[] = {1, 2, 3,4,5};
        int array2[] = {1, 2, 3,4,4};
        boolean sorted = true;
        for(int i = 1; i < array1.length; i++) {
            if(array1[i-1] >= array1[i]){
                sorted = false;
                break;
            }
        }
        System.out.println("Sorted array1: " + sorted);

        for(int i = 1; i < array2.length; i++) {
            if(array2[i-1] >= array2[i]){
                sorted = false;
                break;
            }
        }
        System.out.println("Sorted array2: " + sorted+", Please, try again");

    }
    public static void ex2(){
        System.out.println("Ex2:____________________");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Array length: ");
        int length =in.nextInt();
        int array[] = new int[length];
        System.out.println("Input Numbers of array: ");
        for(int i = 0; i < length; i++) {
            array[i] =in.nextInt();
        }
        System.out.println("Array 1:"+Arrays.toString(array));
    }
    public static void ex3(){
        System.out.println("Ex3:____________________");
        int array1[] = {5, 6, 7,2};
        int length=array1.length;
        int array2[] = new int[length];
        for(int i = 0; i < array2.length; i++) {
            array2[i]=array1[i];
        }

        array2[0]=array1[length-1];
        array2[length-1]=array1[0];
        System.out.println("Array 1:"+Arrays.toString(array1));
        System.out.println("Array 2:"+Arrays.toString(array2));

    }
    public static void ex4(){
        System.out.println("Ex4:____________________");
        int array1[] = {1, 2, 3, 1, 2, 4};
        int a;
        boolean sorted = true;
        while (sorted){
            sorted = false;
            for(int i = 0; i < array1.length-1; i++) {
                if(array1[i]>array1[i+1]){
                    sorted=true;
                    a=array1[i];
                    array1[i]=array1[i+1];
                    array1[i+1]=a;
                }
            }
        }

        //System.out.println("Array sorted :"+Arrays.toString(array1));
        int b = array1[array1.length-1];
        boolean k=false;
        if(array1[0]!=array1[1]){
            b = array1[1];
            k=true;
        }
        for(int i = 1; i < array1.length-1; i++) {

            if((array1[i]!=array1[i-1])&&(array1[i]!=array1[i+1])) {
                b = array1[i];
                k=true;
            }

        }
        if(k==false){
            System.out.println("Нет уникальных элементов");
        }
        else
            System.out.println(b);
    }
    public static void ex5(){
        System.out.println("Ex5:____________________");
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int num =in.nextInt();
        int Fn = 0;
        int F0 = 0;
        int F1=1;

        if(num==0){
            Fn=0;
        }
        if(num==1){
            Fn=1;
        }
        if(num>1){
            for(int i=2;i<=num;i++){
                Fn=F0+F1;
                F0=F1;
                F1=Fn;
            }
        }
        System.out.println(Fn);
    }
    public static void ex6(){
        System.out.println("Ex6:____________________");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Array length: ");
        int length =in.nextInt();
        int array[] = new int[length];
        Random random = new Random(length);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        System.out.println("Array :"+Arrays.toString(array));
        if (length<2){
            System.out.println("Array1 :"+Arrays.toString(array));
        }
        mergesort(array,0,array.length-1);
        System.out.println("Array sorted :"+Arrays.toString(array));
    }

    private static void mergesort(int[] array, int left, int right) {
        if (right<=left){
            return;
        }
        int mid = (left+right)/2;
        mergesort(array, left, mid);
        mergesort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];

        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {

            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
    public static void ex7(){
        System.out.println("Ex7:____________________");
        int array1[] = {1, 2, 3,2,  2, 4,5,6,3,4,4,6,6,6,6,6,6,6,6,1};
        System.out.println("Array :"+Arrays.toString(array1));
        int a;
        boolean sorted = true;
        while (sorted){
            sorted = false;
            for(int i = 0; i < array1.length-1; i++) {
                if(array1[i]>array1[i+1]){
                    sorted=true;
                    a=array1[i];
                    array1[i]=array1[i+1];
                    array1[i+1]=a;
                }
            }
        }
        //System.out.println("Array sorted :"+Arrays.toString(array1));
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int k =in.nextInt();
        int b=array1[0];
        boolean l=false;
        int numb=1;
        int d;
        int numd=0;
        for(int i = 1; i < array1.length; i++) {

            if(array1[i]==array1[i-1]) {
                if(array1[i-1]!=b) {
                    numb = 1;
                }
                b = array1[i];
                numb++;

                if (numb==k){
                    l=true;
                    break;
                }
            }

        }
        if(l==false){
            System.out.println("Нет элементов повторяющихся K раз");
        }
        else
        System.out.println(b);
    }

}
