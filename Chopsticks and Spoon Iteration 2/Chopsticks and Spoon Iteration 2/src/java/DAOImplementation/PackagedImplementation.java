/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Bean.DamageLogBean;
import Bean.PackagedBean;
import Bean.PackagedRestockLogBean;
import Bean.UsersBean;
import DAOInterface.PackagedInterface;
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
public class PackagedImplementation implements PackagedInterface {

    @Override
    public void addDamageLog(PackagedBean pbean, UsersBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPackaged(PackagedBean pbean) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into packaged(packaged_name, packaged_quantity, packaged_cost, packaged_price, packaged_threshold) values (?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, pbean.getPackaged_name());
            ps.setInt(2, pbean.getPackaged_quantity());            
            ps.setDouble(3, pbean.getPackaged_cost());
            ps.setDouble(4, pbean.getPackaged_price());
            ps.setInt(5, pbean.getPackaged_threshold());
            ps.executeUpdate(); //add, update, delete
        } catch (SQLException ex) {
             Logger.getLogger(IngredientImplementation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void editPackaged(int id, String name, double price, int threshold) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "update packaged set packaged_name = ?, packaged_price = ?, packaged_threshold = ? where packaged_id =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, threshold);
            ps.setInt(4, id);
            ps.executeUpdate(); //add, update, delete
        } catch (SQLException ex) {
            Logger.getLogger(PackagedImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public PackagedBean getPackaged(int packagedID) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        PackagedBean packagedBean = new PackagedBean();
        String query = "SELECT * FROM packaged WHERE packaged_id = ? ";
        try{
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, packagedID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
         packagedBean.setPackaged_id(rs.getInt(1));
         packagedBean.setPackaged_name(rs.getString(2));
         packagedBean.setPackaged_quantity(rs.getInt(3));
         packagedBean.setPackaged_cost(rs.getDouble(4));
         packagedBean.setPackaged_price(rs.getDouble(5));
         packagedBean.setPackaged_threshold(rs.getInt(6));
         return packagedBean;
        }
        }catch(SQLException exc){
            
        }
        
        return packagedBean;
    }
    
    @Override
    public void addPackagedRestockLog(PackagedBean pbean, UsersBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DamageLogBean> getDamageLogList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PackagedBean> getPackagedList() {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        ArrayList<PackagedBean> packagedBean = new ArrayList<PackagedBean>();
        String query = "SELECT * FROM packaged";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PackagedBean temp = new PackagedBean();
                temp.setPackaged_id(resultSet.getInt("packaged_id"));
                temp.setPackaged_name(resultSet.getString("packaged_name"));
                temp.setPackaged_quantity(resultSet.getInt("packaged_quantity"));
                temp.setPackaged_cost(resultSet.getDouble("packaged_cost"));
                temp.setPackaged_price(resultSet.getDouble("packaged_price"));
                temp.setPackaged_threshold(resultSet.getInt("packaged_threshold"));
               
                packagedBean.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return packagedBean;
    }

    @Override
    public ArrayList<PackagedRestockLogBean> getPackagedRestockLogList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDamaged(PackagedBean pbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restockPackaged(PackagedBean pbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
