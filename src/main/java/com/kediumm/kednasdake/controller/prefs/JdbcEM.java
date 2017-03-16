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
 * @data: 2017/01/04
 * 
 * This source code is intended for educational and illustrative purposes only
 * and is provided AS-IS without warranty of any kind.
 * 
 */
package com.kediumm.kednasdake.controller.prefs;

public enum JdbcEM {

	JDBC_DRIVERCLASSNAME("org.postgresql.Driver"),
	
	JDBC_URL("jdbc:postgresql://localhost:5436/kednasdakes"),
	
	JDBC_USER("ked"),
	
	JDBC_PASSWD("ked2017")
    
    ;
	
	private String value;
	
	private JdbcEM(String value) {
		
		this.value = value;
	}

	public String getValue() {
		
		return value;
	}	
}
