spring boot = 3.3.2
database = mysql5.8.32


t_product(p_id, p_name, value, quantity)

t_product_data(prod_data_id, p_id, p_name, value, date, p_quantity)



1. USP_ProductDataManage

create
definer = root@localhost procedure USP_ProductDataManage2(IN prstype varchar(10), IN Pprod_data_id varchar(20),
IN Pp_id varchar(5), IN Pp_name varchar(250),
IN Pvalue varchar(20), IN Pp_quantity varchar(20),
IN Pp_DATE1 varchar(250), IN Pp_DATE2 varchar(250))
BEGIN
IF prstype = 'S1' THEN
SELECT p_id as prod_data_id, p_id,p_name, value, SUM(p_quantity) as p_quantity, p_id as date  FROM t_product_data WHERE DATE >= Pp_DATE1 AND DATE <= Pp_DATE2 GROUP BY p_id,p_name, value;
END IF;
END;

2. USP_ProductDataManage2

create
definer = root@localhost procedure USP_ProductDataManage2(IN prstype varchar(10), IN Pprod_data_id varchar(20),
IN Pp_id varchar(5), IN Pp_name varchar(250),
IN Pvalue varchar(20), IN Pp_quantity varchar(20),
IN Pp_DATE1 varchar(250), IN Pp_DATE2 varchar(250))
BEGIN
IF prstype = 'S1' THEN
SELECT p_id as prod_data_id, p_id,p_name, value, SUM(p_quantity) as p_quantity, p_id as date  FROM t_product_data WHERE DATE >= Pp_DATE1 AND DATE <= Pp_DATE2 GROUP BY p_id,p_name, value;
END IF;
END;

3. USP_ProductManage

create
definer = root@localhost procedure USP_ProductManage(IN prstype varchar(10), IN Pp_id varchar(5),
IN Pp_name varchar(250), IN Pvalue varchar(20),
IN Pp_quantity varchar(20))
BEGIN
DECLARE PARAM_EXIST INTEGER;
IF prstype = 'S1' THEN
SELECT * FROM t_product;
END IF;
IF prstype = 'U1' THEN
IF Pvalue = '' THEN
UPDATE t_product SET p_name = Pp_name WHERE p_id = Pp_id;
ELSEIF Pp_name = '' THEN
UPDATE t_product SET value = Pvalue WHERE p_id = Pp_id;
ELSE
UPDATE t_product SET p_name = Pp_name, value = Pvalue WHERE p_id = Pp_id;
END IF;
END IF;
IF prstype = 'I1' THEN
SET PARAM_EXIST = EXISTS (SELECT * FROM t_product WHERE p_id = Pp_id);
IF PARAM_EXIST = FALSE THEN
SET Pp_id := (SELECT MAX(p_id) FROM t_product);
IF Pp_id is null THEN
SET Pp_id = 0;
END IF;
SET Pp_id = Pp_id + 1;
INSERT INTO t_product VALUES (Pp_id, Pp_name, Pvalue, Pp_quantity);
ELSE
UPDATE t_product SET p_name = Pp_name, value = Pvalue, quantity = Pp_quantity WHERE p_id = Pp_id;
END IF;
END IF;
IF prstype = 'D1' THEN
DELETE FROM t_product WHERE p_id = Pp_id;
END IF;
END;

