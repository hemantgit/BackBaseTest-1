# BackBaseTest
## Install
This project is maven based and can be easily installed with the following command:
```
mvn install
```
The output is a war file that can be deployed on any Servlet 3.0 Container including Tomcat 7.0+ and Jetty 8.0+. Apart from Maven, JDK 7 or 8 is also required. The IDE that is used is Eclipse. However, the project can be imported in other IDEs like IntelliJ IDEA.
## Services
3 REST services are exposed in this project:
* Transaction List

URL: <Context-Root>/api/v1/current-accounts/{accountId}/transactions/{QueryString}
Supported Query String parameters are: amountRangeFrom, amountRangeTo, counterpartyAccountNumber, query, categoryIds (comma separated), dateRangeFrom (long), dateRangeTo (long), sort (start with '-' for Descending), from, length

* Transaction filter based on transaction type

URL: <Context-Root>/api/v1/current-accounts/{accountId}/transactions/{TransactionType}
* Total amount for transaction type

URL: <Context-Root>/api/v1/current-accounts/{accountId}/transactions/{TransactionType}/total

Since there are amounts of various currencies, the output of this service is a Map with currencies as keys and total amount of each currency as value.
