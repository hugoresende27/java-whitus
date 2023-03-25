# this is a simple java aplication to interact with fibonacci sequence

### https://start.spring.io/    used
### Dependencies
- Spring Web
- Thymeleaf (template engine)
- Spring Boot Dev

###  tutorial 
 - https://www.youtube.com/playlist?list=PLGRDMO4rOGcMbku5WcvZ3I8GMH__qd3I2 (basic thymeleaf)

## to start project local dev server
- mvn spring-boot:run

# Notes
 - resources/static for assets like css and js
 - thymeleaf iteration th:each (Iterable, Map, arrays)
 - to automatically create table spring.jpa.hibernate.ddl-auto=update
 - ModelAndView (to map html elements and java class - Spring lib)
 - @DateTimeFormat pass double bracket's
 - on view to use {{}}
 - @GetMapping("/mylink/{id}") (@PathVariable("id") use to get params from url


------------------------------------------------------------------------
public class Desafio 
{

    //f(n)=f(n-1)+f(n-2)
    //f(0) = 0
    //f(1) = 1

    public static void main(String[] args) 
    {
        System.out.println(func1(47));
    }

    //  fib[i] = fib[i-1] + fib[i-2];
    public static BigInteger fibonnacci(int n) 
    {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        if (n == 0){
            return a;
        } else if(n == 1){
            return b;
        }
        for (int j = 2; j <= n; j++){
            c = a.add(b);
            a = b;
            b = c;
        }
            return (b);
    }

    //fibonacci
    //programa com frontend e backend para devolver a seq de fibonnaci

}


---------------------------------------------------------------------------
- API's Restful
- Application Programming Interface
- Representational State Transfer

#### MVC - Model View Controller
#### view - interface
#### model - data manipulation
#### controller

#### packages created/layers :
- models
- controllers
- services
- repositories
- config

##### Notes
- ?createDatabaseIfNotExist=true (to create DB)
- spring.jpa.hibernate.ddl-auto=update
1. update if not exist create
2. none does notting
3. create-drop create new every time
- spring.jpa.show-sql=true (to show all sql)
- spring-boot-starter-validation (to add validation annotations)

### mvn clean install
### mvn spring-boot:run