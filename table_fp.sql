use db_final_project;
CREATE TABLE `address` (
  `address_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `phone` varchar(8) DEFAULT NULL,
  `customerNational_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `customerNational_code_idx` (`customerNational_code`),
  CONSTRAINT `customerNational_code` FOREIGN KEY (`customerNational_code`) REFERENCES `customer` (`national_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `address_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contains` (
  `factor_FoodFactor_number` int(11) NOT NULL,
  `order_FoodFood_name` varchar(50) NOT NULL,
  `order_FoodFood_price` int(11) NOT NULL,
  `numberOfOrder` int(11) NOT NULL,
  KEY `order_FoodFood_price_idx` (`order_FoodFood_price`),
  KEY `factor_FoodFactor_number2_idx` (`factor_FoodFactor_number`),
  KEY `order_FoodFood_name2_idx` (`order_FoodFood_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contains_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `factor_FoodFactor_number` int(11) NOT NULL,
  `order_FoodFood_price` int(11) NOT NULL,
  `order_FoodFood_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `national_code` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `mobile_phone` varchar(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`national_code`),
  UNIQUE KEY `mobile_phone_UNIQUE` (`mobile_phone`),
  KEY `cust_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer_log` (
  `time` datetime NOT NULL,
  `actione` varchar(10) NOT NULL,
  `customerNational_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `delivery` (
  `national_code` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `mobile_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`national_code`),
  UNIQUE KEY `mobile_phone_UNIQUE` (`mobile_phone`),
  UNIQUE KEY `national_code_UNIQUE` (`national_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `delivery_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) DEFAULT NULL,
  `national_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factor_food_log` (
  `time` datetime DEFAULT NULL,
  `action` varchar(10) DEFAULT NULL,
  `factor_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factor_food_withname` (
  `factor_number` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `address_id` int(10) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `customerNational_code` varchar(10) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `deliveryNational_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`factor_number`),
  KEY `customerNational_code21_idx` (`customerNational_code`),
  KEY `addressid2_idx` (`address_id`),
  KEY `customer_name_idx` (`customer_name`),
  CONSTRAINT `addressid2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customerNational_code21` FOREIGN KEY (`customerNational_code`) REFERENCES `customer` (`national_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_name` FOREIGN KEY (`customer_name`) REFERENCES `customer` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factor_food_withname_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `factor_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factor_ingredients` (
  `factor_number` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `storeStore_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`factor_number`),
  KEY `storeStore_name_idx` (`storeStore_name`),
  CONSTRAINT `storeStore_name` FOREIGN KEY (`storeStore_name`) REFERENCES `store` (`store_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `factor_ingredients_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `factor_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `include_ingredients` (
  `factor_ingredientsFactor_num` int(11) NOT NULL,
  `order_ingridientIngridient_name` varchar(20) NOT NULL,
  `order_ingridientIngridient_price` int(11) NOT NULL,
  `numberOfOrder` int(11) NOT NULL,
  PRIMARY KEY (`factor_ingredientsFactor_num`,`order_ingridientIngridient_name`,`order_ingridientIngridient_price`),
  CONSTRAINT `factor_ingredientsFactor_num` FOREIGN KEY (`factor_ingredientsFactor_num`) REFERENCES `factor_ingredients` (`factor_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `include_ingredients_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `factor_ingredientsFactor_number` int(11) NOT NULL,
  `order_ingridientsIngredient_name` varchar(20) NOT NULL,
  `order_ingridientsIngredient_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `menu` (
  `food_name` varchar(50) NOT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `menu_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `food_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_food` (
  `food_name` varchar(50) NOT NULL,
  `menuFood_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`food_name`,`menuFood_name`,`price`),
  KEY `price_1_idx` (`price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_food_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `menuFood_name` varchar(50) NOT NULL,
  PRIMARY KEY (`action`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `order_ingredients` (
  `ingrideint_name` varchar(20) NOT NULL,
  `ingredient_price` int(11) NOT NULL,
  PRIMARY KEY (`ingrideint_name`,`ingredient_price`),
  KEY `ingredient_price11_idx` (`ingredient_price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_ingredients_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `ingrideint_name` varchar(20) NOT NULL,
  `ingredient_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `store` (
  `store_name` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`store_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `store_log` (
  `time` datetime NOT NULL,
  `action` varchar(10) NOT NULL,
  `store_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





