const product = [
    { id: 1, image: '/PNG/baguette.png', title: 'Baguette', price: 5.99 },
    { id: 2, image: '/PNG/brioche.png', title: 'Brioche', price: 6.99 },
    { id: 3, image: '/PNG/cherryDanish.png', title: 'Cherry Danish', price: 3.25 },
    { id: 4, image: '/PNG/croissant.png', title: 'Croissant', price: 4.25 },
    { id: 5, image: '/PNG/painAuChocolat.png', title: 'Pain Au Chocolat', price: 5.25 },
    { id: 6, image: '/PNG/sourdough.png', title: 'Sourdough', price: 7.99 },
    { id: 7, image: '/PNG/wheatBread.png', title: 'Wheat Bread', price: 5.99 },
    { id: 8, image: '/PNG/whiteBread.png', title: 'White Bread', price: 5.99 },
];

let cart = [];

document.getElementById('root').innerHTML = product.map((item, i) => {
    const { image, title, price } = item;
    return `
        <div class="box">
            <div class="img-box">
                <img class="images" src="${image}" alt="${title}">
            </div>
            <div class="bottom">
                <p>${title}</p>
                <h2>$${price.toFixed(2)}</h2>
                <button onclick="addToCart(${i})">Add to Cart</button>
            </div>
        </div>
    `;
}).join('');

function addToCart(index) {
    cart.push(product[index]);
}
//
// function removeItem(index) {
//     cart.splice(index, 1);
//     displayCart();
// }

// function displayCart() {
//     let total = 0;
//     document.getElementById("count").textContent = cart.length;
//
//     if (cart.length === 0) {
//         document.getElementById('cartItem').innerHTML = "Your cart is empty";
//         document.getElementById("total").textContent = "$0.00";
//     } else {
//         document.getElementById('cartItem').innerHTML = cart.map((item, index) => {
//             total += item.price;
//             return `
//                 <div class="cart-item">
//                     <div class="row-img">
//                         <img class="rowimg" src="${item.image}" alt="${item.title}">
//                     </div>
//                     <p>${item.title}</p>
//                     <h2>$${item.price.toFixed(2)}</h2>
//                     <span class="material-symbols-outlined" onclick="removeItem(${index})">delete</span>
//                 </div>
//             `;
//         }).join('');
//         document.getElementById("total").textContent = `$${total.toFixed(2)}`;
//         localStorage.setItem('cartTotal', total.toFixed(2));
//     }
// }

document.getElementById('checkoutButton').addEventListener('click', () => {
    const cartTotal = parseFloat(localStorage.getItem('cartTotal')) || 0;

    if (cartTotal === 0) {
        alert("Your cart is empty.");
        return;
    }

    localStorage.setItem('checkoutTotal', cartTotal.toFixed(2));
    window.location.href = "checkout.html";
});

function renderProducts(productsToRender) {
    document.getElementById('root').innerHTML = productsToRender.map((item, i) => {
        const { image, title, price } = item;
        return `
        <div class="box">
                <div class="img-box">
                    <img class="images" src="${image}" alt="${title}">
                </div>
                <div class="bottom">
                    <p>${title}</p>
                    <h2>$${price.toFixed(2)}</h2>
                    <form method = "POST" action="/product-servlet">
                        <input type="hidden" name="title" value="${title}">
                        <input type="hidden" name="price" value="${price.toFixed(2)}">
                        <button type="submit">Add to Cart</button>
                </form>
                </div>
            </div>
        `;
    }).join('');
}

// Sorting based on dropdown selection
function handleDropdownChange(event) {
    const selectedValue = event.target.value;
    let filterdProducts;

    switch (selectedValue) {
        case "1": // All Products
            filteredProducts = product;
            break;
        case "2": // Sandwich Breads
            filteredProducts = product.filter(item =>
                item.title.toLowerCase().includes('bread') ||
                item.title.toLowerCase().includes('sourdough') ||
                item.title.toLowerCase().includes('brioche')
            );
            break;
        case "3": // Pastries
            filteredProducts = product.filter(item =>
                item.title.toLowerCase().includes('danish') ||
                item.title.toLowerCase().includes('pain au chocolat')
            );
            break;
        case "4": // French Bread
            filteredProducts = product.filter(item =>
                item.title.toLowerCase().includes('baguette') ||
                item.title.toLowerCase().includes('croissant')
            );
            break;
        default:
            filteredProducts = product;
    }
    renderProducts(filteredProducts);
}
document.querySelector('.dropdown select').addEventListener('change', handleDropdownChange);
renderProducts(product);

function initializeSlotMachine() {
    const playButton = document.querySelector('.play');
    const modal = document.getElementById('slotModal');
    const closeModal = document.getElementById('closeModal');
    const playGameButton = document.getElementById('playGameButton');

    playButton.addEventListener('click', () => {
        modal.style.display = 'flex';
    });

    closeModal.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    playGameButton.addEventListener('click', () => {
        const guess = parseInt(document.getElementById('guess').value, 10);
        const resultDisplay = document.getElementById('result');
        let balanceElement = document.getElementById('balance');

        let currentBalance = parseFloat(balanceElement.textContent.replace('Balance: $', '')) || 0;

        if (!guess || guess < 1 || guess > 10) {
            resultDisplay.textContent = 'Please enter a valid guess from 1-10.';
            return;
        }

        const randomNumber = Math.floor(Math.random() * 10) + 1;

        if (guess === randomNumber) {
            currentBalance += guess * 2;
            resultDisplay.textContent = `Congratulations! You guessed ${randomNumber} correctly and won $${guess * 2}!`;
        } else {
            resultDisplay.textContent = `Sorry, the correct number was ${randomNumber}.`;
        }

        balanceElement.textContent = `Balance: $${currentBalance.toFixed(2)}`;
        localStorage.setItem('balance', currentBalance.toFixed(2));
    });
}