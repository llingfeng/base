package com.mode.adaptermode;

/**
 * Created by admin on 2016/12/10.
 */
public class Main {

    public static void main(String[] args){
        TwoPlug twoPlug = new TwoPlug();
        ThreePlug threePlug = new TwoPlugToThreePlug(twoPlug);
        NoteBook noteBook = new NoteBook(threePlug);
        noteBook.charge();
    }
}
