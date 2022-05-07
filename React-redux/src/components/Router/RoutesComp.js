import React from 'react'
import { Route,Routes } from 'react-router-dom'
import Products from '../Products/Products'
import Product from '../Products/Product'
import Cart from '../Cart/Cart'

function RoutesComp() {
  return (
    <div>
        <Routes>
            <Route path="/products" element={<Products />} />
            {/* Dynamic Routing */}
            <Route path="/products/:id" element={<Product />} />
            <Route path="/cart" element={<Cart />} />
        </Routes>
    </div>
  )
}

export default RoutesComp