-- Table: tblManufacturer
CREATE TABLE IF NOT EXISTS tblManufacturer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255)
);

-- Table: tblCarModel
CREATE TABLE IF NOT EXISTS tblCarModel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    year VARCHAR(10),
    fuelType VARCHAR(255),
    color VARCHAR(255),
    seatNum INT,
    gearBoxType VARCHAR(255),
    modelName VARCHAR(255),
    tblManufacturerid INT,
    FOREIGN KEY (tblManufacturerid) REFERENCES tblManufacturer(id) ON DELETE SET NULL
);

-- Table: tblCar
CREATE TABLE IF NOT EXISTS tblCar (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dailyRate INT,
    status VARCHAR(50),
    createdAt DATE,
    updatedAt DATE,
    rentalPricePerDay FLOAT,
    maxHourRent FLOAT,
    license VARCHAR(255),
    tblCarModelid INT,
    FOREIGN KEY (tblCarModelid) REFERENCES tblCarModel(id) ON DELETE SET NULL
);

-- Table: tblDamageDetail
CREATE TABLE IF NOT EXISTS tblDamageDetail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    createdAt DATE,
    isFixed INT,
    damageDescription VARCHAR(255),
    tblCarid INT,
    tblCarid2 INT,
    FOREIGN KEY (tblCarid) REFERENCES tblCar(id) ON DELETE SET NULL,
    FOREIGN KEY (tblCarid2) REFERENCES tblCar(id) ON DELETE SET NULL
);


-- Table: tblClient
CREATE TABLE IF NOT EXISTS tblClient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    phone VARCHAR(50),
    email VARCHAR(255),
    identityNum VARCHAR(50),
    createdAt DATE,
    dob VARCHAR(50)
);

CREATE TABLE tblEmployee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL,
  dob VARCHAR(50),
  phoneNum VARCHAR(20),
  address VARCHAR(255),
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Table: tblContract
CREATE TABLE IF NOT EXISTS tblContract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    contractName VARCHAR(255),
    startDate DATE,
    endDate DATE,
    createdAt DATE,
    tblClientid INT,
    tblEmployeeid INT,
    FOREIGN KEY (tblClientid) REFERENCES tblClient(id) ON DELETE SET NULL,
    FOREIGN KEY (tblEmployeeid) REFERENCES tblEmployee(id) ON DELETE SET NULL
);

-- Table: tblPayment
CREATE TABLE IF NOT EXISTS tblPayment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paymentMethod VARCHAR(50),
    paymentStatus VARCHAR(50),
    paymentDate DATE,
    tblContractid INT,
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id) ON DELETE SET NULL
);

-- Table: tblContractDetail
CREATE TABLE IF NOT EXISTS tblContractDetail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    overKmFee FLOAT,
    overNightFee FLOAT,
    holidayFee FLOAT,
    overHourFee FLOAT,
    status VARCHAR(50),
    tblCarid INT,
    tblContractid INT,
    FOREIGN KEY (tblCarid) REFERENCES tblCar(id) ON DELETE SET NULL,
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id) ON DELETE SET NULL
);


DROP TABLE IF EXISTS tblContractDetail;
DROP TABLE IF EXISTS tblPayment;
DROP TABLE IF EXISTS tblContract;
DROP TABLE IF EXISTS tblDamageDetail;
DROP TABLE IF EXISTS tblCar;
DROP TABLE IF EXISTS tblCarModel;
DROP TABLE IF EXISTS tblClient;
DROP TABLE IF EXISTS tblEmployee;
DROP TABLE IF EXISTS tblManufacturer;

DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;
