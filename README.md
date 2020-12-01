# adventureworks-products
Microservicio para gestión de productos de Adventure Works

## Docker deploy

docker build -t ms-adventure-works-products .

docker run -d --name ms-adventure-works-products -p 8081:8080 ms-adventure-works-products