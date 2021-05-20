# Team Project Debuggers 
 
**TEAM JOURNAL**

Features implemented:
- Cashiers Application: For the cashiers application we created an app that visually lets the cashier choose whatever drink the customer would like. The customer can pick from 6 different drinks and the cashier just clicls on the drink image to select it. The cashier can then customize the drink. The drink can have a different array of milks like soy, whole milk, 2% and almond milk. Then the price will be calculated it for the cashier and displayed in the reciept as well as display what register they are on then the order can be placed.
- Backoffice: The backoffice is connected to the same application as the cashiers app. Once you are in the cashiers you can go to to the backoffice and from there you can look at the different cards and add money or subtract money from them. You can activate cards from there. Only when cards are activated on the backoffice will they be able to be looked at on the online store.
- Rest API: The one used is shown below
```
POST    /order/register/{regid}
        Create a new order. Set order as "active" for register.

        Request:

	    {
	      "Drink": "Latte",
	      "Milk":  "Whole",
	      "Size":  "Grande"
	    }         

	    Response:

		{
		  "Drink": "Latte",
		  "Milk": "Whole",
		  "Size": "Grande",
		  "Total": 2.413125,
		  "Status": "Ready for Payment."
		}	    

GET     /order/register/{regid}
        Request the current state of the "active" Order.

		{
		  "Drink": "Latte",
		  "Milk": "Whole",
		  "Size": "Grande",
		  "Total": 2.413125,
		  "Status": "Ready for Payment."
		}

DELETE  /order/register/{regid}
        Clear the "active" Order.

		{
		  "Status": "Active Order Cleared!"
		}

POST    /order/register/{regid}/pay/{cardnum}
        Process payment for the "active" Order. 

        Response: (with updated card balance)

		{
		  "CardNumber": "627131848",
		  "CardCode": "547",
		  "Balance": 15.17375,
		  "Activated": true,
		  "Status": ""
		}

GET     /orders
        Get a list of all active orders (for all registers)

		{
		  "5012349": {
		    "Drink": "Latte",
		    "Milk": "Whole",
		    "Size": "Grande",
		    "Total": 4.82625,
		    "Status": "Paid with Card: 627131848 Balance: $15.17."
		  }
		}

DELETE 	/orders
		Delete all Orders (Use for Unit Testing Teardown)

		{
		  "Status": "All Orders Cleared!"
		}
```  
- Online store: The online store allows the customer to take care of their needs when it comes to payment methods. The online store allows the customer to add a card and remove a card. The card can be refilled and you can add money using a verified credit card. The verification is done using cybersource and it will only work when a cybersource approved card is used. You can even select between different cards. When you enter an invalid card information it will give you an error and will only be sent to the MySql database if it is all approved.
- Integrations: We used cybersource to validate all the card information that was inputted


Technical requirements:
- We used MYSQL database to store all the data
- Used different spring frameworks like spring jpa, thymaleaf, validation and lombok
- We used gradle version 5.6 and java version jdk 11
- Used docker containers to deploy our application on google cloud but would not run do to the pods crashing



Screenshots  :
This is the basic online store
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/online%20store%201.PNG)
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/add%20card.PNG)
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/payment%20page.PNG)
- Our online store page which includes adding and deleting starbucks cards as well as adding more credits into a starbuck card.
The cybersource integration 
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/cyber1.png)
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/cyber2.png)   
The online store and back office
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/cashiers%201.PNG)
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/cashier%202.PNG)
- The cashier app's front page which displays all the available drinks that users can purchase.
- Upon selecting a drink, users will be required to input what type of milk they want and the size of their drink.
- Once the customer confirms their order, the order will directly go to the database.
 
Lastly this shows the databases, these hold the order information, customer information and the card information that is shared to both the backoffice and the online store!
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/db%201.PNG)
- The image above shows the list of cards in the database.
- The database itself shows many important points of information such as the card number, the balance, and whether the card is active to name a few.
- Additonally, cards will automatically be removed upon the user selecting "Delete Card" on the online store page.
 
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/db%202.PNG)
- This page of the data base shows successful payments by each user.
- The users' personal information such as name, address, credit card information will be stored here.
- This database can allow employees to check a specific user when needed.
 
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/db%203.PNG)
- Our last database shows any and all confirmed orders from the cashier's app.
- Orders will vary from the different type of drinks to size to the type of milk.
- Every order processed will go through to this database.
 
For the gradle and spring frameworks we used, the image below shows them.
![alt text](https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/screenshots/gradle.png)










Individual Journals


**Week 1 Journals:**

Jashan Dhillon-  https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/jashan-week1.md  
Brielle Purnell-  https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/brielle-week1.md  
Johnny Vu - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/johnny-week1.md  
Zeyu Cheng - https://github.com/nguyensjsu/sp21-172-debuggers/blob/zeyu-branch/journals/Week%201%20journal%20-%20Zeyu%20Cheng.md


**Week 2 Journals:**

Jashan Dhillon - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/jashan-week2.md  
Brielle Purnell - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/brielle-week2.md  
Johnny Vu - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/johnny-week2.md  
Zeyu Cheng - https://github.com/nguyensjsu/sp21-172-debuggers/blob/zeyu-branch/journals/Week%202%20journal%20-%20Zeyu%20Cheng.md


**Week 3 Journals:**

Jashan Dhillon - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/jashan-week3.md  
Brielle Purnell - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/brielle-week3.md  
Johnny Vu - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/johnny-week3.md           
Zeyu Cheng - https://github.com/nguyensjsu/sp21-172-debuggers/blob/zeyu-branch/journals/Week%203%20journal%20-%20Zeyu%20Cheng.md

**Week 4 Journals:**

Jashan Dhillon- https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/jashan-week4.md  
Johnny Vu - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/johnny-week4.md  
Brielle Purnell - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/brielle-week4.md   
Zeyu Cheng - https://github.com/nguyensjsu/sp21-172-debuggers/blob/zeyu-branch/journals/Week%204%20journal%20-%20Zeyu%20Cheng.md

**Week 5 Journals:**

Brielle Purnell - https://github.com/nguyensjsu/sp21-172-debuggers/blob/main/journals/brielle-week5.md 

