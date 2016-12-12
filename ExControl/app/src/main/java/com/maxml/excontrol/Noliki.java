package com.maxml.excontrol;

import java.util.Arrays;

/**
 * Created by Maxml on 25.11.2016.
 */
public class Noliki {

    public enum Lessons {
        FIRST, SECOND
    }

    private int[][] krestiki;

    private Lessons lesson;

    public Noliki() {
        this.krestiki = new int[3][3];
    }

    public void setKrestiki(int krestiki, int i, int j) {
        this.krestiki[i][j] = krestiki;
    }

    public int[][] getKrestiki() {
        return krestiki;
    }

    public Lessons getLesson() {
        return lesson;
    }

    public void setLesson(Lessons lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Noliki noliki = (Noliki) o;

        return Arrays.deepEquals(krestiki, noliki.krestiki);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(krestiki);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < krestiki.length; i++) {
            for (int j = 0; j < krestiki[i].length; j++) {
                result += krestiki[i][j];
            }
        }

        return result;
    }
}
