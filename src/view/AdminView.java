package view;

import business.BrandManager;
import entity.Brand;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private BrandManager brandManager;
    private JPopupMenu brandMenu;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitialize(1000, 500);
        this.user = user;

        if (this.user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername() + " !");

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Brand> brandList = this.brandManager.getAllBrands();
        this.tmdl_brand.setColumnIdentifiers(col_brand);
        for (Brand brand : brandList) {
            Object[] obj = {brand.getId(), brand.getName()};
            this.tmdl_brand.addRow(obj);
        }

        this.tbl_brand.setModel(this.tmdl_brand);
        this.tbl_brand.getTableHeader().setReorderingAllowed(false);
        this.tbl_brand.setEnabled(false);
        this.tbl_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_brand.rowAtPoint(e.getPoint());
                tbl_brand.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("New").addActionListener(e -> {
            System.out.println("Clicked new");
        } );
        this.brandMenu.add("Update");
        this.brandMenu.add("Delete");

        this.tbl_brand.setComponentPopupMenu(this.brandMenu);
    }

}
