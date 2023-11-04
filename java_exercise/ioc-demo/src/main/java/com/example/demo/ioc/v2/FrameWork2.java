package com.example.demo.ioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:22:02
 */
public class FrameWork2 {
    private Bottom2 bottom2;

    public FrameWork2(Bottom2 bottom2) {
        this.bottom2 = bottom2;
        System.out.println("frameWork2 init...");
    }
}
