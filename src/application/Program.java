package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for (Seller sellerCaptured : list) {
            System.out.println("Seller: " + sellerCaptured);
        }
        System.out.println("\n=== TEST 3: seller findAll ===");
        List<Seller> listAll = sellerDao.findAll();
        for (Seller sellerCaptured : listAll) {
            System.out.println("Seller: " + sellerCaptured);
        }
       /* System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.00,
                new Department(2,null ));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+ newSeller.getId()); */
        System.out.println("\n=== TEST 5: seller update ===");
         seller = sellerDao.findById(1);
         seller.setName("Marta Wayne");
         seller.setEmail("martaWayne@gmail.com");
         sellerDao.update(seller);
         System.out.println("Update completed");
        System.out.println("\n=== TEST 6: seller update ===");
        int id = 8;
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

    }
}
