-- Copyright 2017 Miguel Vale Teixeira

-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at

-- http://www.apache.org/licenses/LICENSE-2.0

-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.

-- @author: Miguel Vale Teixeira
-- @data: 2017/03/16
--
-- This source code is intended for educational and illustrative purposes only
-- and is provided AS-IS without warranty of any kind.

-- ********************************************************************************
-- *                       		   TABLES                             	          *
-- ******************************************************************************** 
CREATE TABLE stocktrade ( 

	st_id BIGINT NOT NULL,
	st_symbol VARCHAR(10),
	st_date DATE,
	st_quantity NUMERIC(9,3),
	st_sales VARCHAR(60),
	st_price NUMERIC(9,3)
	
);

CREATE TABLE gbce ( 

	gbce_id BIGINT NOT NULL,
	gbce_symbol VARCHAR(10),
	gbce_type VARCHAR(60),
	gbce_last_dividend NUMERIC(9,3),
	gbce_fixed_dividend NUMERIC(9,3),
	gbce_value NUMERIC(9,3),
	gbce_price NUMERIC(9,3)
	
);

-- ********************************************************************************
-- *                       		   CONSTRAINTS PRIMARY KEY                        *
-- ********************************************************************************

ALTER TABLE stocktrade
	ADD CONSTRAINT pkstId
	PRIMARY KEY (st_id);
	
ALTER TABLE gbce
	ADD CONSTRAINT pkgbId
	PRIMARY KEY (gbce_id);
    
-- ********************************************************************************
-- *                       		   CONSTRAINTS SEQUENCE                           *
-- ********************************************************************************  
    
CREATE SEQUENCE seqStocktrade
    INCREMENT BY 1 
    START WITH 1 
    MINVALUE 1
;

CREATE SEQUENCE seqGbce
    INCREMENT BY 1 
    START WITH 1 
    MINVALUE 1
;

-- ********************************************************************************
-- *                       		   SOME DATA                             	      *
-- ********************************************************************************
INSERT INTO gbce VALUES (nextval('seqGbce'), 'TEA', 'Common', 0.00, 0.00, 100.00);
INSERT INTO gbce VALUES (nextval('seqGbce'), 'POP', 'Common', 8.00, 0.00, 100.00);
INSERT INTO gbce VALUES (nextval('seqGbce'), 'ALE', 'Common', 23.00, 0.00, 60.00);
INSERT INTO gbce VALUES (nextval('seqGbce'), 'GIN', 'Preferred', 8.00, 2.00, 100.00);
INSERT INTO gbce VALUES (nextval('seqGbce'), 'JOE', 'Common', 13.00, 0.00, 250.00);