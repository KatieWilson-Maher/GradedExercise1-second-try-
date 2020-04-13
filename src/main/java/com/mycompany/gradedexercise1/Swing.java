/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gradedexercise1;

import java.awt.Container;
import javax.swing.*;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author katie
 */
/**
 *
 *
 */
public class Swing extends JFrame {

    private final int FRAME_WIDTH = 512;
    private final int FRAME_HEIGHT = 512;
    private final String FRAME_TITLE = "Swing";
    private final String BG_COLOR = "Background Color";
    private final String FG_COLOR = "Foreground Color";
    private final String SHAPE = "Number of Sides";
    private final String SPINNER = "Axis to Rotate on";
    private final List<Color> bgPalette = new ArrayList<>();
    private final int NUMBER_OF_COLORS = 5;
    private int numberOfSides = 5;
    private final List<Color> fgPalette = new ArrayList<>();
    private final SwingPanel panel;
    private final Random rng = new Random();
    private final List<String> bgColorNames = new ArrayList<>(Arrays.asList("Pastel Pink", "Mint", "Pastel Blue", "Pastel Purple", "Pastel Yellow"));
    private final List<String> fgColorNames = new ArrayList<>(Arrays.asList("Turquoise", "Orange", "Maroon", "Sage", "Raspberry"));
    private final List<String> nameOfNumberOfSides = new ArrayList<>(Arrays.asList("3", "4", "5", "6", "7"));
    private final List<String> spinnerList = new ArrayList<>(Arrays.asList("All Axes", "X-Axis", "Y-Axis", "Z-Axis"));

    /**
     * The Swing class creates the window and the menu as well at its
     *
     */
    public Swing() {

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        this.panel = new SwingPanel();
        pane.add(panel);

        int randomColor = rng.nextInt(5);

        Color pastelPink = new Color(254, 192, 209);
        Color mint = new Color(147, 219, 202);
        Color pastelBlue = new Color(153, 216, 255);
        Color pastelPurple = new Color(211, 186, 255);
        Color pastelYellow = new Color(255, 255, 176);

        Color turquoise = new Color(0, 143, 150);
        Color orange = new Color(255, 170, 0);
        Color maroon = new Color(163, 0, 95);
        Color sage = new Color(98, 158, 144);
        Color raspberry = new Color(224, 0, 97);

        bgPalette.addAll(Arrays.asList(pastelPink, mint, pastelBlue, pastelPurple, pastelYellow));
        fgPalette.addAll(Arrays.asList(turquoise, orange, maroon, sage, raspberry));

        this.panel.setColor(fgPalette.get(randomColor));
        this.panel.setBackground(bgPalette.get(randomColor));

        Hashtable<String, Color> myDict = new Hashtable<String, Color>();

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu bgColorMenu = new JMenu(BG_COLOR);
        menuBar.add(bgColorMenu);
        MenuListener bgListener = new MenuListener(MenuListener.BG_MODE, this.panel, myDict, this.panel.prism);
        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            makeMenuItem(bgColorNames.get(i), bgListener, bgColorMenu);
            myDict.put(bgColorNames.get(i), bgPalette.get(i));
        }
        JMenu fgColorMenu = new JMenu(FG_COLOR);
        menuBar.add(fgColorMenu);
        MenuListener fgListener = new MenuListener(MenuListener.FG_MODE, this.panel, myDict, this.panel.prism);
        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            makeMenuItem(fgColorNames.get(i), fgListener, fgColorMenu);
            myDict.put(fgColorNames.get(i), fgPalette.get(i));
        }

        JMenu shapeMenu = new JMenu(SHAPE);
        menuBar.add(shapeMenu);
        MenuListener shapeListener = new MenuListener(MenuListener.SHAPE, this.panel, myDict, this.panel.prism);
        for (int i = 0; i < numberOfSides; i++) {
            makeMenuItem(nameOfNumberOfSides.get(i), shapeListener, shapeMenu);

        }

//        JMenu spinnerMenu = new JMenu(SPINNER);
//        menuBar.add(spinnerMenu);
//        MenuListenerSpinner spinnerListener0 = new MenuListenerSpinner(0);
//        makeMenuItemSpinner(spinnerList.get(0), spinnerListener0, spinnerMenu);
//
//        MenuListenerSpinner spinnerListener1 = new MenuListenerSpinner(1);
//        makeMenuItemSpinner(spinnerList.get(1), spinnerListener1, spinnerMenu);
//
//        MenuListenerSpinner spinnerListener2 = new MenuListenerSpinner(2);
//        makeMenuItemSpinner(spinnerList.get(2), spinnerListener2, spinnerMenu);
//
//        MenuListenerSpinner spinnerListener3 = new MenuListenerSpinner(3);
//        makeMenuItemSpinner(spinnerList.get(3), spinnerListener3, spinnerMenu);


        JMenu spinnerMenu = new JMenu(SPINNER);
        menuBar.add(spinnerMenu);
        MenuListener spinnerListener0 = new MenuListener(0, this.panel, myDict, this.panel.prism);
        makeMenuItem(spinnerList.get(0), spinnerListener0, spinnerMenu);

        MenuListener spinnerListener1 = new MenuListener(1, this.panel, myDict, this.panel.prism);
        makeMenuItem(spinnerList.get(1), spinnerListener1, spinnerMenu);

        MenuListener spinnerListener2 = new MenuListener(2, this.panel, myDict, this.panel.prism);
        makeMenuItem(spinnerList.get(2), spinnerListener2, spinnerMenu);

        MenuListener spinnerListener3 = new MenuListener(3, this.panel, myDict, this.panel.prism);
        makeMenuItem(spinnerList.get(3), spinnerListener3, spinnerMenu);
        
        
        
        

        this.setVisible(true);
    }

    public final void makeMenuItem(String name, MenuListener listener, JMenu menu) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(listener);
        item.setActionCommand(name);
        menu.add(item);
    } // makeMenuItem()

//    public final void makeMenuItemSpinner(String name, MenuListenerSpinner listener, JMenu menu) {
//        JMenuItem item = new JMenuItem(name);
//        item.addActionListener(listener);
//        item.setActionCommand(name);
//        menu.add(item);
//    }

    public static void main(String[] args) {
        Swing swing = new Swing();

    }

}
