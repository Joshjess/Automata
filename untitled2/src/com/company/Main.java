package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            new GumBallMachine();
    }

    public static class GumBallMachine {
        private int Amount_GumBalls = 0;

        public GumBallMachine() {
            new SoldOut();
        }



        class SoldOut {


            public SoldOut() {
                fill();
                new NoQuarter();
            }

            public void fill(){
                Amount_GumBalls = 5;
                System.out.print("Gumballs filled \n");
            }



        }

        class NoQuarter {

            public NoQuarter(){
                InsertQuarter();
            }

            public HasQuarter InsertQuarter(){
                System.out.print("press c to insert coin \n");
                Scanner scan = new Scanner(System.in);
                String coin = scan.next();
                return new HasQuarter(coin);
            }



        }


        class HasQuarter{

            public HasQuarter(String coin){
                if (coin.equals("c")){
                    turnCrank();
                }
                else{
                    ejectQuarter();
                }
            }

            public GumballSold turnCrank(){
                System.out.print("Turning Crank \n");
                return new GumballSold();
            }

            public NoQuarter ejectQuarter(){
                System.out.print("wrong coin \n");
                return new NoQuarter();
            }

        }


        class GumballSold{

            public GumballSold(){
                    dispense();
            }

            public void dispense(){
                System.out.print("Dispensing Gumball \n");
                Amount_GumBalls--;
                System.out.print("Amount gumballs "+ Amount_GumBalls + "\n");
                if (Amount_GumBalls > 0){
                    new NoQuarter();
                }

                else{
                    new SoldOut();
                }
            }


        }




    }

}
