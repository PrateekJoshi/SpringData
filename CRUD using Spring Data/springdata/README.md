## Learning Spring Data

### Simple CRUD operations

#### Steps

1) Create the Entities

	- Mark them with JPA annotations

2) Create the Repositories

3) Configure the Data Source

	- Configure in applications.properties file	

* application.properties

```
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=root
    spring.datasource.password=password
```

4) Test CRUD operations using JUnit test cases.