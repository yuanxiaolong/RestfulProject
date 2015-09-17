## Demo - restful风格的后端工程骨架,避免重复劳动


---

## 结构

采用 jersey 和 spring 及 mybatis 组合


## build

* 本地环境  mvn clean package [-Plocal]
* 开发环境  mvn clean package -Pdev
* 生产环境  mvn clean package -Pproduct

---

## run

* 开发环境 ：``` java -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -jar restful-0.0.1-SNAPSHOT.jar ```
* 生产环境 : ``` nohup java -jar restful-0.0.1-SNAPSHOT.jar >> restfulRun.log 2>&1 & ```



default port: 8099

properties global.properties

---

## logs

log in ```./logs/demo-all.log```