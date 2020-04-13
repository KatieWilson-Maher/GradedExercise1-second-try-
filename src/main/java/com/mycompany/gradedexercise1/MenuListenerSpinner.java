//package com.mycompany.gradedexercise1;
//
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//
//public class MenuListenerSpinner implements ActionListener {
//
//    public static final int SPINNER_MODE = 0;
//    public static final int SPINNER_MODE_X = 1;
//    public static final int SPINNER_MODE_Y = 2;
//    public static final int SPINNER_MODE_Z = 3;
//    private final int mode;
//
//    public MenuListenerSpinner(int mode) {
//        
//        this.mode = mode;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent event) {
//        
//        var actionCommand = event.getActionCommand();
//
//        if (this.mode == MenuListenerSpinner.SPINNER_MODE) {
//            Matrix a = new Matrix();
//            a.rotateX(Math.PI / 400);
//            Matrix b = new Matrix();
//            b.rotateY(Math.PI / 400);
//            Matrix c = new Matrix();
//            c.rotationZ(Math.PI / 400);
//            Matrix r = a.multiply(b).multiply(c);
//            SwingPanel.spinner = r;
//            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
//        } else if (this.mode == MenuListenerSpinner.SPINNER_MODE_X) {
//            Matrix rx = new Matrix();
//            rx.rotateX(Math.PI / 400);
//            SwingPanel.spinner = rx;
//            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
//        } else if (this.mode == MenuListenerSpinner.SPINNER_MODE_Y) {
//            Matrix ry = new Matrix();
//            ry.rotateY(Math.PI / 400);
//            SwingPanel.spinner = ry;
//            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
//        } else if (this.mode == MenuListenerSpinner.SPINNER_MODE_Z) {
//            Matrix rz = new Matrix();
//            rz.rotationZ(Math.PI / 400);
//            SwingPanel.spinner = rz;
//            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
//        }
//    }
//}
