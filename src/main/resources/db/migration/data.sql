-- Insert data into tblManufacturer
INSERT INTO tblManufacturer (name, email, phone, address) VALUES
('Toyota Việt Nam', 'info@toyotavn.com', '0912345678', 'Số 15 Đường Trần Hưng Đạo, Hà Nội'),
('Ford Việt Nam', 'support@fordvietnam.vn', '0987654321', 'Số 20 Đường Nguyễn Huệ, TP. HCM'),
('Honda Việt Nam', 'contact@hondavn.vn', '0909090909', 'Số 10 Đường Lê Lợi, Đà Nẵng');

-- Insert data into tblCarModel
INSERT INTO tblCarModel (year, fuelType, color, seatNum, gearBoxType, modelName, tblManufacturerid) VALUES
('2022', 'Xăng', 'Đỏ', 5, 'Tự động', 'Toyota Camry', 1),
('2021', 'Dầu', 'Xanh', 7, 'Số tay', 'Ford Everest', 2),
('2023', 'Điện', 'Trắng', 5, 'Tự động', 'Honda City', 3),
('2020', 'Xăng', 'Đen', 5, 'Tự động', 'Toyota Corolla', 1),
('2019', 'Dầu', 'Xám', 4, 'Số tay', 'Ford Ranger', 2);

-- Insert data into tblCar
INSERT INTO tblCar (dailyRate, status, createdAt, updatedAt, rentalPricePerDay, maxHourRent, license, tblCarModelid) VALUES
(800000, 'Có sẵn', '2024-01-01', '2024-01-05', 850000.00, 24.0, '30A-12345', 1),
(1200000, 'Đã thuê', '2024-02-01', '2024-02-10', 1250000.00, 12.0, '51B-67890', 2),
(900000, 'Có sẵn', '2024-03-01', '2024-03-05', 950000.00, 24.0, '43C-11223', 3),
(600000, 'Có sẵn', '2024-01-15', '2024-01-20', 650000.00, 24.0, '29D-44556', 4),
(1100000, 'Đã thuê', '2024-02-15', '2024-02-20', 1150000.00, 12.0, '30F-77889', 5);

-- Insert data into tblDamageDetail
INSERT INTO tblDamageDetail (createdAt, isFixed, damageDescription, tblCarid, tblCarid2) VALUES
('2024-01-06', 0, 'Trầy xước ở cản trước', 1, NULL),
('2024-02-11', 1, 'Đèn hậu bị vỡ', 2, NULL),
('2024-03-06', 0, 'Lốp xe bị xẹp', 3, NULL),
('2024-01-20', 1, 'Kính chắn gió bị nứt', 4, NULL),
('2024-02-25', 0, 'Móp ở cửa xe bên trái', 5, NULL);

-- Insert data into tblClient
INSERT INTO tblClient (name, phone, email, identityNum, createdAt, dob) VALUES
('Nguyễn Văn An', '0978123456', 'an.nguyen@example.com', 'IDVN123456', '2024-01-01', '1990-01-15'),
('Lê Thị Hoa', '0987654321', 'hoa.le@example.com', 'IDVN654321', '2024-02-01', '1985-02-20'),
('Trần Văn Bình', '0912345678', 'binh.tran@example.com', 'IDVN112233', '2024-03-01', '1975-03-30'),
('Phạm Thị Thu', '0909876543', 'thu.pham@example.com', 'IDVN445566', '2024-04-01', '1982-04-10'),
('Vũ Minh Châu', '0932112233', 'chau.vu@example.com', 'IDVN778899', '2024-05-01', '1995-05-25');

-- Insert data into tblEmployee
INSERT INTO tblEmployee (name, dob, role, phoneNum, address, createdAt, email) VALUES
('Nguyễn Thị Lan', '1988-04-04', 'Quản lý', '0923344556', 'Số 50 Đường Hoàng Hoa Thám, Hà Nội', '2023-12-01', 'lan.nguyen@example.com'),
('Trần Minh Đức', '1992-05-05', 'Nhân viên bán hàng', '0916677889', 'Số 30 Đường Võ Văn Kiệt, TP. HCM', '2023-12-02', 'duc.tran@example.com'),
('Phạm Văn Hùng', '1995-06-06', 'Kỹ thuật viên', '0907788990', 'Số 10 Đường Bạch Đằng, Đà Nẵng', '2023-12-03', 'hung.pham@example.com');

-- Insert data into tblContract
INSERT INTO tblContract (contractName, startDate, endDate, createdAt, tblClientid, tblEmployeeid) VALUES
('Hợp đồng thuê xe #1', '2024-01-05', '2024-01-10', '2024-01-01', 1, 1),
('Hợp đồng thuê xe #2', '2024-02-10', '2024-02-15', '2024-02-05', 2, 2),
('Hợp đồng thuê xe #3', '2024-03-05', '2024-03-10', '2024-03-01', 3, 3),
('Hợp đồng thuê xe #4', '2024-04-05', '2024-04-15', '2024-04-01', 4, 1),
('Hợp đồng thuê xe #5', '2024-05-05', '2024-05-15', '2024-05-01', 5, 2);

-- Insert data into tblPayment
INSERT INTO tblPayment (paymentMethod, paymentStatus, paymentDate, tblContractid) VALUES
('Thẻ tín dụng', 'Hoàn tất', '2024-01-06', 1),
('Tiền mặt', 'Chưa thanh toán', '2024-02-12', 2),
('Chuyển khoản', 'Hoàn tất', '2024-03-06', 3),
('Ví điện tử', 'Đang chờ', '2024-04-06', 4),
('Thẻ ghi nợ', 'Hoàn tất', '2024-05-06', 5);

-- Insert data into tblContractDetail
INSERT INTO tblContractDetail (overKmFee, overNightFee, holidayFee, overHourFee, status, tblCarid, tblContractid) VALUES
(1000, 50000, 80000, 20000, 'Hoạt động', 1, 1),
(1500, 60000, 90000, 25000, 'Đã kết thúc', 2, 2),
(2000, 70000, 100000, 30000, 'Hoạt động', 3, 3),
(1200, 55000, 85000, 22000, 'Đã kết thúc', 4, 4),
(1800, 65000, 95000, 27000, 'Hoạt động', 5, 5);
