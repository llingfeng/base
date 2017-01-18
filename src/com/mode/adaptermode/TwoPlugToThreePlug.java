package com.mode.adaptermode;

/**
 * Created by admin on 2016/12/10.
 */
//二孔转三孔
public class TwoPlugToThreePlug extends ThreePlug {
    private TwoPlug twoPlug;

    public TwoPlugToThreePlug(TwoPlug twoPlug) {
        this.twoPlug = twoPlug;
    }

    @Override
    public void charge() {
        twoPlug.charge();
    }
}
