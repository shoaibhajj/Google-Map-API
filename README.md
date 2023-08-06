# Google-Map-API
Semulate 🚗
Semulate is a web app that simulates Google Map API services using distributed systems. It allows users to search for locations, get directions, view traffic, and explore nearby places. 🗺️

Features ✨
Semulate uses service registry to register and discover microservices that provide different functionalities. 🔎
Semulate uses load balancing to distribute the workload among the microservices and improve the performance and availability of the app. ⚖️
Semulate uses RabbitMQ as a message broker to enable asynchronous communication between the microservices. 🐰
Semulate uses Zipkin to collect and visualize the traces of the requests across the microservices. 📈
Semulate uses Hystrix as a circuit breaker to handle failures and fallbacks in the microservices. ⚡
Installation 💻
To run Semulate locally, you need to have the following tools installed:

Java 11 or higher ☕
Maven 🏗️
Docker 🐳
Docker Compose 🎼
Then, follow these steps:

Clone this repository: git clone https://github.com/yourusername/semulate.git 📥
Navigate to the project directory: cd semulate 📂
Build the microservices: mvn clean package 🛠️
Run the docker containers: docker-compose up -d 🚀
Usage 🖥️
Once the docker containers are running, you can access the web app at http://localhost:8080. You can also access the following endpoints:

Service registry: http://localhost:8761 📋
Zipkin: http://localhost:9411 🔬
Hystrix dashboard: http://localhost:7979 📊
License 📝
Semulate is licensed under the MIT License. See LICENSE file for more details
