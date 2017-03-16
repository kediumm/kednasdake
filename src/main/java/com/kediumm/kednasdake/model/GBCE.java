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
package com.kediumm.kednasdake.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gbce")
public class GBCE implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="GBCE_ID_GENERATOR", sequenceName="seqGbce")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GBCE_ID_GENERATOR")
    @Column(name = "gbce_id")
    private int gbce_id;

    @Column(name ="gbce_symbol")
    private String gbce_symbol;
    
    @Column(name = "gbce_type")
    private String gbce_type;
    
    @Column(name = "gbce_last_dividend", precision = 3)
    private double gbce_last_dividend;
    
    @Column(name = "gbce_fixed_dividend", precision = 3)
    private double gbce_fixed_dividend;
    
    @Column(name = "gbce_value", precision = 3)
    private double gbce_value;

    @Column(name = "gbce_price", precision = 3)
    private double gbce_price;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc --> @model @generated
     */
    public GBCE() {

    }

    /*
    public GBCE(String gbce_symbol, String gbce_type, double gbce_last_dividend, double gbce_fixed_dividend, double gbce_value) {

        this.gbce_symbol = gbce_symbol;
        this.gbce_type = gbce_type;
        this.gbce_last_dividend = gbce_last_dividend;
        this.gbce_fixed_dividend = gbce_fixed_dividend;
        this.gbce_value = gbce_value;
    }
    */
    
    public GBCE(Integer gbce_id, String gbce_symbol, String gbce_type, double gbce_last_dividend, double gbce_fixed_dividend, 
    		double gbce_value, double gbce_price) {

    	this.gbce_id = gbce_id;
        this.gbce_symbol = gbce_symbol;
        this.gbce_type = gbce_type;
        this.gbce_last_dividend = gbce_last_dividend;
        this.gbce_fixed_dividend = gbce_fixed_dividend;
        this.gbce_value = gbce_value;
        this.gbce_price = gbce_price;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GBCE [gbce_id=" + gbce_id
                + ", gbce_symbol=" + gbce_symbol
                + ", gbce_type=" + gbce_type
                + ", gbce_last_dividend=" + gbce_last_dividend
                + ", gbce_fixed_dividend=" + gbce_fixed_dividend
                + ", gbce_value=" + gbce_value
                + ", gbce_price=" + gbce_price
                + "]";
    }

    /**
     * 
     * @return 
     */
    public int getGbceId() {
        return gbce_id;
    }

    /**
     * 
     * @param gbce_id 
     */
    public void setGbceId(int gbce_id) {
        this.gbce_id = gbce_id;
    }
    
    /**
     * @return the gbce_symbol
     */
    public String getGbceSymbol() {
        return gbce_symbol;
    }

    /**
     * @param gbce_symbol the gbce_symbol to set
     */
    public void setGbceSymbol(String gbce_symbol) {
        this.gbce_symbol = gbce_symbol;
    }

    /**
     * @return the gbce_type
     */
    public String getGbceType() {
        return gbce_type;
    }

    /**
     * @param gbce_type the gbce_type to set
     */
    public void setGbceType(String gbce_type) {
        this.gbce_type = gbce_type;
    }

    /**
     * @return the gbce_last_dividend
     */
    public double getGbceLastDividend() {
        return gbce_last_dividend;
    }

    /**
     * @param gbce_last_dividend the gbce_last_dividend to set
     */
    public void setGbceLastDividend(double gbce_last_dividend) {
        this.gbce_last_dividend = gbce_last_dividend;
    }

    /**
     * @return the gbce_fixed_dividend
     */
    public double getGbceFixedDividend() {
        return gbce_fixed_dividend;
    }

    /**
     * @param gbce_fixed_dividend the gbce_fixed_dividend to set
     */
    public void setGbceFixedDividend(double gbce_fixed_dividend) {
        this.gbce_fixed_dividend = gbce_fixed_dividend;
    }

    /**
     * @return the gbce_value
     */
    public double getGbceValue() {
        return gbce_value;
    }

    /**
     * @param gbce_value the gbce_value to set
     */
    public void setGbceValue(double gbce_value) {
        this.gbce_value = gbce_value;
    }

    /**
     * @return the gbce_price
     */
    public double getGbcePrice() {
        return gbce_price;
    }

    /**
     * @param gbce_price the gbce_price to set
     */
    public void setGbcePrice(double gbce_price) {
        this.gbce_price = gbce_price;
    }

}
