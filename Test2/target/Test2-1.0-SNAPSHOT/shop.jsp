<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/CSS/shop.css">
</head>
<body>

<div class="header">
  <div class="botheader">
    <p id="name">Welcome, ${name}</p>
    <p id="balance">Balance: $${balance}</p>
  </div>
  <div class="navbar">
    <p>The Bake Shop</p>
    <ul>
      <li><a href="HTML/aboutPage.html">About</a></li>
    </ul>
  </div>
  <div class="navbar-b">
    <div class="dropdown">
      <select name="">
        <option value = "1"> All Products</option>
        <option value = "2"> Sandwich Breads</option>
        <option value = "3"> Pastries</option>
        <option value = "4"> French Bread</option>
      </select>
    </div>
    <div class="play"><span class="material-symbols-outlined">
                    casino
                    </span><p>Play!</p></div>
    <div class="cart"><span class="material-symbols-outlined">
                    shopping_cart</span>
      <p id="count">${count}</p>
    </div>
  </div>
</div>

<!-- Slot/Play Button Popup -->
<div id="slotModal" class="modal" style="display: none;">
  <div class="modal-content">
    <span id="closeModal" class="close">&times;</span>
    <h2>Play!</h2>
    <p>Guess a number between 1 and 10:</p>
    <input type="number" id="guess" min="1" max="10" placeholder="Your guess">
    <button id="playGameButton">Play</button>
    <p> id="result"</p>
  </div>
</div>

<div class="container">
  <div id="root"></div>
  <div class="sidebar">
    <div class="head"><p>My Cart</p></div>

    <div class="foot">
      <h3>Total</h3>
      <h2 id="total" >$${cartPrice}</h2>
    </div>
    <div class="checkout">
      <form action="/check-out-servlet" method="GET">
        <button type="submit" id="checkoutButton">Checkout</button>
      </form>
    </div>
  </div>
</div>
<script src ="JS/shop.js"></script>
</body>
</html>