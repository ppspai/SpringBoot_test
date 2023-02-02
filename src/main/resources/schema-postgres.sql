CREATE TABLE IF NOT EXISTS Allergy(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    enname VARCHAR(100),
    categoryid INTEGER REFERENCES Category(id),
    description VARCHAR(500),
    kcal INTEGER,
    salt INTEGER,
    sugar INTEGER,
    fat INTEGER,
    protein INTEGER,
    caffeine INTEGER,
    imgurl VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS ProductAllergy(
    id SERIAL PRIMARY KEY,
    productid INTEGER REFERENCES Product(id),
    allergyid INTEGER REFERENCES Allergy(id)
 );

CREATE TABLE IF NOT EXISTS Tag(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS ProductTag(
    id SERIAL PRIMARY KEY,
    productid INTEGER REFERENCES Product(id),
    tagid INTEGER REFERENCES Tag(id)
);



CREATE TABLE IF NOT EXISTS Users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    userid VARCHAR(20),
    userpw VARCHAR(20),
    birth INTEGER,
    email VARCHAR(50),
    phoneNumber VARCHAR(11)
);