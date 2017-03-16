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

import java.util.List;

import com.kediumm.kednasdake.controller.prefs.CoinsEM;
import com.kediumm.kednasdake.controller.prefs.StockType;
import com.kediumm.kednasdake.model.GBCE;

public class CalculationStock extends FormulaStockPrice {

	private double dividend_yield;
	private double ratio;
	
	public CalculationStock() {}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Calculation value to Dividend Yield Common and Preferred and print the values
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<GBCE> lstGBCE</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @model 
	 * @generated
	 * @throws
	 */
	public void calcDividendYield(List<GBCE> lstGBCE, double ticker_price) {
		
		GBCE objGBCE = new GBCE();
		/*
		System.out.println("Calculate the DEVIDEND YIELD");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|| Stock Symbol | Type | Last Dividend | Fixed Dividend | Par Value | Dividend Yield");
		*/
		try {
			
			for (int i=0; i < lstGBCE.size(); i++) {
				
				objGBCE = lstGBCE.get(i);
				//dividend_yield = 0;
				
				if ( objGBCE.getGbceType() == StockType.COMMON.getValue() )
					dividend_yield = getDividendYield_Common(objGBCE.getGbceLastDividend(), ticker_price);
				
				if ( objGBCE.getGbceType() == StockType.PREFERRED.getValue() )
					dividend_yield = getDividendYield_Preferred(objGBCE.getGbceFixedDividend(), ticker_price, objGBCE.getGbceValue() );
				/*
				System.out.println("|| " + objGBCE.getGbceSymbol() + " | " + objGBCE.getGbce_Type() + " | " +
											objGBCE.getGbceLastDividend() + CoinsEM.GBP.getValue() + " | " + objGBCE.getGbce_Fixed_Dividend() + "%" + " | " +
											objGBCE.getGbce_Value() + CoinsEM.GBP.getValue() + " | " +  dividend_yield + CoinsEM.GBP.getValue() );
				 */
				
				
				
			}
			
		} catch (Exception ex) {
			
			System.out.println("UPPSSS ...  " + ex);
			
		}
		
		
		
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Calculation value to P/E Ratio and print the value
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<GBCE> lstGBCE</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @model 
	 * @generated
	 * @throws
	 */
	public void calcPERatio(List<GBCE> lstGBCE, double ticker_price) {
		
		GBCE objGBCE = new GBCE();
		/*
		System.out.println("Calculate the P/E RATIO");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|| Stock Symbol | Type | Last Dividend | Fixed Dividend | Par Value | P/E Ratio");
		*/
		
		try {
			
			for (int i=0; i < lstGBCE.size(); i++) {
				
				objGBCE = lstGBCE.get(i);
				ratio = 0;
				/*
				if ( objGBCE.getStk_fixed_dividend() != 0 ) {
					
					ratio = getPERatioPerc(objGBCE.getStk_fixed_dividend(), ticker_price);
					
				} 
				*/	
				
				if ( objGBCE.getGbceLastDividend() != 0 ) {
					
					ratio = getPERatio(objGBCE.getGbceLastDividend(), ticker_price);
					
				} 
				/*
				System.out.println("|| " + objGBCE.getGbce_Symbol() + " | " + objGBCE.getGbce_Type() + " | " +
											objGBCE.getGbce_Last_Dividend() + CoinsEM.GBP.getValue() + " | " + objGBCE.getGbce_Fixed_Dividend() + "%" + " | " +
											objGBCE.getGbce_Value() + CoinsEM.GBP.getValue() + " | " +  ratio);
				 */
				
				
				
			}
			
		} catch (Exception ex) {
			
			System.out.println("UPPSSS ...  " + ex);
			
		}
		
		
	}
	
	
	

}
