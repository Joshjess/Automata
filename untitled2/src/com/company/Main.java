package com.company;

public class Main {

    public static void main(String[] args) {
            EvenNumber even  = new GumBallMachine("aba");
    }

    public class GumBallMachine {
        SoldOut soldOut;
        NoQuarter noQuarter;
        HasQuarter hasQuarter;
        GumballSold gumballSold;

        public GumBallMachine(String s) {
            /* state_s.setStates(state_q);
            state_q.setStates(state_s);
            state_s.setWord(s); */

            soldOut =  new Soldout();
            noQuarter = new NoQuarter();
            hasQuarter = new HasQuarter();
            gumballSold = new Gumballsold();

        }

        public void setAccept(boolean accept) {
            if (accept == true) System.out.println("Accepted");
            if (accept == false) System.out.println("Not accepted");
            System.exit(1);
        }
    }

    public class SoldOut {
        NoQuarter noQuarter;
        EvenNumber evenNumber;
        State_Q state_q;
        String restWord;

        public State_S(EvenNumber evenNumber){
            this.evenNumber =evenNumber;
        }

        public void setStates(State_Q state_q){
            this.state_q = state_q;
        }

        public void gettingA() {
            state_q.setWord(restWord);
        }

        public void gettingB(){
            this.setWord(restWord);
        }

        public void setWord(String s){
        if(s.equals(""))evenNumber.setAccept(true);
        String character = s.substring(0, 1);
        restWord =s.substring(1,s.length());
        if(character.equals("a")) gettingA();
        if(character.equals("b")) gettingB();
        }
    }

}
