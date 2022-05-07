import { combineReducers } from "redux";
import { ProductReducer } from "./ProductReducer";
// we need to combine all the reducers in a single place

export const reducer = combineReducers({
    productsData : ProductReducer,
})