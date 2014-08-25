/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Bean.IngredientBean;
import Bean.IngredientRestockLogBean;
import Bean.SpoilLogBean;
import Bean.UsersBean;
import DAOInterface.IngredientInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Keiko Nagano
 */
public class IngredientImplementation implements IngredientInterface {

    @Override
    public void addIngredient(IngredientBean ibean) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into ingredient(ingredient_name, ingredient_weight, ingredient_cost, ingredient_threshold) values (?, ?, ?, ?);";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, ibean.getIngredient_name());
            ps.setDouble(2, ibean.getIngredient_weight());            
            ps.setDouble(3, ibean.getIngredient_cost());
            ps.setInt(4, ibean.getIngredient_threshold());
            ps.executeUpdate(); //add, update, delete
        } catch (SQLException ex) {
             Logger.getLogger(IngredientImplementation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void editIngredient(int id, String name, int threshold) {
       try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "update ingredient set ingredient_name = ?, ingredient_threshold = ? where ingredient_id =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, threshold);
            ps.setInt(3, id);
            ps.executeUpdate(); //add, update, delete
        } catch (SQLException ex) {
            Logger.getLogger(IngredientImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public IngredientBean getIngredient(int ingredientID){
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        IngredientBean ingredientBean = new IngredientBean();
        String query = "SELECT * FROM ingredient WHERE ingredient_id = ? ";
        try{
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,ingredientID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
         ingredientBean.setIngredient_id(rs.getInt(1));
         ingredientBean.setIngredient_name(rs.getString(2));
         ingredientBean.setIngredient_weight(rs.getDouble(3));
         ingredientBean.setIngredient_cost(rs.getDouble(4));
         ingredientBean.setIngredient_threshold(rs.getInt(5));
         return ingredientBean;
        }
        }catch(SQLException exc){
            
        }
        
        return ingredientBean;
    }
    
    @Override
    public void addIngredientRestockLog(IngredientBean ibean, UsersBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSpoilLog(IngredientBean ibean, UsersBean user) {
       
    }

    @Override
    public ArrayList<IngredientBean> getIngredientList() {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        ArrayList<IngredientBean> ingredientBean = new ArrayList<IngredientBean>();
        String query = "SELECT * FROM ingredient";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                IngredientBean temp = new IngredientBean();
                temp.setIngredient_id(resultSet.getInt("ingredient_id"));
                temp.setIngredient_name(resultSet.getString("ingredient_name"));
                temp.setIngredient_weight(resultSet.getDouble("ingredient_weight"));
                temp.setIngredient_cost(resultSet.getDouble("ingredient_cost"));
                temp.setIngredient_threshold(resultSet.getInt("ingredient_threshold"));
                
                ingredientBean.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredientBean;
    }

    @Override
    public ArrayList<IngredientRestockLogBean> getIngredientRestockLogList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SpoilLogBean> getSpoilLogList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSpoiled(IngredientBean ibean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restockIngredient(IngredientBean ibean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
