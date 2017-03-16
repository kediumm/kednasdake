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

import com.kediumm.kednasdake.controller.abs.AbstractFormula;




public class FormulaStockPrice extends AbstractFormula {
	
	

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Dividend Yield Common
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double dividend</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getDividendYield_Common(double last_dividend, double ticker_price) throws Exception {
		
		return  getDivision(last_dividend, ticker_price);
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Dividend Yield Preferred
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double dividend</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @param the new value of the '<em>double value</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getDividendYield_Preferred(double fixed_dividend, double ticker_price, double par_value) throws Exception {
		
		return getDivision(getProduct(getPercentage(fixed_dividend), par_value), ticker_price);
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get P/E Ratio
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double dividend</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getPERatioPerc(double fixed_dividend, double ticker_price) throws Exception {
		
		return getDivision(ticker_price, getPercentage(fixed_dividend));
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get P/E Ratio
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double dividend</em>' attribute.
	 * @param the new value of the '<em>double ticker_price</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getPERatio(double last_dividend, double ticker_price) throws Exception {
		
		return getDivision(ticker_price, last_dividend);
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Percentage
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double percentage</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getPercentage (double percentage) throws Exception {
		
		return getDivision(percentage, 100);
	}
	
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Stock Price
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double trade_price</em>' attribute.
	 * @param the new value of the '<em>double quantity</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getStockPrice(double trade, double quantity) throws Exception {
		
		return getDivision(trade, quantity);
		
	}

	
}
