CREATE TABLE IF NOT EXISTS Payments (
    id INT AUTO_INCREMENT,
    order_id INT NOT NULL,
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('CONFIRMED', 'PROCESSING', 'CANCELLED') DEFAULT 'CONFIRMED',
    PRIMARY KEY (id)
);