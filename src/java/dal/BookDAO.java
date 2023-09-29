/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author ADMIN
 */
public class BookDAO extends DBContext{
    
      //get list book
    public List<Book> getList(){
    List<Book> list = new ArrayList<>();
    //connect db
    connection =getConnection();
    String sql ="select * from Book";
        try {
            //prepare commant
            statement =connection.prepareStatement(sql);
            resultSet =statement.executeQuery();
            while (resultSet.next()) {                
                Book acc = new Book();
                String username= resultSet.getString("name");
                                String password= resultSet.getString("describle");
                acc.setName(username);
                acc.setDescrible(password);
                list.add(acc);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public Book getBookByID(String id) {
        for (Book book : getList()) {
            if(book.getName().equals(id))
            {
                return book;
            }
        }
        return null;
    }
  
}
