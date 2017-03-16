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

import com.kediumm.kednasdake.model.StockTrade;

public class CalculationGBCE {
	
	private double value = 0.0;
	private double count;

	public CalculationGBCE() {}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Calculation of GBCE using Geometric Mean
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<StockTrade> lstStockTrade</em>' attribute.
	 * @model 
	 * @generated
	 * @return value of All Share index
	 * @throws
	 */
	private double calcGeometricMean(List<StockTrade> lstStockTrade) {
		
		StockTrade objStockTrade = new StockTrade();
		
		try {
			
			for (int i=0; i < lstStockTrade.size(); i++) {
				
				objStockTrade = lstStockTrade.get(i);
				
				if ( objStockTrade.getStPrice()!=0 ) {
					
					if (value == 0.0) {
						value = objStockTrade.getStPrice();
						count++;
					} else {
						value = value*objStockTrade.getStPrice();
						count++;
					}
					
				}
				
			}
			
		} catch (Exception ex) {
			
			System.out.println("UPPSSS ...  " + ex);
			
		}
		
		return (Math.pow(value, (1/count)));
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Get the Calculation of GBCE using Geometric Mean
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<StockTrade> lstStockTrade</em>' attribute.
	 * @model 
	 * @generated
	 * @return value of All Share index
	 * @throws
	 */
	public void getGeometricMean(List<StockTrade> lstStockTrade) {
		
		double geometric_mean = calcGeometricMean(lstStockTrade);
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("GBCE All Share is >>> " + geometric_mean);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
	}
}
