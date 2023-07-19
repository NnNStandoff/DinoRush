package com.example.dinozavr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class dino {

    private int x = 0, y = 0; // смещение самолёта по направлениям осей координат
    private int width, height; // ширина и высота для растрового изображения
    private int wingCounter = 0;
    private Bitmap dino1, dino2 , dino;
    private Bitmap dinoplene;
    private boolean isGoingUp = false;

    // конструктор (размеры по оси X и Y, ресурс)
    public  dino(int screenX, int screenY, Resources resources) {
        // считывание изображений летящих самолётов из ресурсов
        dino1 = BitmapFactory.decodeResource(resources, R.drawable.dino1);
        dinoplene = BitmapFactory.decodeResource(resources, R.drawable.dinoplane);
        dino2 = BitmapFactory.decodeResource(resources, R.drawable.dino2);
        dino = BitmapFactory.decodeResource(resources, R.drawable.dino);


        width = dino.getWidth() / 8;
        height = dino.getHeight() / 8;


        width = (int)(width * 1920f / screenX);
        height = (int)(height * 1080f / screenY);

        // изменение размера изображения самолёта, где width и height соответственно ширина и высота
        dino1 = Bitmap.createScaledBitmap(dino1, width, height, false);
        dino2 = Bitmap.createScaledBitmap(dino2, width, height, false);
        dino = Bitmap.createScaledBitmap(dino, width, height, false);
        dinoplene = Bitmap.createScaledBitmap(dinoplene, width, height, false);


        // начальное местоположение полёта
        y = 900; // посередине оси Y
        x = screenX / 21; // практически вначале оси X
    }
    public Rect getCollisionShape() {
        // вывод квадрата с координатами краёв астероида
        return new Rect(x, y, x + width, y + height);
    }
    // метод задания очерёдности переключения изображений полёта
    public Bitmap getDino() {

        if (wingCounter == 0) {
            wingCounter = 1;
            return dino;
        }
        if (wingCounter == 1) {
            wingCounter = 2;
            return dino1;
        }else if(wingCounter > 1 ) {
            wingCounter = 0;
            return dino2;
        }

        return null;
    }

    // геттеры и сеттеры
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
    public Bitmap getPlaneShotDown() {
        return dinoplene;
    }

    public void setPlaneShotDown(Bitmap planeShotDown) {
        this.dinoplene = planeShotDown;
    }
}

