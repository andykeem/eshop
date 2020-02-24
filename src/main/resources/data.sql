INSERT INTO category(id, name, image, url, created_at, updated_at) VALUES (1, 'New Products', '', 'new-products.html', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO product(id, sku, name, image, url, price, created_at, updated_at) VALUES (1, 'msj012c', 'Linen Blazer', '/m/s/msj012t_2.jpg', 'linen-blazer-585.html', 455.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO product(id, sku, name, image, url, price, created_at, updated_at) VALUES (2, 'mtk000c', 'Chelsea Tee', '/m/t/mtk000t.jpg', 'chelsea-tee-718.html', 75.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO product(id, sku, name, image, url, price, created_at, updated_at) VALUES (3, 'wbk003c', 'Tori Tank', '/w/b/wbk003t.jpg', 'tori-tank-590.html', 60.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO product(id, sku, name, image, url, price, created_at, updated_at) VALUES (4, 'wbk012c', 'Elizabeth Knit Top', '/w/b/wbk012t.jpg', 'elizabeth-knit-top-596.html', 210.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO product(id, sku, name, image, url, price, created_at, updated_at) VALUES (5, 'wsd013c', 'Lafayette Convertible Dress', '/w/s/wsd013t.jpg', 'lafayette-convertible-dress.html', 340.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO category_product(category_id, product_id) VALUES(1, 1);
INSERT INTO category_product(category_id, product_id) VALUES(1, 2);
INSERT INTO category_product(category_id, product_id) VALUES(1, 3);
INSERT INTO category_product(category_id, product_id) VALUES(1, 4);
INSERT INTO category_product(category_id, product_id) VALUES(1, 5);