package com.example.dinozavr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class cactus {
    private int x = 0, y = 0; // смещение самолёта по направлениям осей координат
    private int width, height; // ширина и высота для растрового изображения
    private int wingCounter = 0;
    private Bitmap cactus;
    private boolean isGoingUp = false;

    // конструктор (размеры по оси X и Y, ресурс)
    public  cactus(int screenX, int screenY, Resources resources) {

        cactus = BitmapFactory.decodeResource(resources, R.drawable.cactus);


        width = cactus.getWidth() / 27;
        height = cactus.getHeight() / 27;


        width = (int)(width * 1920f / screenX);
        height = (int)(height * 1080f / screenY);

        // изменение размера изображения самолёта, где width и height соответственно ширина и высота
       cactus = Bitmap.createScaledBitmap(cactus, width, height, false);

        // начальное местоположение полёта
        y =  900; // посередине оси Y
        x = 3000; // практически вначале оси X
    }
    public Rect getCollisionShape() {
        // вывод квадрата с координатами краёв астероида
        return new Rect(x, y, x + width, y + height);
    }

    public Bitmap getCactus() {

        if (wingCounter == 0) {
            wingCounter++;
            return cactus;
        } else if(wingCounter > 0) {
            wingCounter--;
            return cactus;
        }

        return null;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isGoingUp() {
        return isGoingUp;
    }

    public void setGoingUp(boolean goingUp) {
        isGoingUp = goingUp;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
