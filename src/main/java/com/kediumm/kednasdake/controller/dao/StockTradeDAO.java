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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kediumm.kednasdake.controller.core.ConnectionDB;
import com.kediumm.kednasdake.model.StockTrade;

/**
 *
 * 
 */
public class StockTradeDAO {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private static StockTradeDAO instance = new StockTradeDAO();
	
	private StockTradeDAO() {}
	
	public static StockTradeDAO getInstance() {

        return instance;
    }
	
	/**
	 * 
	 * @return
	 */
	public List<StockTrade> getStockTrade() {
		
		String query = "SELECT * FROM stocktrade";
		List<StockTrade> stTraces = new ArrayList<StockTrade>();
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			myConn = conn.getConnection();
			
			stmt = myConn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			//process result set
			while ( rset.next() ) {
				
				//Retrieve data from result set row
				Integer id = rset.getInt("st_id");
				String symbol = rset.getString("st_symbol");
				Timestamp date = rset.getTimestamp("st_date");
				Double quantity = rset.getDouble("st_quantity");
				String sales = rset.getString("st_sales");
				Double price = rset.getDouble("st_price");
				
				// create new GBCE object
				StockTrade tempStockTrade = new StockTrade(id, symbol, date, quantity, sales, price);
				
				// add it to the list of GBCE
				stTraces.add(tempStockTrade);
				
				
			}
			
			return stTraces;
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error get StockTrade data.", e);
            
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
		
		return stTraces;
		
	}
 
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public StockTrade getStockTrade( Integer stkTradeId) throws Exception {
		
		String query = "SELECT * FROM stocktrade WHERE st_id = ?";
		StockTrade tempStockTrade = null;
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setInt(1, stkTradeId);
			
			rset = pstmt.executeQuery(query);
			
			//retrieve data from result set row
			if ( rset.next() ) {
				
				//Retrieve data from result set row
				Integer id = rset.getInt("st_id");
				String symbol = rset.getString("st_symbol");
				Timestamp date = rset.getTimestamp("st_date");
				Double quantity = rset.getDouble("st_quantity");
				String sales = rset.getString("st_sales");
				Double price = rset.getDouble("st_price");
				
				// create new GBCE object
				tempStockTrade = new StockTrade(id, symbol, date, quantity, sales, price);
				
			} else {
				
				throw new Exception("Could not find StockTrade id: " + stkTradeId);
			}
			
			return tempStockTrade;
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error get StockTrade data.", e);
            
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
		
		return tempStockTrade;
		
	}


	/**
	 * 
	 * @param theStockTrade
	 */
	public void addStockTrade(StockTrade theStockTrade) {
		
		String query = "INSERT INTO stocktrade (st_symbol, st_date, st_quantity, st_sales, st_price) "
							+ " VALUES (?, ?, ?, ?, ?)";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setString(1, theStockTrade.getStSymbol());
			pstmt.setTimestamp(2, theStockTrade.getStDate());
			pstmt.setDouble(3, theStockTrade.getStQuantity());
			pstmt.setString(4, theStockTrade.getStSales());
			pstmt.setDouble(5, theStockTrade.getStPrice());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try save new StockTrade.", e);
            
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
	 * @param theStockTrade
	 */
	public void updateStockTrade(StockTrade theStockTrade) {
		
		String query = "UPDATE stocktrade set st_symbol = ?,"
								+ " st_date = ?"
								+ " st_quantity = ?"
								+ " st_sales = ?"
								+ " st_price = ?"
								+ " WHERE st_id = ?";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setString(1, theStockTrade.getStSymbol());
			pstmt.setTimestamp(2, theStockTrade.getStDate());
			pstmt.setDouble(3, theStockTrade.getStQuantity());
			pstmt.setString(4, theStockTrade.getStSales());
			pstmt.setDouble(5, theStockTrade.getStPrice());
			pstmt.setInt(6, theStockTrade.getStId());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try updated StockTrade.", e);
            
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
	 * @param stkTradeId
	 */
	public void deleteStockTrade(Integer stkTradeId) {
		
		String query = "DELETE FROM stocktrade WHERE st_id = ?";
		
		ConnectionDB conn = ConnectionDB.getInstance();
		Connection myConn = null;
		PreparedStatement pstmt = null;
		
		try {
			myConn = conn.getConnection();
			
			pstmt = myConn.prepareStatement(query);
			
			//set params
			pstmt.setInt(1, stkTradeId);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error when try updated StockTrade.", e);
            
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
