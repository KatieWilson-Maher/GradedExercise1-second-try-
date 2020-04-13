/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gradedexercise1;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;

import java.util.ArrayList;

/**
 *
 * @author katie
 */
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.List;

public class SwingPanel extends JPanel implements ActionListener {
// a SwingPanel is a kind of JPanel
// and
// a SwingPanel is a kind of ActionListener

    private Shape shape;
    private Color color = Color.red;
    public static Prism prism;
    public static Matrix spinner;
//    public static Matrix spinnerX;
//    public static Matrix spinnerY;
//    public static Matrix spinnerZ;
    private final Vector illumination;
//    public static Matrix chosenSpinner;
//    public static int axisIndex;

    public SwingPanel() {

        Timer timer = new Timer(30, this);
        timer.start();

        this.prism = new Prism(0.8, 0.8, 8);

        Matrix a = new Matrix();
        a.rotateX(Math.PI / 400);
        Matrix b = new Matrix();
        b.rotateY(Math.PI / 400);
        Matrix c = new Matrix();
        c.rotationZ(Math.PI / 400);
        this.spinner = a.multiply(b).multiply(c);

//        Matrix aX = new Matrix();
//        aX.rotateX(Math.PI / 400);
//        this.spinnerX = aX;
//        System.out.println("spinnerXInSwingPanel: " + spinnerX);
//
//        Matrix aY = new Matrix();
//        aY.rotateY(Math.PI / 400);
//        this.spinnerY = aY;
//
//        Matrix aZ = new Matrix();
//        aZ.rotationZ(Math.PI / 400);
//        this.spinnerZ = aZ;

        //axisIndex = 0;
        this.illumination = (new Vector(1.0, 2.0, 3.0)).normalize();

    } // SwingPanel()

    public Color getColor() {
        return this.color;
    } // getColor()

    public void setColor(Color c) {
        this.color = c;
    } // setColor( Color )

//    public void setAxis(int choice) {
//        if (choice == 0) {
//            this.chosenSpinner = this.spinner;
//        }
//        if (choice == 1) {
//            this.chosenSpinner = this.spinnerX;
//        }
//        if (choice == 2) {
//            this.chosenSpinner = this.spinnerY;
//        }
//        if (choice == 3) {
//            this.chosenSpinner = this.spinnerZ;
//        }
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);

        AffineTransform translation = new AffineTransform();
        double cx = 1.0;
        double cy = 1.0;
        translation.setToTranslation(cx, cy);

        transform.concatenate(scaling);
        transform.concatenate(translation);

        ArrayList<Triangles> faces = this.prism.getFaces();
        for (Triangles p : faces) {
            Shape s = transform.createTransformedShape(p.getShape());

            Vector normal = p.getNormal();
            if (normal.get(2) > 0) {
                double brightness = normal.dot(illumination);

                Color c = this.getColor();

                double ambient = 0.2;
                int red;
                int green;
                int blue;
                if (brightness > 0) {
                    red = (int) (brightness * c.getRed());
                    green = (int) (brightness * c.getGreen());
                    blue = (int) (brightness * c.getBlue());
                } // if
                else {
                    red = (int) (ambient * c.getRed());
                    green = (int) (ambient * c.getGreen());
                    blue = (int) (ambient * c.getBlue());
                } // else
                Color shade = new Color(red, green, blue);

                g2D.setColor(shade);
                g2D.fill(s);
            } // if
        } // for

    } // paintComponent( Graphics )

    @Override
    public void actionPerformed(ActionEvent event) {

        //this.prism.setAxis(this.axisIndex);
        this.prism.transform(spinner);

        this.repaint();
    } // actionPerformed( ActionEvent )

} // SwingPanel

