DROP TABLE IF EXISTS "tbl_user_purchases";  
DROP TABLE IF EXISTS "tbl_users";  

CREATE TABLE "tbl_users" (  
"id" INT AUTO_INCREMENT  PRIMARY KEY,  
"username" VARCHAR(50) NOT NULL
); 

CREATE TABLE "tbl_user_purchases" (  
"id" INT AUTO_INCREMENT  PRIMARY KEY,  
"user_id" int NOT NULL,  
"transaction_amount" NUMERIC(8,2) NOT NULL,
"transaction_date" date not null,
"reward_points" int
);
