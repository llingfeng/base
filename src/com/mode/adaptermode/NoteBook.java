package com.mode.adaptermode;

/**
 * Created by admin on 2016/12/10.
 */
public class NoteBook {
    private ThreePlug threePlug;

    public NoteBook(ThreePlug threePlug) {
        this.threePlug = threePlug;
    }

    public void charge(){
        threePlug.charge();
    }
}
