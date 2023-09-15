use tutorialspoint;

SELECT avg(amount) FROM orders;

SELECT c.name, o.amount
FROM customers c
JOIN orders o
ON (c.id = o.customer_id)
WHERE o.amount >= 2000;
--WHERE o.amount >= (SELECT avg(amount) FROM orders);
