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
package com.kediumm.kednasdake.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stocktrade")
public class StockTrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="STOCKTRADE_ID_GENERATOR", sequenceName="seqStocktrade")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STOCKTRADE_ID_GENERATOR")
    @Column(name = "st_id")
    private int st_id;

    @Column(name = "st_symbol")
    private String st_symbol;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "st_date")
    private Date st_date;

    @Column(name = "st_quantity", precision = 3)
    private double st_quantity;

    @Column(name = "st_sales")
    private String st_sales;

    @Column(name = "st_price", precision = 3)
    private double st_price;

    public StockTrade() {
    }

    public StockTrade(Integer st_id, String st_symbol, Timestamp st_date, double st_quantity, String st_sales, double st_price) {

    	this.st_id = st_id;
        this.st_symbol = st_symbol;
        this.st_date = st_date;
        this.st_quantity = st_quantity;
        this.st_sales = st_sales;
        this.st_price = st_price;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StockTrade [st_id=" + st_id
                + ", st_symbol=" + st_symbol
                + ", st_date=" + st_date
                + ", st_quantity=" + st_quantity
                + ", st_sales=" + st_sales
                + ", st_price=" + st_price
                + "]";
    }

    /**
     * 
     * @return the st_id
     */
    public int getStId() {
        return st_id;
    }

    /**
     * 
     * @param st_id 
     */
    public void setStId(int st_id) {
        this.st_id = st_id;
    }
    
    /**
     * @return the st_symbol
     */
    public String getStSymbol() {
        return st_symbol;
    }

    /**
     * @param st_symbol
     */
    public void setStSymbol(String st_symbol) {
        this.st_symbol = st_symbol;
    }

    /**
     * @return the st_date
     */
    public Timestamp getStDate() {
        return st_date;
    }

    /**
     * @param zonedDateTime the st_date to set
     */
    public void setStDate(Timestamp zonedDateTime) {
        this.st_date = zonedDateTime;
    }

    /**
     * @return the st_quantity
     */
    public double getStQuantity() {
        return st_quantity;
    }

    /**
     * @param st_quantity the st_quantity to set
     */
    public void setStQuantity(double st_quantity) {
        this.st_quantity = st_quantity;
    }

    /**
     * @return the st_sales
     */
    public String getStSales() {
        return st_sales;
    }

    /**
     * @param st_sales the st_sales to set
     */
    public void setStSales(String st_sales) {
        this.st_sales = st_sales;
    }

    /**
     * @return the st_price
     */
    public double getStPrice() {
        return st_price;
    }

    /**
     * @param st_price the st_price to set
     */
    public void setStPrice(double st_price) {
        this.st_price = st_price;
    }

}
