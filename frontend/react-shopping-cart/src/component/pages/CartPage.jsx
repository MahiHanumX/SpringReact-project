import React  from "react";

import { useCart } from "../context/CardContext";
import '../../style/cart.css'

const CartPage = () => {
    const { cart, dispatch } = useCart();

    const incrementItem = (product) => {
        dispatch({ type: 'INCREMENT_ITEM', payload: product });
    }

    const decrementItem = (product) => {

        const cartItem = cart.find(item => item.id === product.id);
        if (cartItem && cartItem.quantity > 1) {
            dispatch({ type: 'DECREMENT_ITEM', payload: product });
        } else {
            dispatch({ type: 'REMOVE_ITEM', payload: product });
        }
    }

    const totalPrice = cart.reduce((total, item) => total + item.price * item.quantity, 0);
    return (
        <div className="cart-page">
            <h1>Cart</h1>
            {cart.length === 0 ? (
                <p>Your cart is empty</p>
            ) : (
                <div>
                    <ul>
                        {cart.map(item => (
                            <li key={item.id}>
                                <img src={item.image} alt={item.name} />
                                <div>
                                    <h2>{item.name}</h2>
                                    <p>{item.description}</p>
                                    <div className="quantity-controls">
                                        <button onClick={()=> decrementItem(item)}>-</button>
                                        <span>{item.quantity}</span>
                                        <button onClick={()=> incrementItem(item)}>+</button>
                                    </div>
                                    <span>${item.price.toFixed()}</span>
                                </div>
                            </li>
                        ))}
                    </ul>
                    <h2>Total: ${totalPrice.toFixed(2)}</h2>
                </div>
            )}
        </div>
    )
}

export default CartPage;
