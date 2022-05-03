package com.example.constrastoque.component.model;

import com.example.constrastoque.R;

public enum ImagesEnum {

    IMAGE_ONE(R.drawable.relogio_icon_1),

    DEFAULT(R.drawable.relogio_icon_1);


    private int resImage;

    public int getResImage() {
        return resImage;
    }

    public static ImagesEnum validImageEnum(String image) {
        ImagesEnum imagesEnum;
        try {
            imagesEnum = ImagesEnum.valueOf(image.toUpperCase());
        } catch (Exception e) {
            imagesEnum = DEFAULT;
        }
        return imagesEnum;
    }

    ImagesEnum(int ic) {
        this.resImage = ic;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
