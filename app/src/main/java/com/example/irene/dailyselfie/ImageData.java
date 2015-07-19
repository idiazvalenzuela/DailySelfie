package com.example.irene.dailyselfie;

import android.graphics.Bitmap;

/**
 * Created by irene on 17/07/15.
 */
public class ImageData {

    private Bitmap selfie;
    private String name;
    private String path;

    public ImageData(Bitmap selfie, String name, String path) {
        this.selfie = selfie;
        this.name = name;
        this.path = path;
    }

    public ImageData(Bitmap selfie, String name) {
        this.selfie = selfie;
        this.name = name;
        this.path = path;
    }

    public ImageData(String name, String path) {
        this.selfie = null;
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
