create table PRICES (
    BRAND_ID INT NOT NULL,
    START_DATE DATETIME NOT NULL,
    END_DATE DATETIME NOT NULL,
    PRICE_LIST INT NOT NULL,
    PRODUCT_ID  VARCHAR(20) NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE NUMERIC NOT NULL,
    CURR VARCHAR(5) NOT NULL
    
);