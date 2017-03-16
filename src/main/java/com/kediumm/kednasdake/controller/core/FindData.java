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

import com.kediumm.kednasdake.model.GBCE;

public class FindData {
	
	private GBCE objGBCE = new GBCE();
	private int index;
	
	public FindData() {}

	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Find if Stock Symbol exist. 
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>List<GBCE> lstGBCE</em>' attribute.
	 * @param the new value of the '<em>String find_symbol</em>' attribute.
	 * @model 
	 * @generated
	 * @return the GBCE object
	 * @throws
	 */
	public GBCE findRecord(List<GBCE> lstGBCE, String find_symbol) {
		
		for (int i=0; i < lstGBCE.size(); i++) {
			
			objGBCE = lstGBCE.get(i);
			
			if ((objGBCE.getGbceSymbol()).equals(find_symbol)) {
				index = i;
				return objGBCE;
				//break;
			}
			
		}
		
		return null;
		
	}


	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

}
