import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

function Products() {
    const [products,setProducts] = useState([]);

    const getProducts = async() =>{
        const {data} = await axios.get('https://fakestoreapi.com/products');
        setProducts(data);     
        }

    useEffect(()=>{
        getProducts();
    },[])

  return (
    <div>
        <div className="container my-5 py-5">
            <div className='row'>
                {
                    products && products.length>0 && products.map((product)=>(
                        <div className='col-md-3'>
                            {/* <div className='card h-100 text-center p-4' key={product.id}> */}
                            <Link className='text-dec' to={`/products/${product.id}`}>
                                 <div className='card h-100 text-center p-4' key={product.id}>
                          
                            <img src={product.image} className="card-img-top " alt={product.title} height="250px" />
                            <div className="card-body">
                                <h5 className="card-title">{product.title}</h5>
                                <h3>price : ${product.price}</h3>
                                <p className="card-text">{product.category}</p>
                                <h6>Rating : {product.rating.rate}</h6>
                                <a href="!#" class="btn btn-outline-dark">
                                    Buy Now
                                    </a>
                            </div>
                            </div>
                            
                           
                            </Link>
                        </div>
                    ))
                }
            </div>
        </div>
    </div>
  )
}

export default Products