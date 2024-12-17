<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Bake Shop</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/index.css">
</head>
<body>
<div class="login">
    <span class="material-symbols-outlined">
        Bakery Shop
    </span>
    <p>Please enter your name below to enter the store.</p>
    <form method = "POST" action="/hello-servlet">
        <div class="display">
            <input type="text" id="name" name="name" class="type" placeholder="Your Name" required>
            <button type="submit" class="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>