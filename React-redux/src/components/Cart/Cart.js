import React from 'react'
import {useSelector}  from 'react-redux'
 
function Cart() {
    const cartData = useSelector((state)=>state.productsData.cartData);
    console.log(cartData);
  return (
    <div>
        <div class="container">
            
            {cartData && cartData.length>0 && cartData.map((product)=>(
                <div className='row my-4'>
            <div className='col-md-4'>
                <img className='img-fluid' src={product.image} />
            </div>
            <div className='col-md-8'>
                <h3 className='mt-3'>{product.title}</h3>
                <p>price: {product.price}</p>
                <p>{product.description}</p>
            </div>
            </div>
            )) }
           
        </div>
    </div>
  )
}

export default Cart