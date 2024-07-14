# Order Manager

Order Manager is a Spring Boot application designed to optimize the process of writing production orders (lists of completed works) at a metal structures plant. The application allows employees to create orders, which are then reviewed by supervisors and controllers in their personal accounts.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)
- [Описание на русском](#описание-на-русском)

## Features

- Employee order creation: Employees can create production orders detailing the work they have completed.
- Supervisor and controller review: Supervisors and controllers can review and verify orders in their personal accounts.
- Secure authentication and role-based access control.
- User-friendly interface for order creation and review.
- Validation and error handling for data integrity.
- Responsive design using Thymeleaf for rendering views.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8.1 or higher
- A database (e.g., MySQL, PostgreSQL)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Efreh/order-manager.git
    cd order-manager
    ```

2. Configure the database:

    Update the `application.properties` file with your database connection details.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/order_manager
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the application:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. Access the application:

    Open your browser and navigate to `http://localhost:8080`.

## Usage

### Creating Orders

1. Log in with your employee account.
2. Navigate to the "Create Order" page.
3. Fill out the order form with the details of the completed work.
4. Submit the form to create the order.

### Reviewing Orders

1. Log in with your supervisor or controller account.
2. Navigate to the "Review Orders" page.
3. Select an order to review.
4. Verify the details of the order and approve or reject it as necessary.

## Technologies

- Spring Boot 3.3.0
- Thymeleaf
- Spring Data JPA
- Spring Security
- Hibernate
- Maven
- MySQL (or any other relational database)

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Описание на русском

Order Manager - это приложение на Spring Boot, предназначенное для оптимизации процесса написания производственных нарядов (список выполненных работ) на заводе металлоконструкций. Приложение позволяет сотрудникам создавать наряды, которые затем проверяются мастерами и контролёрами в их личных кабинетах.

### Особенности

- Создание нарядов сотрудниками: сотрудники могут создавать производственные наряды, подробно описывающие выполненную работу.
- Проверка нарядов мастерами и контролёрами: мастера и контролёры могут проверять и утверждать наряды в своих личных кабинетах.
- Безопасная аутентификация и контроль доступа на основе ролей.
- Удобный интерфейс для создания и проверки нарядов.
- Валидация и обработка ошибок для обеспечения целостности данных.
- Адаптивный дизайн с использованием Thymeleaf для рендеринга представлений.

### Начало работы

#### Требования

- Java 17 или выше
- Maven 3.8.1 или выше
- База данных (например, MySQL, PostgreSQL)

#### Установка

1. Клонируйте репозиторий:

    ```bash
    git clone https://github.com/Efreh/order-manager.git
    cd order-manager
    ```

2. Настройте базу данных:

    Обновите файл `application.properties` с данными для подключения к вашей базе данных.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/order_manager
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Соберите и запустите приложение:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. Доступ к приложению:

    Откройте браузер и перейдите по адресу `http://localhost:8080`.

### Использование

#### Создание нарядов

1. Войдите в систему с учетной записью сотрудника.
2. Перейдите на страницу "Создание наряда".
3. Заполните форму наряда деталями выполненной работы.
4. Отправьте форму для создания наряда.

#### Проверка нарядов

1. Войдите в систему с учетной записью мастера или контролёра.
2. Перейдите на страницу "Проверка нарядов".
3. Выберите наряд для проверки.
4. Проверьте детали наряда и утвердите или отклоните его при необходимости.

### Технологии

- Spring Boot 3.3.0
- Thymeleaf
- Spring Data JPA
- Spring Security
- Hibernate
- Maven
- MySQL (или любая другая реляционная база данных)

### Участие

Будем рады вашим вкладом! Пожалуйста, форкните репозиторий и отправьте запрос на слияние с вашими изменениями.

1. Форкните репозиторий
2. Создайте вашу ветку с новой функциональностью (`git checkout -b feature/AmazingFeature`)
3. Зафиксируйте ваши изменения (`git commit -m 'Add some AmazingFeature'`)
4. Отправьте ветку на удаленный репозиторий (`git push origin feature/AmazingFeature`)
5. Откройте запрос на слияние

### Лицензия

Этот проект лицензирован по лицензии MIT. Смотрите файл [LICENSE](LICENSE) для получения подробной информации.
