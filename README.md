# market
Project Market

create database in postgreSQL named "market";

pull the project github to eclipse, netbean or other;

run class as Java Application "ApirestApplication.java";

access http://localhost:8080/swagger-ui.html

suggestions:
add munufacturer:
        
          {
            "name": "The Coca-Cola Company"
          }
          
          {
            "name": "PepsiCo"
          }
          
          {
            "name": "Monster Beverage"
          }
          
          
add product:
      
          {
            "name": "Coca-Cola",
            "description": "Coca-Cola 2,5l PET",
            "barcode": "7002085002671",
            "manufacturer": {
             "id": "id munufacturer" 
             },
          "unitPrice": 5.99
          }
          
          
          {
            "name": "Pepsi-Cola",
            "description": "Pepsi-Cola 2,0l PET",
            "barcode": "7002085002672",
            "manufacturer": {
             "id": "id munufacturer" 
             },
          "unitPrice": 4.99
          }
          
          
          {
            "name": "Monster Energy",
            "description": "Monster Energy Drink 269ml CAN",
            "barcode": "7002085002673",
            "manufacturer": {
             "id": "id munufacturer" 
             },
          "unitPrice": 5.99
          }


add Order:

          {
  "items": [
    
 {
      "product": {
        "id": 5
      },
      "units": 1
    },
      { 
      "product": {  
        "id": 4 
      },
      "units": 1
    }
  ],
  "consumer": {
    "name": "Ariel Zanrosso",
    "phone": "+5542991072505",
    "email": "arielzanrosso@gmail.com"
  },
  "payment": {
    "mode": "bank slip",
    "installments": 2
  },
  "delivery": {
    "mode": "in-store withdrawal"
  },

 "status": "ok"

}



