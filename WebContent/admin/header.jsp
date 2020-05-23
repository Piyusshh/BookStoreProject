<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<div>
	<img src="../images/BookstoreAdminLog.png" />
	</div>
	<div>
	Welcome, <c:out value="${sessionScope.useremail}" /> | <a href="logout">Logout</a>
	<br/><br/>
	</div>
	<div id="headermenu">
		<div>
			<a href="list_users">
				<img src="../images/user.png" height="45" width="40" /><br/>Users
			</a>
		</div>
		<div>
			<a href="list_category">
				<img src="../images/category.png" height="45" width="40" /><br/>Categories
			</a>
		</div>
		<div>
			<a href="list_books">
				<img src="../images/book.png" height="45" width="40" /><br/>Books
			</a>
		</div>
		<div>
			<a href="customer">
				<img src="../images/customer.png" height="45" width="40" /><br/>Customers
			</a>
		</div>
		<div>
			<a href="reviews">
				<img src="../images/review.png" height="45" width="40" /><br/>Reviews
			</a>	
		</div>
		<div>
			<a href="orders">
				<img src="../images/order.png" height="45" width="40" /><br/>Orders
			</a>
		</div>
	</div>
</div>
