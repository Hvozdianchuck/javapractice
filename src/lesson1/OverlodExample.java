package lesson1;

public class OverlodExample {
    public static void main(String[] args) {
        OverlodExample overlodExample=new OverlodExample();
        short a=3;
        byte a1=3;
        System.out.println(overlodExample.method(a));
        // буде відбуватися розширення Vaidinind з 2 байт до 4 байт і викличеться метод з int
        System.out.println(overlodExample.method(a1));
        //вибере метод з byte якщо би не було byte то шукало би найблище цілочислений тип int обертки будуть шукати в останню чергу short нікили не піде до byte тому що byte менший за short
        System.out.println(overlodExample.method((byte)a));
        //тепер  byte викличе
        // якщо не буде цілочисельні то вибере обертку Short якщо ми говоримо про short
        // якщо  забрати Short то викличеться Object Integer не викличеться хіба можна зробити переведення до int тоді вибере Integer
        System.out.println(overlodExample.method((int) a));
        // то ж спочатку примітиви потім обгортки потім Object потім масив типу (у цьому випадку short) але воно не запрацює бо компілятор не буде знати який масив вибрати short чи Object
        // цілочислені типи ми можем перетворити в не цілочисленні
        //package com.one one і com це дві різні папки
        //com.one.Car car; import com.one.Car; or import com.one.*; пакети йдуть перед класами після пакетів ми можемо писати імпорти default class не можна в іших пвкетвх використати його буде видно тільки на рівні цього пакету
    }
    int method(int a){
        return a;
    }
  double method(double a){
        return a;
  }
    Integer method(Integer a){
        return a;
    }
    long method(long a){
        return a;
    }
    byte method(byte a){
        return a;
    }
    Byte method(Byte a){
        return a;
    }
    void method(byte... a){
        System.out.println(a);
    }
    void method(Byte... a){
        System.out.println(a);
    }
    void method(Object... a){
        System.out.println(a);
    }
    void method(Object a){
        System.out.println(a);
    }
}
