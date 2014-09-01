/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;
import Bean.DishBean;
import Bean.DishSaleLogBean;
import Bean.IngredientBean;
import Bean.UsersBean;
import java.util.ArrayList;

/**
 *
 * @author Keiko Nagano
 */
public interface DishInterface {
    //methods for sql interaction goes here (AddDish, DeleteDish, etc)
    public void addDish(DishBean dbean);

    public void editDish(DishBean dbean);
    
    public boolean checkDish(String dishName);
    
    public void addDishSaleLog(DishBean dbean);
    
    public ArrayList<DishSaleLogBean> getDishSaleLogList();
    
    public ArrayList<DishBean> getDishList();
    
    public boolean sellDish(DishBean dbean, UsersBean userAccount);
    
    public DishBean getDish(int dishID);

}
