# Payment-Service
> Spring Cloud를 이용한 프로젝트입니다.

## 목차
- [Dependency](#-dependency) <br>
- [Email Service 기능](#-auth-service-기능) <br>
- [Service Architecture](#-service-architecture) <br>
                                                

## 🛠️ Dependency

|           기능           | 기술 스택                                               |
|:--------------------:|:------------------------------------------------------|
|      Spring Boot      | - Spring Framework 2.7.14<br> - Java 17 <br> - Gradle 8.0 |
|     Spring Cloud      | - Eureka <br> - Config |
|  Kafka  | - Confluent Kafka 7.4.0 <br>- Zookeeper 7.4.0                          |


## 📝 Email Service 기능

|       기능       | 내용                                                     |
|:--------------:|:-------------------------------------------------------|
|      낙찰된 상품 결제 시스템     | 협업 은행사의 API를 호출을 통하여 낙찰된 상품에 대한 금액을 반환받는다.                   |



## 🧩 Service Architecture
<img width="1618" alt="Architect (2) 복사본" src="https://github.com/wooriFisa-Final-Project-F4/.github/assets/109801772/27ac2b1d-8624-424f-aefb-4ceda4484b63">
