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
package com.kediumm.kednasdake.controller.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kediumm.kednasdake.controller.prefs.JdbcEM;
import com.kediumm.kednasdake.controller.utils.ErrorMessage;

public class ConnectionDB {

    private Logger logger = Logger.getLogger(getClass().getName());

    private static ConnectionDB instance = new ConnectionDB();

    private Connection conn;

    private ConnectionDB() {
    }

    public static ConnectionDB getInstance() {

        return instance;
    }

    public Connection getConnection() {

        logger.info("Try start new DB connection.");

        try {

            //Class.forName(JdbcEM.JDBC_DRIVERCLASSNAME.getValue()).newInstance();
        	Class.forName(JdbcEM.JDBC_DRIVERCLASSNAME.getValue());

            conn = DriverManager.getConnection(JdbcEM.JDBC_URL.getValue(), JdbcEM.JDBC_USER.getValue(),
                    JdbcEM.JDBC_PASSWD.getValue());

        } catch (SQLException e) {

            // send error message to server log
            logger.log(Level.SEVERE, "Error get new db connection.", e);

            // send error message for JSF page
            ErrorMessage.addErrorMessage(e);
            //e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);

            logger.log(Level.SEVERE, "Error to get driver class name for connection.", ex);
        }

        return conn;
    }
}
