import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios';
import { addToCart } from '../../redux/ActionCreators';
import { useDispatch } from 'react-redux';


function Product() {
    
    const dispatch = useDispatch();
    const [product,setProduct] = useState({});
    const {id} = useParams();

    const data = useParams();
    // console.log(data);

    const getTheSingleProduct = async()=>{
        const {data} =  await axios.get(`https://fakestoreapi.com/products/${id}`)
        setProduct(data);
        console.log(data)
    }

    useEffect(()=>{
        getTheSingleProduct();
    },[])

    const handleClick = (product)=>{
        // console.log(product)
        console.log(addToCart(product))
        dispatch(addToCart(product));
    }

    return (
    <div>
        <div className='container'>
            {Object.keys(product).length>0 ?(
                <div className='row border border-primary mt-2'>
                    <div className='col-md-6'>
                        <img src={product.image} className="product-image"alt={product.title} />
                    </div>

                    <div className='col-md-6'>
                        <div className='mt-3'>
                            <h3 className='p-2'>{product.title}</h3>
                        </div>
                        <div className='mt-3'>
                            <span className='p-2 bg-info'> Price :$ {product.price}</span>
                        </div>

                        <div className='mt-3'>
                            <h2 className='p-2'>  {product.category}</h2>
                        </div>

                        <div className='mt-3'>
                            <span className='p-2'> {product.description}</span>
                        </div>

                        <div className='mt-3'>
                            <span className='button btn btn-info px-3.py;' onClick={
                                ()=>handleClick(product)
                            }>Add to Cart</span>
                        </div>
                    </div>
                </div>
            ):null
         }
        </div>
    </div>
  )
}

export default Product