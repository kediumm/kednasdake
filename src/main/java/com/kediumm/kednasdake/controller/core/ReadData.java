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

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadData {
	
	private ReadData() {}
	
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Read String from the Terminal
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param 
	 * @model 
	 * @generated
	 * @throws 
	 */
	public static String readString() {
		
		String str = "";
		
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1); 
			
			str = in.readLine();
			
		} catch (Exception e) {
			System.out.println(">>>>>> Error reading from the input stream. <<<<<<");
		}
		
		return str;
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Read Integer from the Terminal
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param 
	 * @model 
	 * @generated
	 * @throws 
	 */
	public static int readInt() {
		
		while(true) {
			
			try {
				return Integer.valueOf(readString().trim()).intValue();
			} catch (Exception e) {
				System.out.println(">>>>>> Is not Integer value! <<<<<<< ");
			}
		}
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Read Float from the Terminal
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param 
	 * @model 
	 * @generated
	 * @throws 
	 */
	public static float readFloat() {
		
		while(true) {
					
			try {
				return Float.valueOf(readString().trim()).floatValue();
			} catch (Exception e) {
				System.out.println(">>>>>> Is not Float value! <<<<<<< ");
			}
		}
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Read Double from the Terminal
	 * <!-- end-user-doc -->
	 * 
	 * @see 
	 * @param 
	 * @model 
	 * @generated
	 * @throws 
	 */
	public static double readDouble() {
		
		while(true) {
					
			try {
				return Double.valueOf(readString().trim()).doubleValue();
			} catch (Exception e) {
				System.out.println(">>>>>> Is not Double value! <<<<<<< ");
			}
		}
	}

}
