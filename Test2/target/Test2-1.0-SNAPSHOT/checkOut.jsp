<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&display=swap">
    <link rel="stylesheet" href="/CSS/checkOut.css">
</head>
<body>
<div class="checkout-container">
    <header class="checkout-header">
        <h1>Checkout</h1>
        <p id="welcome-message">Welcome, ${name}</p>
    </header>

    <div class="back-to-cart">
        <form method = "GET" action="/second-hello-servlet">
            <button class="button" type = "submit">Back To Cart</button>
        </form>
    </div>

    <section class="order-summary">
        <h2>Order Summary</h2>
        <div id="cart-summary"></div>
        <div class="total">
            <h3>Total:</h3>
            <p id="total-price">${cartPrice}</p>
        </div>
    </section>

    <section class="checkout-form">
        <h2>Shipping Information</h2>
        <form id="checkoutForm">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required placeholder="Your Full Name">

            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required placeholder="Your Email">

            <label for="address">Shipping Address</label>
            <textarea id="address" name="address" required placeholder="Your Address"></textarea>

            <button type="submit" class="button">Place Order</button>
        </form>
    </section>
</div>

<script>
    document.getElementById('checkoutForm').addEventListener('submit', (event) => {
        event.preventDefault();

        if ( ${balance} < ${cartPrice} )  {
            alert("Not enough money.");
            return;
        }

        alert(`Thank you for your order! Remaining balance: $${newBalance} `);
    });
</script>
</body>
</html>
