package com.example.irene.dailyselfie;

import android.graphics.Bitmap;

/**
 * Created by irene on 17/07/15.
 */
public class ImageData {

    private Bitmap selfie;
    private String name;

    public ImageData(Bitmap selfie, String name) {
        this.selfie = selfie;
        this.name = name;
    }

    public Bitmap getSelfie() {
        return selfie;
    }

    public void setSelfie(Bitmap selfie) {
        this.selfie = selfie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
