package org.arkochatterjee.facde;

/**
 * Created by root on 10/3/18.
 */

public class MotionDetect {

    private String text;
    private String name;

    public MotionDetect() {
    }

    public MotionDetect(String text, String name) {
        this.text = text;
        this.name = name;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
