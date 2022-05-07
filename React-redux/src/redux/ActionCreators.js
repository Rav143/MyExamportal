// Actions Creators are functions which will returns a plain object
import { ActionTypes } from "./ActionTypes"

 export const addToCart = (product)=>{
    return{
        type : ActionTypes.ADD_TO_CART,
        payload : product
    }
}
