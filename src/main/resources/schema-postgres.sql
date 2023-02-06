CREATE TABLE IF NOT EXISTS Allergy(
    id SERIAL PRIMARY KEY,
    allergy_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Category(
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    en_name VARCHAR(100),
    category_id INTEGER REFERENCES Category(id),
    description VARCHAR(500),
    kcal INTEGER,
    salt INTEGER,
    sugar INTEGER,
    fat INTEGER,
    protein INTEGER,
    caffeine INTEGER,
    img_url VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS ProductAllergy(
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES Product(id),
    allergy_id INTEGER REFERENCES Allergy(id)
 );

CREATE TABLE IF NOT EXISTS Tag(
    id SERIAL PRIMARY KEY,
    tag_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS ProductTag(
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES Product(id),
    tag_id INTEGER REFERENCES Tag(id)
);

CREATE TABLE IF NOT EXISTS Users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    userid VARCHAR(20),
    userpw VARCHAR(100),
    birth INTEGER,
    email VARCHAR(50),
    phonenumber VARCHAR(11)
);