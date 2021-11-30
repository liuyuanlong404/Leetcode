package com.rose.util;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created on 2021/10/18 13:09
 *
 * @author Rose
 */
public class RobotUtil {

    public static void main(String[] args) throws AWTException {
        barrage();
    }

    /**
     * 鼠标左键点击
     * @param number 点击次数
     * @throws AWTException 异常
     */
    public static void praise(int number) throws AWTException {
        Robot robot = new Robot();
        robot.delay(5000);
        for (int i = 0; i < number; i++) {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(20);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }

    /**
     * ctrl + v 连点
     *
     * @throws AWTException
     */
    public static void barrage() throws AWTException {
        Robot robot = new Robot();
        robot.delay(5000);
        while (true){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(10000);
        }
    }

}
