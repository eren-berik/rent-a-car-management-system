package business;

import core.Helper;
import dao.BrandDao;
import entity.Brand;

import java.util.ArrayList;

public class BrandManager {
    private final BrandDao brandDao;

    public BrandManager() {
        this.brandDao = new BrandDao();
    }

    public ArrayList<Object[]> getForTable(int size) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();

        for (Brand brand : this.getAllBrands()) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getId();
            rowObject[i++] = brand.getName();
            brandRowList.add(rowObject);
        }

        return brandRowList;
    }

    public ArrayList<Brand> getAllBrands() {
        return this.brandDao.getAllBrands();
    }

    public boolean save (Brand brand) {
        if (brand.getId() != 0) {
            Helper.showMessage("error");
        }
        return this.brandDao.save(brand);
    }

    public boolean update (Brand brand) {
        if (this.getById(brand.getId()) == null) {
            Helper.showMessage("notFound");
        }

        return this.brandDao.update(brand);
    }

    public boolean delete (int id) {
        if (this.getById(id) == null) {
            Helper.showMessage("notFound");
        }

        return this.brandDao.delete(id);
    }

    public Brand getById (int id) {
        return this.brandDao.getById(id);
    }
}
