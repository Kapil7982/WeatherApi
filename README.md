# WeatherApi

## Weather Forecast Application

This is a web application for retrieving weather forecast data based on user input. It provides two main functionalities: fetching a summary of the weather forecast and retrieving hourly forecast details.

### Requirements

- Java 8 or higher
- Maven
- RapidAPI Key
- OpenWeatherMap API Key

### Installation

1. Clone the repository to your local machine:

```bash
git clone https://github.com/Kapil7982/WeatherApi.git
```
2. Navigate to the project directory: cd weather-forecast-api
3. Create a new file named ```application.properties``` in the ```src/main/resources``` directory and add the following properties:
```bash
rapidapi.key=YOUR_RAPIDAPI_KEY
rapidapi.host=forecast9.p.rapidapi.com
openweathermap.api.key=YOUR_OPENWEATHERMAP_API_KEY
client.id=clientId1
client.secret=secreat1
```
### Install the required dependencies for the backend (Spring Boot):
```bash
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
</dependency>
<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
</dependency>
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
</dependency>
<dependency>
			<groupId>com.squareup.okhttp3</groupId>
			<artifactId>okhttp</artifactId>
			<version>4.9.3</version>
</dependency>
<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.13</version> 
</dependency>
```
4. Build the project: mvn clean install
5. Run the application: mvn spring-boot:run
6. The application will start running on http://localhost:8080.

### Endpoints
1. Get Forecast Summary by Location
```bash
GET /forecast/summary?locationName={locationName}
```
This endpoint retrieves the forecast summary for a given location using the RapidAPI Forecast9 API.

Headers:

```X-Client-ID```: A unique client ID (generated in the code).
```X-Client-Secret```: A unique client secret (generated in the code).
Query Parameters:

locationName: The name of the location for which you want to retrieve the forecast summary.

2. Get Hourly Forecast by City
```bash
GET /forecast/hourly/openweathermap?cityName={cityName}
```
This endpoint retrieves the hourly forecast for a given city using the OpenWeatherMap API.

Headers:

```X-Client-ID```: A unique client ID (generated in the code).
```X-Client-Secret```: A unique client secret (generated in the code).
Query Parameters:

cityName: The name of the city for which you want to retrieve the hourly forecast.

## Frontend (Make sure the backend is running)
HTML and CSS Files
The project includes an HTML file (```index.html```) and a CSS file (```styles.css```) (in src/main/resources/static) that provides a basic user interface for interacting with the weather forecast API. The HTML file contains two input fields: one for entering the city name and two buttons for fetching the forecast summary and hourly forecast, respectively. The results are displayed in separate sections within the HTML file.

To use the user interface, open the index.html file in a web browser, enter the city name, and click the corresponding button to fetch the forecast data.
