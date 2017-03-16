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
 * @data: 2016/01/13
 * 
 * This source code is intended for educational and illustrative purposes only
 * and is provided AS-IS without warranty of any kind.
 * 
 */
package com.kediumm.kednasdake.controller.inter;

public interface Formula {
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Product of Two Doubles
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double x</em>' attribute.
	 * @param the new value of the '<em>double y</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getProduct(double x, double y) throws Exception;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Division of Two Doubles
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double x</em>' attribute.
	 * @param the new value of the '<em>double y</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public double getDivision(double x, double y) throws Exception;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Product of Two Integer
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double x</em>' attribute.
	 * @param the new value of the '<em>double y</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public int getProduct(int x, int y) throws Exception;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Formula to Get Division of Two Integer
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param the new value of the '<em>double x</em>' attribute.
	 * @param the new value of the '<em>double y</em>' attribute.
	 * @model 
	 * @generated
	 * @throws Exception
	 */
	public int getDivision(int x, int y) throws Exception;

}
