package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO implements InterfaceDAO {
	
	private final String _URL = "jdbc:mysql://172.30.10.73:3306/flowers";
    private final String _USER = "root";
    private final String _PASSWORD = "root";
	
    /**
     * Запросить подключение к базе данных на сервер 172.30.10.73
     * 
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( _URL, _USER, _PASSWORD);
    }
    
}
