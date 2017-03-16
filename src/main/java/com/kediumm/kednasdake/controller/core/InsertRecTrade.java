/**
 * Copyright 2016 Miguel Vale Teixeira
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
 * @data: 2016/12/22
 * 
 * This source code is intended for educational and illustrative purposes only
 * and is provided AS-IS without warranty of any kind.
 * 
 */
package com.kediumm.kednasdake.controller.core;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kediumm.kednasdake.controller.prefs.CoinsEM;
import com.kediumm.kednasdake.controller.prefs.IndicatorsEM;
import com.kediumm.kednasdake.model.GBCE;
import com.kediumm.kednasdake.model.StockTrade;

public class InsertRecTrade {
	
	private FindData find_data = new FindData();
	private List<StockTrade> lstRecTrade = new ArrayList<StockTrade>();
	
	private String symbol;
	private String indicator = "";
	private boolean validator;
	
	public InsertRecTrade() {
		
		validator = false;
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Create new Records Trades
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<GBCE> lstGBCE</em>' attribute.
	 * @model 
	 * @generated
	 * @return 
	 * @throws
	 */
	/*
	public void insertRecTrade(List<GBCE> lstGBCE) {
		
		StockTrade objStockTrade = new StockTrade();
		GBCE objGBCE = new GBCE();
		
	
		do {
			
			System.out.print("What's Stock symbol you are trade? ");
			symbol = ReadData.readString().toUpperCase();
			
			
			objGBCE = find_data.findRecord(lstGBCE, symbol);
			
			if(objGBCE == null)
				System.out.println("Stock symbol not exist! ");
			
			
		}while(objGBCE == null);
		objStockTrade.setSt_Symbol(symbol);
		
		//objStockTrade.setSt_date(ZonedDateTime.now());
		
		
		System.out.print("Insert Quantity of Shares: ");
		objStockTrade.setSt_Quantity((double)ReadData.readInt());
		
		do {
			
			System.out.print("Insert Indicator (" + IndicatorsEM.BUY.getValue() + " or " + IndicatorsEM.SELL.getValue() + "): ");
			indicator = ReadData.readString().toUpperCase();
			
			if (indicator.equals( IndicatorsEM.BUY.getValue() ) || indicator.equals( IndicatorsEM.SELL.getValue() )) {
				validator = true;
			} else {
				System.out.println( IndicatorsEM.BUY.getValue() + " or " + IndicatorsEM.SELL.getValue() + " only, please.");
				validator = false;
			}
			
		}while(validator == false);
		objStockTrade.setSt_Sales(indicator);
		
		System.out.print("Insert Price: ");
		objStockTrade.setSt_Price(ReadData.readDouble());
		
		lstRecTrade.add(objStockTrade);
		
	}
	*/
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * View all Records Trades
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param
	 * @model 
	 * @generated
	 * @return 
	 * @throws
	 */
	/*
	public void viewRecTrade() {
		
		StockTrade objStockTrade = new StockTrade();
		
		System.out.println("Data from the Record");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|| Stock Symbol | Date | Quantity| Indicator | Price ");
		for (int i=0; i < lstRecTrade.size(); i++) {
		
			objStockTrade = lstRecTrade.get(i);
			System.out.println("|| " + objStockTrade.getSt_Symbol() + " | " + objStockTrade.getSt_Date() + " | " + objStockTrade.getSt_Quantity() + " | " +
					objStockTrade.getSt_Sales() +  " | " + objStockTrade.getSt_Price() + CoinsEM.GBP.getValue() );
		
		}
		
	}
	*/

	/**
	 * @return the lstRecTrade
	 */
	public List<StockTrade> getLstRecTrade() {
		return lstRecTrade;
	}

	/**
	 * @param lstRecTrade the lstRecTrade to set
	 */
	public void setLstRecTrade(List<StockTrade> lstRecTrade) {
		this.lstRecTrade = lstRecTrade;
	}
	
	

}
