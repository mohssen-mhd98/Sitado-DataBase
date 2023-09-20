use db_final_project;
CREATE DEFINER=`root`@`localhost` TRIGGER `address_AFTER_INSERT` AFTER INSERT ON `address` FOR EACH ROW BEGIN
insert into address_log values(curdate(),'insert',NEW.address_id);
SET SQL_SAFE_UPDATES = 0;
delete from address_log where `time` < curdate()-2;
END;

CREATE DEFINER=`root`@`localhost` TRIGGER `address_AFTER_UPDATE` AFTER UPDATE ON `address` FOR EACH ROW BEGIN
insert into address_log values(curdate(),'update',NEW.address_id);
SET SQL_SAFE_UPDATES = 0;
delete from address_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `address_AFTER_DELETE` AFTER DELETE ON `address` FOR EACH ROW BEGIN
insert into address_log values(curdate(),'delete',OLD.address_id);
SET SQL_SAFE_UPDATES = 0;
delete from address_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `contains_AFTER_INSERT` AFTER INSERT ON `contains` FOR EACH ROW BEGIN
insert into contains_log values(curdate(),'insert',NEW.factor_FoodFactor_number,NEW.order_FoodFood_price,NEW.order_FoodFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from contains_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `contains_AFTER_UPDATE` AFTER UPDATE ON `contains` FOR EACH ROW BEGIN
insert into contains_log values(curdate(),'insert',NEW.factor_FoodFactor_number,NEW.order_FoodFood_price,NEW.order_FoodFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from contains_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `contains_AFTER_DELETE` AFTER DELETE ON `contains` FOR EACH ROW BEGIN
insert into contains_log values(curdate(),'insert',OLD.factor_FoodFactor_number,OLD.order_FoodFood_price,OLD.order_FoodFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from contains_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `customer_AFTER_INSERT` AFTER INSERT ON `customer` FOR EACH ROW BEGIN
insert into customer_log values(curdate(),'insert',NEW.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from customer_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `customer_AFTER_UPDATE` AFTER UPDATE ON `customer` FOR EACH ROW BEGIN
insert into customer_log values(curdate(),'update',NEW.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from customer_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `customer_AFTER_DELETE` AFTER DELETE ON `customer` FOR EACH ROW BEGIN
insert into customer_log values(curdate(),'delete',OLD.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from customer_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `delivery_AFTER_INSERT` AFTER INSERT ON `delivery` FOR EACH ROW BEGIN
insert into delivey_log values(curdate(),'insert',NEW.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from delivery_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `delivery_AFTER_UPDATE` AFTER UPDATE ON `delivery` FOR EACH ROW BEGIN
insert into delivey_log values(curdate(),'update',NEW.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from delivery_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `delivery_AFTER_DELETE` AFTER DELETE ON `delivery` FOR EACH ROW BEGIN
insert into delivery_log values(curdate(),'delete',OLD.national_code);
SET SQL_SAFE_UPDATES = 0;
delete from delivery_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_AFTER_INSERT` AFTER INSERT ON `factor_food` FOR EACH ROW BEGIN
insert into factor_food_log values(curdate(),'insert',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_AFTER_UPDATE` AFTER UPDATE ON `factor_food` FOR EACH ROW BEGIN
insert into factor_food_log values(curdate(),'update',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_AFTER_DELETE` AFTER DELETE ON `factor_food` FOR EACH ROW BEGIN
insert into factor_food_log values(curdate(),'delete',OLD.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_log where `time` < curdate();
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_withname_AFTER_INSERT` AFTER INSERT ON `factor_food_withname` FOR EACH ROW BEGIN
insert into factor_food_withname_log values(curdate(),'insert',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_withname_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_withname_AFTER_UPDATE` AFTER UPDATE ON `factor_food_withname` FOR EACH ROW BEGIN
insert into factor_food_withname_log values(curdate(),'update',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_withname_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_food_withname_AFTER_DELETE` AFTER DELETE ON `factor_food_withname` FOR EACH ROW BEGIN
insert into factor_food_withname_log values(curdate(),'delete',OLD.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_food_withname_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_ingredients_AFTER_INSERT` AFTER INSERT ON `factor_ingredients` FOR EACH ROW BEGIN
insert into factor_ingredients_log values(curdate(),'insert',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_ingredients_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_ingredients_AFTER_UPDATE` AFTER UPDATE ON `factor_ingredients` FOR EACH ROW BEGIN
insert into factor_ingredients_log values(curdate(),'update',NEW.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_ingredients_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `factor_ingredients_AFTER_DELETE` AFTER DELETE ON `factor_ingredients` FOR EACH ROW BEGIN
insert into factor_ingredients_log values(curdate(),'delete',OLD.factor_number);
SET SQL_SAFE_UPDATES = 0;
delete from factor_ingredients_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `menu_AFTER_INSERT` AFTER INSERT ON `menu` FOR EACH ROW BEGIN
insert into menu_log values(curdate(),'insert',NEW.food_name);
SET SQL_SAFE_UPDATES = 0;
delete from menu_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `menu_AFTER_UPDATE` AFTER UPDATE ON `menu` FOR EACH ROW BEGIN
insert into menu_log values(curdate(),'update',NEW.food_name);
SET SQL_SAFE_UPDATES = 0;
delete from menu_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `menu_AFTER_DELETE` AFTER DELETE ON `menu` FOR EACH ROW BEGIN
insert into menu_log values(curdate(),'delete',OLD.food_name);
SET SQL_SAFE_UPDATES = 0;
delete from menu_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_food_AFTER_INSERT` AFTER INSERT ON `order_food` FOR EACH ROW BEGIN
insert into order_food values(curdate(),'insert',NEW.food_name,NEW.price,NEW.menuFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from order_food where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_food_AFTER_UPDATE` AFTER UPDATE ON `order_food` FOR EACH ROW BEGIN
insert into order_food_log values(curdate(),'update',NEW.food_name,NEW.price,NEW.menuFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from order_food_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_food_AFTER_DELETE` AFTER DELETE ON `order_food` FOR EACH ROW BEGIN
insert into order_food_log values(curdate(),'delete',OLD.food_name,OLD.price,OLD.menuFood_name);
SET SQL_SAFE_UPDATES = 0;
delete from order_food_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_ingredients_AFTER_INSERT` AFTER INSERT ON `order_ingredients` FOR EACH ROW BEGIN
insert into order_ingredients_log values(curdate(),'insert',NEW.ingrideint_name,NEW.ingredient_price);
SET SQL_SAFE_UPDATES = 0;
delete from order_ingredients_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_ingredients_AFTER_UPDATE` AFTER UPDATE ON `order_ingredients` FOR EACH ROW BEGIN
insert into order_ingredients values(curdate(),'update',NEW.ingrideint_name,NEW.ingredient_price);
SET SQL_SAFE_UPDATES = 0;
delete from order_ingredients where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `order_ingredients_AFTER_DELETE` AFTER DELETE ON `order_ingredients` FOR EACH ROW BEGIN
insert into order_ingredients_log values(curdate(),'insert',OLD.ingrideint_name,OLD.ingredient_price);
SET SQL_SAFE_UPDATES = 0;
delete from order_ingredients_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `store_AFTER_INSERT` AFTER INSERT ON `store` FOR EACH ROW BEGIN
insert into store_log values(curdate(),'insert',NEW.store_name);
SET SQL_SAFE_UPDATES = 0;
delete from store_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `store_AFTER_UPDATE` AFTER UPDATE ON `store` FOR EACH ROW BEGIN
insert into store_log values(curdate(),'update',NEW.store_name);
SET SQL_SAFE_UPDATES = 0;
delete from store_log where `time` < curdate()-2;
END;
CREATE DEFINER=`root`@`localhost` TRIGGER `store_AFTER_DELETE` AFTER DELETE ON `store` FOR EACH ROW BEGIN
insert into store_log values(curdate(),'insert',OLD.store_name);
SET SQL_SAFE_UPDATES = 0;
delete from store_log where `time` < curdate()-2;
END;