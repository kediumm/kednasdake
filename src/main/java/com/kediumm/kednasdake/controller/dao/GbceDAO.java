/**
 * Copyright 2017 Miguel Vale Teixeira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author: Miguel Vale Teixeira
 * @data: 2017/01/04
 *
 * This source code is intended for educational and illustrative purposes only
 * and is provided AS-IS without warranty of any kind.
 *
 */
package com.kediumm.kednasdake.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kediumm.kednasdake.controller.core.ConnectionDB;
import com.kediumm.kednasdake.model.GBCE;


/**
 *
 * 
 */
public class GbceDAO {
    
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private static GbceDAO instance = new GbceDAO();
	
	private GbceDAO() {}
	
	public static GbceDAO getInstance() {

        return instance;
    }
	
	/**
	 * 
	 * @return
	 */
	public List<GBCE> getGbceRecords() {
		
		String query = "SELECT * FROM gbce";
		List<GBCE> gbces = new ArrayList<GBCE>();
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			myConn = conn.getConnection();
			
			if ( myConn.isClosed() ) {
				
				System.out.println(">>>>>>> Connection closed!!!!!!");
			}
			stmt = myConn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			//process result set
			while ( rset.next() ) {
				
				//Retrieve data from result set row
				Integer id = rset.getInt("stk_id");
				String symbol = rset.getString("stk_symbol");
				String type = rset.getString("stk_type");
				Double las_dividend = rset.getDouble("stk_last_dividend");
				Double fixed_dividend = rset.getDouble("stk_fixed_dividend");
				Double value = rset.getDouble("stk_value");
				Double price = rset.getDouble("stk_price");
				
				// create new GBCE object
				GBCE tempGBCE = new GBCE(id, symbol, type, las_dividend, fixed_dividend, value, price);
				
				// add it to the list of GBCE
				gbces.add(tempGBCE);
				
				
			}
			
			System.out.printf("The size of list 'gbces' is: ", gbces.size() );
			
			return gbces;
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error get GBCE data.", e);
            
			//e.printStackTrace();
		} finally {
			
			try {
				
				if ( rset != null) {
					rset.close();
				}
				
				if ( stmt != null ) {
					stmt.close();
				}
				
				if ( myConn != null ) {
					myConn.close();
				}
				
			} catch (SQLException re) {
				
				// send error message to server log
	            logger.log(Level.SEVERE, "Error when try closed ResultSet/Statement/Connection.", re);
	            
				//e.printStackTrace();
			}
			
		}
		
		return gbces;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public GBCE getGbce( Integer gbceId) throws Exception {
		
		String query = "SELECT * FROM gbce WHERE stk_id = ?";
		GBCE gbce = null;
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setInt(1, gbceId);
			
			rset = pstmt.executeQuery(query);
			
			//retrieve data from result set row
			if ( rset.next() ) {
				
				//Retrieve data from result set row
				Integer id = rset.getInt("stk_id");
				String symbol = rset.getString("stk_symbol");
				String type = rset.getString("stk_type");
				Double las_dividend = rset.getDouble("stk_last_dividend");
				Double fixed_dividend = rset.getDouble("stk_fixed_dividend");
				Double value = rset.getDouble("stk_value");
				Double price = rset.getDouble("stk_price");
				
				// create new GBCE object
				gbce = new GBCE(id, symbol, type, las_dividend, fixed_dividend, value, price);
				
			} else {
				
				throw new Exception("Could not find GBCE id: " + gbceId);
			}
			
			return gbce;
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error get GBCE data.", e);
            
			//e.printStackTrace();
		} finally {
			
			try {
				
				if ( rset != null) {
					rset.close();
				}
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( myConn != null ) {
					myConn.close();
				}
				
				
			} catch (SQLException re) {
				
				// send error message to server log
	            logger.log(Level.SEVERE, "Error when try closed ResultSet/Statement/Connection.", re);
	            
				//e.printStackTrace();
			}
			
		}
		
		return gbce;
		
	}
	
	
	/**
	 * 
	 * @param theGBCE
	 */
	public void addGBCE(GBCE theGBCE) {
		
		String query = "INSERT INTO gbce (stk_symbol, stk_type, stk_last_dividend, stk_fixed_dividend, stk_value, stk_price) "
							+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setString(1, theGBCE.getGbceSymbol());
			pstmt.setString(2, theGBCE.getGbceType());
			pstmt.setDouble(3, theGBCE.getGbceLastDividend());
			pstmt.setDouble(4, theGBCE.getGbceFixedDividend());
			pstmt.setDouble(5, theGBCE.getGbceValue());
			pstmt.setDouble(6, theGBCE.getGbcePrice());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try save new GBCE.", e);
            
			//e.printStackTrace();
		} finally {
			
			try {
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( myConn != null ) {
					myConn.close();
				}
				
				
			} catch (SQLException se) {
				
				// send error message to server log
	            logger.log(Level.SEVERE, "Error when try closed Statement/Connection.", se);
	            
				//e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param theGBCE
	 */
	public void updateGBCE(GBCE theGBCE) {
		
		String query = "UPDATE gbce set stk_symbol = ?,"
								+ " stk_type = ?"
								+ " stk_last_dividend = ?"
								+ " stk_fixed_dividend = ?"
								+ " stk_value = ?"
								+ " stk_price = ?"
								+ " WHERE stk_id = ?";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setString(1, theGBCE.getGbceSymbol());
			pstmt.setString(2, theGBCE.getGbceType());
			pstmt.setDouble(3, theGBCE.getGbceLastDividend());
			pstmt.setDouble(4, theGBCE.getGbceFixedDividend());
			pstmt.setDouble(5, theGBCE.getGbceValue());
			pstmt.setDouble(6, theGBCE.getGbcePrice());
			pstmt.setInt(7,theGBCE.getGbceId());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try updated GBCE.", e);
            
			e.printStackTrace();
		} finally {
			
			try {
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( myConn != null ) {
					myConn.close();
				}
				
				
			} catch (SQLException se) {
				
				// send error message to server log
	            logger.log(Level.SEVERE, "Error when try closed Statement/Connection.", se);
	            
				//e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @param gbceId
	 */
	public void deleteGBCE(Integer gbceId) {
		
		String query = "DELETE FROM gbce where stk_id = ?";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setInt(1, gbceId);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try updated GBCE.", e);
            
			e.printStackTrace();
		} finally {
			
			try {
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( myConn != null ) {
					myConn.close();
				}
				
				
			} catch (SQLException se) {
				
				// send error message to server log
	            logger.log(Level.SEVERE, "Error when try closed Statement/Connection.", se);
	            
				//e.printStackTrace();
			}
			
		}
		
		
	}
}
