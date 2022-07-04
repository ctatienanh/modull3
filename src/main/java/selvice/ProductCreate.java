package selvice;

import dao.Userdao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCreate {
    static Userdao userdao = new Userdao();
    public static List<Product> productList =  userdao.getAllproduct();
    public void   create (Product product){
        productList.add(product);
        userdao.save(product);
    }
    public int checkindex(int id){
        for (int i=0 ; i < productList.size(); i++){
            if (id == productList.get(i).getId()){
                return i;
            }
        }
        return -1;
    }


    public void Edit(int id, Product product){
        productList.set(checkindex(id),product);
        userdao.updateUser(product);
    }
}
