package dao;

public class DAOFactory {
	
	private static DAOFactory factory;
	
	/**
	 * DAOFactory constructor
	 */
	private DAOFactory() {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public static synchronized DAOFactory getInstance() {
		if ( factory == null ) {
			factory = new DAOFactory();
		}
		
		return factory;
	}
	
}
