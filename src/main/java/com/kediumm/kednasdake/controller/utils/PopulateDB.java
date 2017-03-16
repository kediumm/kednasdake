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
package com.kediumm.kednasdake.controller.utils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.kediumm.kednasdake.controller.core.ConnectionDB;

/**
 *
 * 
 */
public class PopulateDB {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	private ConnectionDB conn = null;
	private Statement stmt = null;

	public PopulateDB() {

		conn = ConnectionDB.getInstance();
	}

	/**
	 * Create StockTrade table
	 */
	public void createStockTradeTB() {
		
		logger.info(" Create table StockTrade in DB.");
    	
    	String stocktrade_table = "CREATE TABLE StockTrade ("
    									+ "st_id int primary key, "
    									+ "st_symbol varchar(20), "
    									+ "st_date timestamp, "
    									+ "st_quantity double, "
    									+ "st_sales varchar(150), "
    									+ "st_price double "
    									+ ")";
    	
    	try {
			stmt = conn.getConnection().createStatement();
			
			stmt.execute(stocktrade_table);
			
			
		} catch (SQLException e) {
			
			logger.log(Level.SEVERE, "Error create table StockTrade.", e);
			
			//e.printStackTrace();
		}
    	
    }

	/**
	 * Create GBCE table
	 */
	public void createGBCETB() {
		
		logger.info(" Create table StockTrade in DB.");
    	
    	String gbce_table = "CREATE TABLE GBCE ("
    									+ "stk_id int primary key, "
    									+ "stk_symbol varchar(20), "
    									+ "stk_type varchar(10), "
    									+ "stk_last_dividend double, "
    									+ "stk_fixed_dividend double, "
    									+ "stk_value double, "
    									+ "stk_price double "
    									+ ")";
    	
    	try {
			stmt = conn.getConnection().createStatement();
			
			stmt.execute(gbce_table);
			
			createGBCEData();
			
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error create table GBCE.", e);
			
			//e.printStackTrace();
			
		}
    	
    }

	public void createGBCEData() {
		
		logger.info(" Create GBCE data in DB.");
		
		String gbce_data1 = "INSERT INTO GBCE VALUES (1, 'TEA', 'Common', (double)0.00, (double)0.00, (double)100.00)";
		String gbce_data2 = "INSERT INTO GBCE VALUES (2, 'POP', 'Common', (double)8.00, (double)0.00, (double)100.00)";
		String gbce_data3 = "INSERT INTO GBCE VALUES (3, 'ALE', 'Common', (double)23.00, (double)0.00, (double)60.00)";
		String gbce_data4 = "INSERT INTO GBCE VALUES (4, 'GIN', 'Preferred', (double)8.00, (double)2.00, (double)100.00)";
		String gbce_data5 = "INSERT INTO GBCE VALUES (5, 'JOE', 'Common', (double)13.00, (double)0.00, (double)250.00)";
				

		try {
			
			stmt = conn.getConnection().createStatement();
			
			stmt.execute(gbce_data1);
			stmt.execute(gbce_data2);
			stmt.execute(gbce_data3);
			stmt.execute(gbce_data4);
			stmt.execute(gbce_data5);
		
		
		} catch (SQLException e) {
			
			// send error message to server log
            logger.log(Level.SEVERE, "Error create GBCE data.", e);
            
			//e.printStackTrace();
		}
				
	}

}
