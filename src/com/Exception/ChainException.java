package com.Exception;

public class ChainException {

    public static void main(String args[]){
        ChainException chainException = new ChainException();
        chainException.test2();
    }

    public void test1() throws Drunk {
        throw new Drunk("开车别喝酒");
    }

    public void test2(){
        try {
            test1();
        } catch (Drunk drunk) {
            RuntimeException runtimeException = new RuntimeException(drunk);
            throw runtimeException;
        }
    }
}
