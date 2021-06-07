CREATE TABLE users.users (
  id bigint auto_increment NOT NULL,
  name NVarChar(255) varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  document NVarChar(255) varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  phone longtext NOT NULL,
  adress NVarChar(255) varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  cep longtext NOT NULL,
  password NVarChar(255) varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (id)
  )

