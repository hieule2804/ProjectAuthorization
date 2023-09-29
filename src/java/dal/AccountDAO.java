/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends DBContext {

    //get list acc
    public List<Account> getList() {
        List<Account> list = new ArrayList<>();
        //connect db
        connection = getConnection();
        String sql = "select * from Account";
        try {
            //prepare commant
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account acc = new Account();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int role = resultSet.getInt("role");
                acc.setId(id);
                acc.setUsername(username);
                acc.setRole(role);
                acc.setPassword(password);
                list.add(acc);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Account checkAcc(String username, String password) {
        
        for (Account account : getList()) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
    
    public int getRole(String username) {
        for (Account account : getList()) {
            if (account.getUsername().equals(username)) {
                return account.getId();
            }
        }
        return -1;
    }
    
    public int AddAccountFromAddmin(String username, String password, int role) {
        //connect db
        connection = getConnection();
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        
        try {
            //  prepare command
            statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, role);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return -1;
    }
}
