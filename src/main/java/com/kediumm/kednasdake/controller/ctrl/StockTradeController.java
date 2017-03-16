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
 * @data: 2016/01/15
 *
 * This source code is intended for educational and illustrative purposes only
 * and is provided AS-IS without warranty of any kind.
 *
 */
package com.kediumm.kednasdake.controller.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.kediumm.kednasdake.controller.dao.StockTradeDAO;
import com.kediumm.kednasdake.controller.utils.ErrorMessage;
import com.kediumm.kednasdake.model.StockTrade;

@ManagedBean
@SessionScoped
public class StockTradeController implements Serializable {

    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(getClass().getName());
    
    private List<StockTrade> lstStockTrade;
    private StockTradeDAO stockTradeDAO;
    
    /**
     * 
     * @throws Exception
     */
    public StockTradeController() throws Exception {
    	lstStockTrade = new ArrayList<StockTrade>();
    	
    	stockTradeDAO = StockTradeDAO.getInstance();
    	
    }
    
    /**
     * 
     * @return
     */
    public List<StockTrade> getStockTrade() {
    	
    	return lstStockTrade;
    }
    
    /**
     * 
     */
    public void loadStockTrade() {
    	
    	logger.info("Loading StockTrade!!!");
    	
    	lstStockTrade.clear();
    	
    	try {
    	
    		//get all StockTrade from database 
    		lstStockTrade = stockTradeDAO.getStockTrade();
    	} catch(Exception ex) {
    		
    		// send erro to server logs
    		logger.log(Level.SEVERE, "Error loading StockTrade.", ex);
    		
    		// add error message to JSF page
    		ErrorMessage.addErrorMessage(ex);
    		
    	}
    	
    }
    
    
    

}
