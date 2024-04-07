package dao;

import core.Db;
import entity.Brand;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {
    private final Connection con;

    public BrandDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Brand> getAllBrands() {
        ArrayList<Brand> brandList = new ArrayList<>();
        String query = "SELECT * from public.brand";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                brandList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brandList;
    }

    public Brand match(ResultSet rs) throws SQLException {
        Brand brand = new Brand();
        brand.setId(rs.getInt("brand_id"));
        brand.setName(rs.getString("brand_name"));

        return brand;
    }
}


