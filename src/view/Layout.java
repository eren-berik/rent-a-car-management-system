package view;

import core.Helper;

import javax.swing.*;

public class Layout extends JFrame {
    public void guiInitialize (int width, int height) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Rent a Car");
        this.setSize(width,height);
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        this.setVisible(true);
    }
}
