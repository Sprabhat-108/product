# product
Problem : Machine test project
In a table of 1 lac product 
data(productId,lat,lon,createdDate,productTitle,description,price,unit),
every product has a pair of coordinates.

1. Write api which will create an entry into product table(API should 
not take more than 150 ms).
2. Write a api which will fetch all the records withing a radius of X kms
of a particular Input Cordinate Set(API should not take more than 200 ms).

a.You can use H2 database or MySql on localhost.
c. It can be a Springboot, Spring MVC or JAX-RS application


Ex: I would like to fetch all products that are located within 5 kms 
radius of my gps point.
This should be a single query fetching all products within 5 kms 
radius of the cordinates provided

Workflow :

##############################################
DB Name = product_db
Table Create
CREATE TABLE `product` (
  `product_Id` int(11) NOT NULL,
  `product_lat` decimal(10,8) NOT NULL,
  `product_lon` decimal(11,8) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `product_title` varchar(100) NOT NULL,
  `product_description` varchar(200) DEFAULT NULL,
  `product_price` float(10,2) NOT NULL,
  `product_unit` int(11) NOT NULL
)


Rest service for add product:
URL = http://localhost:8080/product/api/addproduct
Request parameter = 
{
"productLat" : "19.56",
"productLon" : "29.36",
"productTitle" : "New Product",
"productDescription" : "newly created product",
"productPrice" : "22.00",
"productUnit" : "16"
}

Response = The product has been added successfully.

Rest service for fetch all product within radius and longitude-latitude
URL = http://localhost:8080/product/api/listproduct

Request parameter = 
{
"lat" : "11.56",
"lon" : "12.36",
"radius" : "2"
	
}

Response = 
[
    {
        "productId": 4,
        "productLat": 11.87,
        "productLon": 12.95,
        "createDate": "2021-01-30T22:30:39.000+00:00",
        "productTitle": "New Product1",
        "productDescription": "newly created product1",
        "productPrice": 20.0,
        "productUnit": 18
    },
   
    {
        "productId": 7,
        "productLat": 11.56,
        "productLon": 12.36,
        "createDate": "2021-01-30T22:47:33.000+00:00",
        "productTitle": "New Product",
        "productDescription": "newly created product",
        "productPrice": 22.0,
        "productUnit": 16
    }
]
############################################
